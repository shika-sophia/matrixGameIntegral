package model;

import java.util.ArrayList;
import java.util.List;

public class ColorLogic {

  public List<Integer> changeColor(MatrixBeans matrixDB, int select, List<Integer> colorDB) {

      int onOff = colorDB.get(select);

      //change onOff
      if (onOff == 0) {
          colorDB.set(select, 1);

      } else if (onOff == 1) {
          colorDB.set(select, 0);
      }

      matrixDB.setColorDB(colorDB);

      //---- Test Parameter ----
      //System.out.println(select);
      //System.out.println(onOff);
      //System.out.println(colorDB);

      return colorDB;

  }//ChangeColor()

  public List<String> paintColor(int select, List<Integer> colorDB) {
      List<String> color = new ArrayList<>(30);
      color.add(0,"none"); //マス番とリスト番号を合わせるためのダミー

      String onColor = "cornflowerblue";
      String offColor = "lavenderblush";

      for (int i = 1; i < colorDB.size(); i++) { //ダミーがあるので 1から
          //set colorDB to List "color"
          if (colorDB.get(i) == 0) {
              color.add(i , offColor);

          } else if (colorDB.get(i) == 1) {
              color.add(i , onColor);
          }
      }//for

      return color;
  }//paintColor()


  public List<String> stoneSelectPaint(String stoneSelect) {
	List<String> stoneSelectColor = new ArrayList<>();
	stoneSelectColor.add("none");
    stoneSelectColor.add("none");
    stoneSelectColor.add("none");
    stoneSelectColor.add("none");

    if (stoneSelect.equals("tri")) {
    	stoneSelectColor.set(1,"hotpink");
    	stoneSelectColor.set(2,"lavenderblush");
    	stoneSelectColor.set(3,"lavenderblush");

    } else if (stoneSelect.equals("twice")) {
    	stoneSelectColor.set(1,"lavenderblush");
    	stoneSelectColor.set(2,"hotpink");
    	stoneSelectColor.set(3,"lavenderblush");

    } else if (stoneSelect.equals("mono")) {
    	stoneSelectColor.set(1,"lavenderblush");
    	stoneSelectColor.set(2,"lavenderblush");
    	stoneSelectColor.set(3,"hotpink");

    }

	return stoneSelectColor;

  }//stoneSelectPaint()
}//class
