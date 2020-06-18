package model;//ブロック形判断stoneAreaDBを戻す
//ブロックの表示する色の指定

import java.util.List;

public class StoneLogic {
	public List<Integer> execute(StoneBeans stb/*int select,List<Integer> stoneAreaDB,
			String stoneSelect,List<String> stoneArea*/) {

		List<Integer> stoneAreaDB=stb.getStoneAreaDB();
		Integer select=stb.getSelect();
		String stoneSelect=stb.getStoneSelect();

		if(stoneSelect.equals("tri")) {//3つのブロックの定義
			/*selectで指定したstaDBを0から１へ
			 * ブロックの形でほかの変化させる場所の指定*/
			stoneAreaDB.set(select,1);
			stoneAreaDB.set(select+1,1);
			stoneAreaDB.set(select-5,1);
		}else if(stoneSelect.equals("twice")) {
			stoneAreaDB.set(select,1);
			stoneAreaDB.set(select+1,1);
		}else if(stoneSelect.equals("mono")) {
			stoneAreaDB.set(select,1);
		}else if(stoneSelect.equals("Sample")) {
			stoneAreaDB.set(select,1);
			stoneAreaDB.set(select+1,1);
			stoneAreaDB.set(select-5,1);
		}
		//if

		//beansにstoneAreaDBを格納
		stb.setStoneAreaDB(stoneAreaDB);

		return stoneAreaDB;
	}//execute
}//class
	/*public List<String> putColor(int select, List<Integer> colorDB){
    //---- Parameter Definition / 変数の定義 ----
    List<String> color = new ArrayList<>(30);
    color.add(0,"none"); //マス番とリスト番号を合わせるためのダミー

    int onOff = colorDB.get(select);

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

    //set select
    if (onOff == 0) {
        color.set(select, onColor);

    } else if (onOff == 1) {
        color.set(select, offColor);
    }

    //change onOff
    if (onOff == 0) {
        colorDB.set(select, 1);

    } else if (onOff == 1) {
        colorDB.set(select, 0);
    }

    setColorDB(colorDB);

    //---- Test Parameter ----
    //System.out.println(select);
    //System.out.println(onOff);
    //System.out.println(color);
    //System.out.println(colorDB);

  return color;
  }//putColor() or main()

}//class
*/


