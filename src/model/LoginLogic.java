package model;

import DAO.LoginDAO;

/* ログイン処理 パスワードの判定をするクラス */
public class LoginLogic {

	//パスワードの判定をするメソッド
	public boolean execute(User user) {

		//LoginDAOのインスタンス化
		LoginDAO dao = new LoginDAO();

		User user = dao.findByLogin(user);

		return user != null;

		//パスワードがあっていた場合
		if(user.getPass().equals("1234")) {
			return true;
		}

		//パスワードが間違っていた場合
		return false;

	}

}
