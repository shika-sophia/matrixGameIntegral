package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
    private final String DB_USER = "root";
    private final String DB_PASS = "root";

    public register findByLogin(User user) {

    	Register register = null;

    	Connection conn = null;

    //データベースへ接続
    try {
		//データベースにつなぐ処理
		conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

		//セレクト文の準備
		String sql = "SELECT puzzleID,name,accountID,pass,point FROM user WHERE NAME=? AND PASS=?";

		//SQL文を送る
		PreparedStatement pStmt = conn.prepareStatement(sql);

		//?に情報をセットする
		pStmt.setString(1, user.getName());
		pStmt.setString(2, user.getPass());

		//SQL文を実行し結果を取得
		ResultSet rs = pStmt.executeQuery();

		//セレクト文の結果を取得
		if (rs.next()) {
			int puzzleID = rs.getInt("puzzleID");
			String name = rs.getString("name");
			String accountID = rs.getString("accountID");
			String pass = rs.getString("pass");
			int point = rs.getInt("point");

			register = new Register(puzzleID,name,accountID,pass,point);

		}

	} catch (SQLException e) {
		e.printStackTrace();
		return null;

	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	return register;

}//findByLogin()

}
