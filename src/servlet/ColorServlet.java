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

import DAO.ColorDAO;
import model.ColorLogic;
import model.MatrixBeans;


@WebServlet("/ColorServlet")
public class ColorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ColorLogic colorLogic = new ColorLogic();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        //User user = (User) session.getAttribute("user");

        int select = 0;

        //String puzzleId = user.getPuzzleId();
        //boolean existData = request.getParameter("existData");

        //if (existData) {
        //    LoadDAO.loadData(puzzleId);

        //} else {
        //    NewGameDAO.newGameData(puzzleId);

        List<String> color = new ArrayList<>(30);

        ColorDAO colorDao = new ColorDAO();           //この文は いずれ廃止
        List<Integer> colorDB = colorDao.firstColor();//この文は いずれ廃止

        //} //else <NewGame>

        color = colorLogic.paintColor(select, colorDB);

        //
        //HttpSession session = request.getSession();
        //session.setAttribute("user", user);

        String message = "";
        request.setAttribute("message", message);

        ServletContext application = request.getServletContext();
        application.setAttribute("color", color);

        String path = "/matrix.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
    }//doGet


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //---- get select ----
        request.setCharacterEncoding("UTF-8");
        int select = Integer.parseInt(request.getParameter("select"));
        MatrixBeans matrixDB = (MatrixBeans) request.getAttribute("matrixDB");

        //---- call method ----
        List<Integer> colorDB = matrixDB.getColorDB();
        colorDB = colorLogic.changeColor(matrixDB, select, colorDB);
        List<String> color = colorLogic.paintColor(select, colorDB);

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
