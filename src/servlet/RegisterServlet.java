package servlet;//RegisterServlet

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {

		//index.jspのactionリクエストパラメータを取得する
		String action = request.getParameter("action");

		if (action == null) {

			//register.jspへフォワード
			String path = "/register.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		}else if(action.equals("done")) {

			//セッションスコープの情報を取得する
			HttpSession sesstion = request.getSession();
			User user =(User) sesstion.getAttribute("user");

			//RegisterUserLogicのインスタンス化
			RegisterUserLogic rul = new RegisterUserLogic();
			rul.execute(user);//RegisterUserLogicの仮数値のためコメントアウト

			sesstion.removeAttribute("user");

			System.out.println("ok");

			//registerDone.jspへフォワード
			String path = "/registerDone.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}
	}//get


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("accountId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		//RegisterUserクラスをインスタンス化
		User User = new User(userId, name, pass);

		//セッションスコープを使用する
		HttpSession session = request.getSession();
		session.setAttribute("User",User);

		//registerConfirm.jspへフォワード
		String path = "/registerConfrim.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);


	}//post

}
