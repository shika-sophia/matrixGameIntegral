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

import model.StoneBeans;
import model.StoneLogic;
import model.StoneMove;


@WebServlet("/StoneMoveServlet")
public class StoneMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {
		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		//stoneMoveの取得
		String stoneMove=request.getParameter("stoneMove");
		//StoneBeansの呼び出し
		StoneBeans stb=new StoneBeans();

		//アプリケーションスコープの取得
		ServletContext application=this.getServletContext();
		List<Integer> staDB=
		(List<Integer>)application.getAttribute("stoneAreaDB");
		//↑がなぜ未検査キャストといわれるかわからない

		//beansにstoneMove,stoneAreaDBを格納(StoneBeansは統合予定)
//	    stb.setStoneAreaDB(staDB);//ここ必要か？
	    stb.setStoneMove(stoneMove);
	    /*//StonePartsの呼び出し
	  	StoneParts stp=new StoneParts();
	  	//実行
	  	List<Integer> stoneparts=stp.execute(stb);*/

	    //StoneMoveの呼び出し
		StoneMove stm=new StoneMove();


		//実行
		int select=stm.execute(stb);
		//beansに格納
		stb.setSelect(select);

		//StoneLogicの呼び出し,stoneLogic作成
		StoneLogic stoneLogic=new StoneLogic();
		//StoneLogicを起動、stoneAreaDB
		List<Integer> stoneAreaDB=stoneLogic.execute(stb);

		/*//StoneRoll呼び出し
		StoneRoll str= new StoneRoll();
		//実行
		 stoneAreaDB =str.execute(stb);*/

		//stoneAreaDBをアプリケーションスコープに取得
		ServletContext application1= request.getServletContext();
		//stoneAreaDBをアプリケーションスコープに保存しなおす
		application1.setAttribute("stoneAreaDB",stoneAreaDB);


		//matrix.jspへフォワード
		String path = "/matrix.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}//get


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {

	}//post

}//class