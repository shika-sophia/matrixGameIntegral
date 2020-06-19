package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveDAO {
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
  private final String DB_USER = "root";
  private final String DB_PASS = "root";

  public boolean saveGame(int puzzleId, int decimal, String saveDateTime) {
    boolean isSave = false;

    Connection conn = null;

    try {
        conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

        //---- SQL ----
        String sql = "insert into matrix (puzzleId, cell, color, saveDateTime) values(?,?,?,?)";

        //SQL文を送る
        PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, puzzleId);
            pStmt.setInt(2, 0);
            pStmt.setInt(3, decimal);
            pStmt.setString(4, saveDateTime);


        //SQL文を実行し結果を取得
        ResultSet rs = pStmt.executeQuery();

        isSave = true;
        return isSave;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;

    } finally {
        try {
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }//finally

  }//saveGame()
}//class
