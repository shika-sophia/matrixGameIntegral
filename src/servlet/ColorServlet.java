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
import model.Melt;
import model.SaveDateTime;
import model.User;


@WebServlet("/ColorServlet")
public class ColorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ColorLogic colorLogic = new ColorLogic();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // ###### Test Parts ######
        User user = new User();
        user.setName("shika");
        user.setPass("shika");
        user.setAccountId("shika");
        user.setPoint(10000);
        user.setPuzzleId(99);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        boolean existData = false;

        // ###### End of Test Parts ######

        // ---- get parameters ----
        request.setCharacterEncoding("UTF-8");
        user = (User) session.getAttribute("user"); //実装時 文頭にUserを追加

        int select = 0;
        int puzzleId = user.getPuzzleId();
        //実装時追加　boolean existData = request.getParameter("existData");

        List<Integer> colorDB = new ArrayList<>(30);
        List<String> color = new ArrayList<>(30);

        //if (existData) {
        //    LoadDAO loadDao = new LoadDAO();
        //   colorDB = loadDao.loadData(puzzleId);

        //} else {
        //    NewGameDAO newGameDao = new NewGameDAO();
        //    colorDB = newGameDao.newGameData(puzzleId);

        //} //else <NewGame>

        //---- 初期colorDBを生成 ----
        for (int i = 0; i <= 25; i++) {
            colorDB.add(0);
        }//for

        //---- 初期stoneAreaを仮に定数生成 ----
        int[] stoneAreaDB = {9,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        List<String> stoneArea = new ArrayList<>(30);
        stoneArea.add(0, "none");

        for (int i = 1; i <= 25; i++) {
            if (stoneAreaDB[i] == 1) {
                stoneArea.add("hotpink");
            } else if (stoneAreaDB[i] == 0) {
                stoneArea.add("mistyrose");
            }
        }//for

        String stoneSelect = "tri";

        List<String> stoneSelectColor = colorLogic.paintStoneSelect(stoneSelect);



        color = colorLogic.paintColor(colorDB);

        SaveDateTime sdt = new SaveDateTime();
        String saveDateTime = sdt.saveDateTime();

        MatrixBeans matrixDB = new MatrixBeans();
        matrixDB.setColorDB(colorDB);
        matrixDB.setPuzzleId(puzzleId);
        matrixDB.setSaveDateTime(saveDateTime);

        //HttpSession session = request.getSession();
        //session.setAttribute("user", user);
        session.setAttribute("matrixDB", matrixDB);

        String message = "";
        request.setAttribute("message", message);

        ServletContext application = request.getServletContext();
        application.setAttribute("color", color);
        application.setAttribute("stoneArea", stoneArea);
        application.setAttribute("stoneSelectColor", stoneSelectColor);

        String path = "/matrix.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
    }//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //---- get select ----
        request.setCharacterEncoding("UTF-8");
        int select = Integer.parseInt(request.getParameter("select"));

        HttpSession session = request.getSession();
        MatrixBeans matrixDB = (MatrixBeans) session.getAttribute("matrixDB");

        //---- call method ----
        List<Integer> colorDB = matrixDB.getColorDB();
        colorDB = colorLogic.changeColor(matrixDB, select, colorDB);
        matrixDB.setColorDB(colorDB);

        Melt melt = new Melt();
        colorDB = melt.meltStone(matrixDB);

        List<String> color = colorLogic.paintColor(colorDB);

        //System.out.println(select);
        //System.out.println(colorDB);
        //System.out.println(color);

        //---- set Application Scope ----
        ServletContext application = this.getServletContext();
        application.setAttribute("color", color);

        //---- set Request Scope ----
        //request.setAttribute("action", action);

        //---- forward to matrix.jsp ----
        String path = "/matrix.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
    }//doPost

}//class



