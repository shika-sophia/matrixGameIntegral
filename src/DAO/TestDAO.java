/*
 * 原先生 TestServlet
 * */

package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class TestDAO extends HttpServlet {
    private final long serialVersionUID = 1L;

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
    private final String DB_USER = "root";//jdbc:mysql://localhost:3306/
    private final String DB_PASS = "root";//C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data/


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
          try {
              //データベースにつなぐ処理
              conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

              //セレクト文の準備
              String sql = "select color from matrix where puzzleID = 1";


              //SQL文を送る
              PreparedStatement pStmt = conn.prepareStatement(sql);

              //SQL文を実行し結果を取得
              ResultSet rs = pStmt.executeQuery();

              List<Integer> colorDB = new ArrayList<>(30);

              while (rs.next()) {
                  colorDB.add(rs.getInt("color"));
              }

              System.out.println(colorDB);

          } catch (SQLException e) {
              e.printStackTrace();
              //return null;

          } finally {
              try {
                  conn.close();
              } catch (SQLException e) {
                  e.printStackTrace();
                  //return null;
              }
          }//finally

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
