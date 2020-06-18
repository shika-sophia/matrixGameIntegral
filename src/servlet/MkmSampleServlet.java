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

import model.StoneBeans;//beans
import model.StoneBoolean;
import model.StoneLogic;//model

@WebServlet("/MkmSampleServlet")
public class MkmSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {

		request.setCharacterEncoding("UTF-8");



	}//doget

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {//
		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		//仮の値を指定
		String  stoneSelect="none";
		int select=0;
		//select,stoneSelectが未入力ならmatrix.jspへフォワード

		//selectの取得
		select=Integer.parseInt(request.getParameter("select")) ;
		//stoneSelectの取得
		stoneSelect=request.getParameter("stoneSelect");

		if(stoneSelect.equals("none")) {//if未入力
			//matrix.jspへフォワード
			String path = "/fail.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}else if(select==0) {
			//matrix.jspへフォワード
			String path = "/fail.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}//if未入力

	    List<Integer> stoneAreaDB = new ArrayList<>(30);
	    //List<String> stoneArea = new ArrayList<>(30);
	    //配列の０番目をダミーに
	    //stoneArea.add(0, "none");
	    stoneAreaDB.add(0, 9);

	    for (int i = 1; i <= 25; i++) {
            stoneAreaDB.add(0);
        }//for
		StoneBeans stb=new StoneBeans(stoneSelect,stoneAreaDB,select);

		//StoneBooleanの呼び出し
		StoneBoolean stoneboolean=new StoneBoolean();
		//StoneBooleanを起動
		boolean hannbetu=stoneboolean.execute(stb);
		//hannbetuしてできないなら分岐する
		if(hannbetu=false) {
			//matrix.jspへフォワード
			String path = "/matrix.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}
		//StoneLogicの呼び出し,stoneLogic作成
		StoneLogic stoneLogic=new StoneLogic();
		//StoneLogicを起動、stoneAreaDB
		stoneAreaDB=stoneLogic.execute(stb);
		/*//putColorStoneの呼び出し,pcst作成
		StoneputColor pcst= new StoneputColor();
		/*起動、stoneArea
		stoneArea=pcst.execute(stb);*/
/*
		//StonePartsの呼び出し
		StoneParts stp=new StoneParts();
		//実行
		int[] stoneparts=stp.execute(stb);*/


		//stoneAreaDBをアプリケーションスコープに取得
		ServletContext application= request.getServletContext();
		//stoneArea,stoneAreaDBをアプリケーションスコープに保存
		application.setAttribute("stoneAreaDB",stoneAreaDB);
		//セッションスコープに」


		//matrix.jspへフォワード
		String path = "/matrix.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
		/*

		//SampleResult.jspへフォワード仮ページのため本実装時は上記と入れ替え
		String path = "/sampleResult.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);*/

		/*if(stoneSelect=="tri") {

		}else if(stoneSelect=="twice") {

		}else if(stoneSelect=="mono") {

		}//if*/

	}//dopost

}//MkmSampleServlet
/*
@WebServlet("/ColorServlet")
public class ColorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ColorLogic colorLogic = new ColorLogic();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {









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

        color = colorLogic.paintColor(select, colorDB);

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

}//class*/




