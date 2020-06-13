package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.MatrixBeans;

public class SaveDAO {
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
  private final String DB_USER = "root";
  private final String DB_PASS = "root";

  public boolean saveGame(int puzzleId, int point, String saveDateTime) {
    boolean isSave = false;
    MatrixBeans matrixDB = new MatrixBeans();
    List<Integer> colorDB = matrixDB.getColorDB();

    //point機能は保留
    //boolean isSavePoint = pointDAO(point);
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

        //---- SQL ----
        String sql = "insert into matrix (puzzleId, cell, color, saveDateTime) values(?,?,?,?)";

        //SQL文を送る
        PreparedStatement pStmt = conn.prepareStatement(sql);

        for (int i = 1; i <= 25; i++) {
            pStmt.setInt(1, puzzleId);
            pStmt.setInt(2, i);
            pStmt.setInt(3, colorDB.get(i));
            pStmt.setString(4, saveDateTime);
        }// for

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
