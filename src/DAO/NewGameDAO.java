package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewGameDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
    private final String DB_USER = "root";
    private final String DB_PASS = "root";

    public List<Integer> newGameData(String puzzleId) {

        Connection conn = null;
        List<Integer> colorDB = new ArrayList<>(30);

        try {
            //データベースにつなぐ処理
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            String sql = "insert into matrix (puzzleId, cell, color) values( ?, ?, 0 )";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            for (int i = 0; i <= 25; i++) {
            	pStmt.setString(1, puzzleId);
            	pStmt.setInt(2, i);
            }//for
            
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                colorDB.add(rs.getInt("color"));
            }

            //System.out.println(colorDB);


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

        return colorDB;

    }//newGameData()


}//class
