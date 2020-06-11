package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException
	{
		//セッションスコープの破棄
		HttpSession session = request.getSession();

		session.invalidate();

		//logout.jspへフォワード
		String path = "/logout.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}//get

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException
	{


	}//post

}
