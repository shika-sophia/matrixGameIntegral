package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CanStone;
import model.ColorLogic;
import model.MatrixBeans;
import model.Melt;
import model.StoneMove;


@WebServlet("/StoneMoveServlet")
public class StoneMoveServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException {

  }//doGet()


  protected void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException {

    //---- get parameter ----
    request.setCharacterEncoding("UTF-8");
    String stoneMove = request.getParameter("stoneMove");

    HttpSession session = request.getSession();
    MatrixBeans matrixDB = (MatrixBeans) session.getAttribute("matrixDB");

    //---- class ----
    ServletContext application = this.getServletContext();
    CanStone canStone = new CanStone();

    //---- get from matrixDB ----
    List<Integer> colorDB = matrixDB.getColorDB();
    List<Integer> stoneAreaDB = matrixDB.getStoneAreaDB();
    List<Integer> selectList = matrixDB.getSelectList();
    String stoneSelect = matrixDB.getStoneSelect();

    ColorLogic colorLogic = new ColorLogic();
    List<String> color = new ArrayList<>(32);

    //======= enter section ======
    boolean canBlock = canStone.canBlock(matrixDB);

    if (canBlock) {
      if (stoneMove.equals("enter")) {
        for(int select : selectList) {
            colorDB = colorLogic.changeColor(matrixDB, select, colorDB);
        }//for select

        Melt melt = new Melt();
        colorDB = melt.meltStone(matrixDB);

        color = colorLogic.paintColor(colorDB);
        application.setAttribute("color", color);

      }//if enter
    }//if canBlock

    // ====== move section ======
    //---- judge stone Range ----
    boolean canRange = canStone.canRange(stoneSelect, selectList);

    //---- case canRange ----
      //if (canRange) {
        //---- call StoneMove() ----
        StoneMove stm = new StoneMove();
        stoneAreaDB = stm.stoneMove(stoneMove, selectList, stoneAreaDB, matrixDB);

        matrixDB.setStoneAreaDB(stoneAreaDB);
        session.setAttribute("matrixDB", matrixDB);

        //---- paint stoneArea ----

        List<String> stoneArea = colorLogic.paintStoneArea(stoneAreaDB);

        //---- application scope ----

        application.setAttribute("stoneArea",stoneArea);

        String message = "";
        request.setAttribute("message", message);

      //} else {
        //String message = "移動できません";
        //request.setAttribute("message", message);

      //}

      //matrix.jspへフォワード
      String path = "/matrix.jsp";
      RequestDispatcher dis = request.getRequestDispatcher(path);
      dis.forward(request, response);

  }//doPost()

}//class