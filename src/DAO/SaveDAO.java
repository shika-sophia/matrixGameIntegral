package DAO;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveDAO {
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
  private final String DB_USER = "root";
  private final String DB_PASS = "root";

  public boolean saveGame(int puzzleId, int point, String saveDateTime) {
    boolean isSave = false;

    Connection conn = null;

    try {
      conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

      //---- SQL ----
      String sql = "insert into matrix (  puzzleId = ?";

          //SQL文を送る
          PreparedStatement pStmt = conn.prepareStatement(sql);

          pStmt.setString(1, puzzleId);

          //SQL文を実行し結果を取得
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

	  return isSave;
  }//saveGame()
}//class
=======
public class SaveDAO {
	//test
}
>>>>>>> 28bb4c2cde8bc86007320ba7d0628167ec7c6488
=======
public class SaveDAO {
	//test
}
>>>>>>> 28bb4c2cde8bc86007320ba7d0628167ec7c6488
=======
public class SaveDAO {
	//test
}
>>>>>>> 28bb4c2cde8bc86007320ba7d0628167ec7c6488
