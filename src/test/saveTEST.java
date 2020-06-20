/*
 * @author Sho
 * @thanks Naoto
 * */

package test;

import java.util.ArrayList;
import java.util.List;

import DAO.SaveDAO;
import model.ColorLogic;
import model.MatrixBeans;
import model.SaveCalc;
import model.SaveDateTime;
import model.User;

public class saveTEST {

    public static void main(String[] args) {
      ColorLogic colorLogic = new ColorLogic();

      String comfirm = "YES";
      String controle = "Save";
      User user = new User();
      user.setName("shika");
      user.setPass("shika");
      user.setAccountId("shika");
      user.setPoint(10000);
      user.setPuzzleId(99);
      int select = 0;
      int puzzleId = user.getPuzzleId();
      List<Integer> colorDB = new ArrayList<>(30);
      List<String> color = new ArrayList<>(30);

      //---- 初期colorDBを生成 ----
      for (int i = 0; i <= 25; i++) {
          colorDB.add(0);
      }//for

      //---- 初期stoneAreaを仮に定数生成 ----
      int[] stoneAreaDB = {9,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
      List<String> stoneArea = new ArrayList<>(30);
      stoneArea.add(0, "none");

      for (int i = 1; i <= 25; i++) {
          if (stoneAreaDB[i] == 1) {
              stoneArea.add("hotpink");
          } else if (stoneAreaDB[i] == 0) {
              stoneArea.add("mistyrose");
          }
      }//for

      String stoneSelect = "tri";

      List<String> stoneSelectColor = colorLogic.stoneSelectPaint(stoneSelect);



      color = colorLogic.paintColor(colorDB);

      SaveDateTime sdt = new SaveDateTime();
      String saveDateTime = sdt.saveDateTime();

      MatrixBeans matrixDB = new MatrixBeans();
      matrixDB.setColorDB(colorDB);
      matrixDB.setPuzzleId(puzzleId);
      matrixDB.setSaveDateTime(saveDateTime);
      // ---- switch (controle) ----
      switch (controle) {
        case "Save":
          if (comfirm.equals("YES")) {
              puzzleId = user.getPuzzleId();
              colorDB = matrixDB.getColorDB();

              SaveCalc saveCalc = new SaveCalc();
              int decimal = saveCalc.changeDecimal(colorDB);

              sdt = new SaveDateTime();
              saveDateTime = sdt.saveDateTime();

              SaveDAO dao = new SaveDAO();
              boolean isSave = dao.saveGame(puzzleId, decimal, saveDateTime);

              if (isSave) {
                String message = "セーブ完了";
                System.out.println(message);//松原

              }//if isSave

          } else if (comfirm.equals("NO")) {
              String message = "error1";
              System.out.println(message);//松原
          }//if comfirm
          break;

        case "Logout":
          if (comfirm.equals("YES")) {
              String message = "error2";
              System.out.println(message);//松原
          }
          break;

        case "Reset":
          if (comfirm.equals("YES")) {
              String message = "error3";
              System.out.println(message);//松原
          }
          break;

        case "Reverse":
          break;

      }//switch

  }//doPost()


}
