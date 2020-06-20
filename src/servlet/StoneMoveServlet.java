package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CanStone;
import model.MatrixBeans;
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
    String stoneMove=request.getParameter("stoneMove");

    ServletContext application = this.getServletContext();
    MatrixBeans matrixDB = (MatrixBeans) application.getAttribute("matrixDB");

    //---- get from matrixDB ----
    List<Integer> stoneAreaDB = matrixDB.getStoneAreaDB();
    List<Integer> selectList = matrixDB.getSelectList();
    String stoneSelect = matrixDB.getStoneSelect();

    //---- judge stone Range ----
    CanStone cs = new CanStone();
    boolean canRange = cs.canRange(stoneSelect, selectList);

      if (canRange) {
         StoneMove stm = new StoneMove();
         stoneAreaDB = stm.stoneMove(stoneMove, stoneAreaDB, selectList);

         matrixDB.setStoneAreaDB(stoneAreaDB);
         application.setAttribute("stoneAreaDB",stoneAreaDB);

          //matrix.jspへフォワード
            String path = "/matrix.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            dis.forward(request, response);

        } //else {

            //matrix.jspへフォワード
            String path = "/matrix.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            dis.forward(request, response);

  }//doPost()

}//class