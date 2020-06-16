package model;//ブロックの色を付けるmethod,beansにstoneAreaをset

import java.util.List;

public class StoneputColor {
	public List<String> execute(StoneBeans stb){
		List<Integer> stoneAreaDB=stb.getStoneAreaDB();
		Integer select=stb.getSelect();
		String stoneSelect=stb.getStoneSelect();
		List<String> stoneArea=stb.getStoneArea();

		String onColor = "cornflowerblue";
	    String offColor = "lavenderblush";
	    String onstone="hotpink";
	    //stoneAreaを出力
	    for (int i = 1; i < stoneAreaDB.size(); i++)
	    { //ダミーがあるので1から
	    	//set colorDB to List "color"
	        if (stoneAreaDB.get(i) == 0) {
	        	stoneArea.add(i , offColor);

	        } else if (stoneAreaDB.get(i) == 1) {
	        	stoneArea.add(i , onColor);
	        }//if
	     }//for
	    //beansにstoneAreaを格納
	    stb.setStoneArea(stoneArea);

		return stoneArea;
	}//execute

}//class
