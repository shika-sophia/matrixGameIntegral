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

import model.ColorLogic;
import model.MatrixBeans;


@WebServlet("/StoneSelectServlet")
public class StoneSelectServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }//doGet()


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    // ---- get parameter ----
    String stoneSelect = (String) request.getParameter("stoneSelect");

    HttpSession session = request.getSession();
    MatrixBeans matrixDB = (MatrixBeans) session.getAttribute("matrixDB");

    List<Integer> selectList = new ArrayList<>(32);

    //---- stoneSelect switch----
    switch (stoneSelect) {
      case "tri":
        selectList.add(13);
        selectList.add(14);
        selectList.add(8);
        break;

      case "twice":
        selectList.add(13);
        selectList.add(8);
        break;

      case "mono":
        selectList.add(13);
        break;

      default:
        break;
    }//switch()

    //---- parameter definition ----
    List<Integer> stoneAreaDB = new ArrayList<>(32);
    stoneAreaDB.add(0, 9);


    //---- initialize 'stoneAreaDB' ----
    for(int i = 1; i <= 25; i++) {
        stoneAreaDB.add(i, 0);
    }//for

    //---- input select to 'stonAreaDB' ----
    for (int select : selectList) {
        stoneAreaDB.set(select, 1);
    }

    //---- input to MatrixBeans ----
    matrixDB.setStoneAreaDB(stoneAreaDB);
    matrixDB.setSelectList(selectList);
    matrixDB.setStoneSelect(stoneSelect);

    session.setAttribute("matrixDB", matrixDB);

     //---- paint stoneArea ----
     ColorLogic colorLogic = new ColorLogic();
     List<String> stoneArea = colorLogic.paintStoneArea(stoneAreaDB);
     List<String> stoneSelectColor = colorLogic.paintStoneSelect(stoneSelect);

     //---- application scope  ----
     ServletContext application = request.getServletContext();
     application.setAttribute("stoneArea", stoneArea);
     application.setAttribute("stoneSelectColor", stoneSelectColor);

     //---- forward to matrix.jsp ----
     String path = "/matrix.jsp";
     RequestDispatcher dis = request.getRequestDispatcher(path);
     dis.forward(request, response);

  }//doPost()

}//class
