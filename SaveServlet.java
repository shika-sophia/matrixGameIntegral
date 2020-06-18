package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SaveDateTime;
import model.User;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String controle = request.getParameter("controle");

      String message = "";

      switch(controle) {
        case "Save":
          message = "セーブしますか？";
          break;

        case "Logout":
          message = "ログアウトしますか？";
          break;

        case "Reset":
          message = "このゲームをやり直しますか？";
          break;
      }//switch

      request.setAttribute("message", message);

      HttpSession session = request.getSession();
      session.setAttribute("controle", controle);


      String path ="/matrix.jsp";
      RequestDispatcher dis = request.getRequestDispatcher(path);
      dis.forward(request, response);

  }//doGet()


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // ---- get Parameters ----
      request.setCharacterEncoding("UTF-8");
      String comfirm = (String) request.getParameter("comfirm");

      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");

      String controle = (String) session.getAttribute("controle");

      String saveDateTime = "";

      // ---- switch (controle) ----
      switch (controle) {
        case "Save":
          if (comfirm.equals("YES")) {
              SaveDateTime sdt = new SaveDateTime();
              saveDateTime = sdt.saveDateTime();

          } else if (comfirm.equals("NO")) {
              ;
          }
          break;

        case "Logout":
          break;

        case "Reset":
          break;

      }//switch

      //---- call method ----

      //boolean isSave = SaveDAO.saveGame(matrixDB);

      //if (isSave) {

      //}

  }//doPost()

}//class
