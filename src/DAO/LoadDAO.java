package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.MatrixBeans;
import model.SaveCalc;

public class LoadDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
    private final String DB_USER = "root";
    private final String DB_PASS = "root";

    public MatrixBeans loadData(int puzzleId,List<Integer> colorDB, MatrixBeans matrixDB) {

        Connection conn = null;

        try {
            //データベースにつなぐ処理
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            //セレクト文の準備
            String sql = "select color, saveDateTime from matrix where puzzleId = ?";

            //SQL文を送る
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, puzzleId);

            //SQL文を実行し結果を取得
            ResultSet rs = pStmt.executeQuery();

            int decimal = 0;
            String saveDateTime = "";

            while (rs.next()) {
                decimal = rs.getInt("color");
                saveDateTime = rs.getString("saveDateTime");
            }

            SaveCalc saveCalc = new SaveCalc();
            colorDB = saveCalc.changeBinary(decimal);

            //---- input to MatrixBeans ----
            matrixDB.setPuzzleId(puzzleId);
            matrixDB.setColorDB(colorDB);
            matrixDB.setSaveDateTime(saveDateTime);


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

        return matrixDB;

    }//loadData()

}//class
