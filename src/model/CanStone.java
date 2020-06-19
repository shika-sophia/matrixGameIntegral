package model;

import java.util.List;

public class CanStone {

	public static void main(String[] args) {
	}

	public boolean canRange(StoneBeans stb) {
		boolean canRange;
		Integer select=stb.getSelect();
		String stoneSelect=stb.getStoneSelect();
		if(stoneSelect=="tri") {//if①
			if(select==1||select==2||select==3||select==4
				||select==5||select==10||select==15||select==20
				||select==25)
			{
				canRange = false;
				return canRange;
			}//①
		}else if(stoneSelect=="twice") {//if②
			if(select==1||select==2||select==3||select==4
				||select==5)
			{
				canRange = false;
				return canRange;
			}//②
		}else {
			canRange = true;
			return canRange;
		}
		canRange = true;
		return canRange;
	}//canRange()

	public boolean canBlock(MatrixBeans matrixDB) {

		boolean canBlock = false;
		List<Integer> stoneAreaDB = (List<Integer>) matrixDB.getStoneAreaDB();
		List<Integer> colorDB = (List<Integer>) matrixDB.getColorDB();

		for(int i=1;i<=25;i++) {

			if((colorDB.get(i) == stoneAreaDB.get(i))  && (colorDB.get(i)==1)) {

				canBlock = false;

			}else {
				canBlock = true;

			}
		}//for

		return canBlock;
	}

}
