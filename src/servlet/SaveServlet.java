package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SaveDAO;
import model.MatrixBeans;
import model.SaveCalc;
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
        case "Reverse":
          message = "";
        break;

        case "Reset":
          message = "このゲームをやり直しますか？";
          break;

        case "Save":
          message = "セーブしますか？";
          break;

        case "Logout":
          message = "ログアウトしますか？";
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
      MatrixBeans matrixDB = (MatrixBeans) session.getAttribute("matrixDB");
      String controle = (String) session.getAttribute("controle");

      // ---- switch (controle) ----
      switch (controle) {
        case "Save":
          if (comfirm.equals("YES")) {
              int puzzleId = user.getPuzzleId();
              List<Integer> colorDB = matrixDB.getColorDB();

              SaveCalc saveCalc = new SaveCalc();
              int decimal = saveCalc.changeDecimal(colorDB);

              SaveDateTime sdt = new SaveDateTime();
              String saveDateTime = sdt.saveDateTime();

              SaveDAO dao = new SaveDAO();
              boolean isSave = dao.saveGame(puzzleId, decimal, saveDateTime);

              if (isSave) {
                String message = "セーブ完了";
                System.out.println(message);//松原

                request.setAttribute("message", message);

                String path = "/matrix.jsp";
                RequestDispatcher dis = request.getRequestDispatcher(path);
                dis.forward(request, response);
              }//if isSave

          } else if (comfirm.equals("NO")) {
              String message = "";
              System.out.println(message);//松原
              request.setAttribute("message", message);

              String path = "/matrix.jsp";
              RequestDispatcher dis = request.getRequestDispatcher(path);
              dis.forward(request, response);
          }//if comfirm
          break;

        case "Logout":
          if (comfirm.equals("YES")) {
            String path = "/matrixGameIntegral/LogoutServlet";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            dis.forward(request, response);
          }
          break;

        case "Reset":
          if (comfirm.equals("YES")) {
            String path = "/matrixGameIntegral/StartServlet";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            dis.forward(request, response);
          }
          break;

        case "Reverse":
          break;

      }//switch

  }//doPost()

}//class
