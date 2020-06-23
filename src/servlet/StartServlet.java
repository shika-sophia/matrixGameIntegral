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
import javax.servlet.http.HttpSession;

import model.ColorLogic;
import model.LoadLogic;
import model.MatrixBeans;
import model.NewGame;
import model.User;


@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

    // ###### Test Parts ######
    // ====== make User Beans for Test Demo======
    User user = new User();
    user.setName("sample");
    user.setPass("sample");
    user.setAccountId("sample");
    user.setPoint(10000);
    user.setPuzzleId(999);

    HttpSession session = request.getSession();
    session.setAttribute("user", user);

    //###### 実装 Parts ######
    //HttpSession session = request.getSession();
    session.getAttribute("user");

    // ====== choice Load or NewGame======
    LoadLogic loadLogic = new LoadLogic();
    MatrixBeans matrixDB = loadLogic.loadSetting(user);

    // ---- session scope of matrixDB ----
    session.setAttribute("matrixDB", matrixDB);

    //choice.jspへフォワード
    String path = "choiceGame.jsp";
    RequestDispatcher dis = request.getRequestDispatcher(path);
    dis.forward(request, response);

    }//doGet()


  protected void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
      // ---- get parameter ----
      request.setCharacterEncoding("UTF-8");
      String choiceGame = request.getParameter("choiceGame");

      // ---- session scope get parameter----
      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");
      MatrixBeans matrixDB = (MatrixBeans) session.getAttribute("matrixDB");

      // ---- switch LoadGame or NewGame ----
      switch (choiceGame) {
        case "LoadGame":

          break;

        case "NewGame":
          NewGame newGame = new NewGame();
          matrixDB = newGame.newGameSetting(matrixDB);
          break;
      }//switch()

      // ---- get parameter from MatrixBeans ----
      List<Integer> colorDB = matrixDB.getColorDB();
      List<Integer> stoneAreaDB = matrixDB.getStoneAreaDB();

      String stoneSelect = "";

      // ---- call paint method ----
      ColorLogic colorLogic = new ColorLogic();
      List<String> color = colorLogic.paintColor(colorDB);
      List<String> stoneArea = colorLogic.paintStoneArea(stoneAreaDB);
      List<String> stoneSelectColor = colorLogic.paintStoneSelect(stoneSelect);

      // ---- set session / applicaton scope ----
      session.setAttribute("matrixDB", matrixDB);

      ServletContext application = request.getServletContext();
      application.setAttribute("color", color);
      application.setAttribute("stoneArea", stoneArea);
      application.setAttribute("stoneSelectColor", stoneSelectColor);

      //matrix.jspへフォワード
      String path = "matrix.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);

    }//post

}
