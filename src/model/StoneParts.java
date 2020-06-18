package model;//stoneparts作成model
/*select,stoneselectからブロック座標を作成
 *
 */

import java.util.ArrayList;
import java.util.List;

public class StoneParts {
	public List<Integer>  execute(StoneBeans stb){
		int select=stb.getSelect();
		String stoneSelect=stb.getStoneSelect();
		List<Integer> stoneparts=new ArrayList<>(30);

		//ブロックの定義
		//selectで指定したstoneparts[]へ値を代入
		if(stoneSelect.equals("tri")) {
			stoneparts.set(select,1);
			stoneparts.set(select+1,1);
			stoneparts.set(select-5,1);
			 return stoneparts;
		}else if(stoneSelect.equals("twice")) {
			stoneparts.set(select,1);
			stoneparts.set(select+1,1);
			 return stoneparts;
		}else if(stoneSelect.equals("mono")) {
			stoneparts.set(select,1);
			return stoneparts;
		}else if(stoneSelect.equals("Sample")) {
			stoneparts.set(select,1);
			stoneparts.set(select+1,1);
			stoneparts.set(select-1,1);
			stoneparts.set(select-5,1);
			return stoneparts;
		}//if
		return stoneparts;
	}

}
