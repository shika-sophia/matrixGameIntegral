package model;

import java.util.ArrayList;
import java.util.List;

public class NewGame {
  public MatrixBeans newGameSetting(MatrixBeans matrixDB) {
      List<Integer> colorDB = new ArrayList<>(32);
      List<Integer> stoneAreaDB = new ArrayList<>(32);

      //---- build ArrayList ----
      for (int i = 0; i <= 25; i++) {
          if (i == 0) {
              colorDB.add(0, 9);
              stoneAreaDB.add(0, 9);
          }

          colorDB.add(i, 0);
          stoneAreaDB.add(i, 0);

      }//for

      //---- set to MatrixBeans ----
      matrixDB.setColorDB(colorDB);
      matrixDB.setStoneAreaDB(stoneAreaDB);

    return matrixDB;

  }//newGameSetting()

}//class
