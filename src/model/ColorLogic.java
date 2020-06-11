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

	  paintColor(select, colorDB);

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

	  int onOff = colorDB.get(select);
	  //set select
	  if (onOff == 0) {
	      color.set(select, onColor);

	  } else if (onOff == 1) {
	      color.set(select, offColor);
	  }

	  return color;
  }//paintColor()
}//class
