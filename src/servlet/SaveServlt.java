package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveServlt")
public class SaveServlt extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String controle = request.getParameter("controle");

      String message = "";

      switch(controle) {
        case "Save":
          break;

        case "End":
          break;

        case "Reset":
          break;
      }//switch
      message = "セーブしますか？";

      request.setAttribute("message", message);

      String path ="/matrix.jsp";
      RequestDispatcher dis = request.getRequestDispatcher(path);
      dis.forward(request, response);

      if (controle.equals("Save")) {

      }
  }//doGet()


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }//doPost()

}//class
