package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;


public class RegisterDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<String> selectRegister() {
		Connection conn = null;
		List<String> accountDB = new ArrayList<>();

		try{
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//SELECT文の準備
			String sql = "SELECT accountId FROM user";

			//SQL文を送る
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行して結果を取得する
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
			    accountDB.add(rs.getString("accountId"));
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
        }//finally

        return accountDB;

	}//selectRegister


	public boolean insertRegister(User user) {

		Connection conn = null;

		try {
			conn =DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//SQL文の準備
			String sql = "insert into user (puzzleId, name, accountId, pass, point) values(?,?,?,?,?)";

			//SQL文を送る
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文に情報を渡す
			pStmt.setInt(1, user.getPuzzleId());
			pStmt.setString(2, user.getName());
			pStmt.setString(3, user.getAccountId());
			pStmt.setString(4, user.getPass());
			pStmt.setInt(5, user.getPoint());

			//SQL文を実行して結果を取得する
			int rs = pStmt.executeUpdate();

			if(rs !=1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		return true;

	}//insertRegister()
}//class
