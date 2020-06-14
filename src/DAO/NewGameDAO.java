package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SaveDateTime;

public class NewGameDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
    private final String DB_USER = "root";
    private final String DB_PASS = "root";

    public List<Integer> newGameData(int puzzleId) {

        Connection conn = null;

        SaveDateTime sdt = new SaveDateTime();
        String saveDateTime = sdt.saveDateTime();

        List<Integer> colorDB = new ArrayList<>(30);

        try {
            //データベースにつなぐ処理
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "insert into matrix (puzzleId, cell, color, saveDateTime) values( ?, ?, 0 ,'?')";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            for (int i = 0; i <= 25; i++) {
                pStmt.setInt(1, puzzleId);
                pStmt.setInt(2, i);
                pStmt.setString(3, saveDateTime);

                //初期colorDBを生成
                colorDB.add(i, 0);

            }//for

            pStmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                conn.close();

                //System.out.println(colorDB);
                //System.out.println(saveDateTime);

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }//finally

        return colorDB;

    }//newGameData()


}//class
