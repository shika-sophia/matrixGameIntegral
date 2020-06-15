package model;

import DAO.LoginDAO;

/* ログイン処理  */
public class LoginLogic {

	//パスワードの判定をするメソッド
	public boolean execute(User user) {

		//LoginDAOのインスタンス化
		LoginDAO dao = new LoginDAO();

		boolean existRegister = dao.findByLogin(user);

		return existRegister;

	}//execute()

}//class
