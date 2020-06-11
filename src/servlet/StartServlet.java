package servlet;//aMatrixは動かすためMainservlet

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*name,point,Lank,existData(null or exist)をColorServletに送る準備
 *
 *
 * */

@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws
				ServletException, IOException {
		System.out.println("ゲームを始める");
		//puzuleID,user名,座標の色データcolorDB を取得する




		//リクエストスコープに保存する
		//request.setAttribute(, );

		//choice.jspへフォワード
		String path = "choice.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);


	}//get


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws
				ServletException, IOException {


		System.out.println("post");


	}//post

}
