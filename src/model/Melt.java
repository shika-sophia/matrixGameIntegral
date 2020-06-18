package model;

import java.util.ArrayList;
import java.util.List;

public class Melt {

	//public static void main(String[] args) {
    public List<Integer> meltStone(MatrixBeans matrixDB) {
        List<Integer> colorDB = (List<Integer>) matrixDB.getColorDB();
		//List<Integer> colorDB = new ArrayList<>(32);
        //colorDB.add(9);

        //int colorDemo[] = {9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0};

        /*
        for(int i = 1; i <= 25; i++) {
        	colorDB.add(colorDemo[i]);
        }
        */

        //System.out.println("Before" + colorDB);

        List<String> meltFlag = new ArrayList<>();

		if(colorDB.get(1) == 1 && colorDB.get(6) == 1 && colorDB.get(11) == 1 && colorDB.get(16) == 1 && colorDB.get(21) == 1) {

			meltFlag.add("X1");
		}

        if(colorDB.get(2) == 1 && colorDB.get(7) == 1 && colorDB.get(12) == 1 && colorDB.get(17) == 1 && colorDB.get(22) == 1) {

        	meltFlag.add("X2");
		}

        if(colorDB.get(3) == 1 && colorDB.get(8) == 1 && colorDB.get(13) == 1 && colorDB.get(18) == 1 && colorDB.get(23) == 1) {

        	meltFlag.add("X3");
		}

        if(colorDB.get(4) == 1 && colorDB.get(9) == 1 && colorDB.get(14) == 1 && colorDB.get(19) == 1 && colorDB.get(24) == 1) {

        	meltFlag.add("X4");
		}

        if(colorDB.get(5) == 1 && colorDB.get(10) == 1 && colorDB.get(15) == 1 && colorDB.get(20) == 1 && colorDB.get(25) == 1) {

        	meltFlag.add("X5");
		}

        if(colorDB.get(1) == 1 && colorDB.get(2) == 1 && colorDB.get(3) == 1 && colorDB.get(4) == 1 && colorDB.get(5) == 1) {

        	meltFlag.add("Y1");
		}

        if(colorDB.get(6) == 1 && colorDB.get(7) == 1 && colorDB.get(8) == 1 && colorDB.get(9) == 1 && colorDB.get(10) == 1) {

        	meltFlag.add("Y2");
		}

        if(colorDB.get(11) == 1 && colorDB.get(12) == 1 && colorDB.get(13) == 1 && colorDB.get(14) == 1 && colorDB.get(15) == 1) {

        	meltFlag.add("Y3");
		}

        if(colorDB.get(16) == 1 && colorDB.get(17) == 1 && colorDB.get(18) == 1 && colorDB.get(19) == 1 && colorDB.get(20) == 1) {

        	meltFlag.add("Y4");
		}

        if(colorDB.get(21) == 1 && colorDB.get(22) == 1 && colorDB.get(23) == 1 && colorDB.get(24) == 1 && colorDB.get(25) == 1) {

        	meltFlag.add("Y5");

		} else {
			//処理なし
		}
        //System.out.println("After" + colorDB);


        colorDB = meltPaint(colorDB,meltFlag);

        matrixDB.setColorDB(colorDB);

        return colorDB;


	}//meltStone() or main()

	private static List<Integer> meltPaint(List<Integer> colorDB, List<String> meltFlag){


		//System.out.println("Before" + colorDB);

		System.out.println("meltFlag" + meltFlag);

		for (String flag : meltFlag) {

			if(flag.equals("X1")) {

				colorDB.set(1,0);
				colorDB.set(6,0);
				colorDB.set(11,0);
				colorDB.set(16,0);
				colorDB.set(21,0);
			}

			if(flag.equals("X2")) {

				colorDB.set(2,0);
				colorDB.set(7,0);
				colorDB.set(12,0);
				colorDB.set(17,0);
				colorDB.set(22,0);
			}

			if(flag.equals("X3")) {

				colorDB.set(3,0);
				colorDB.set(8,0);
				colorDB.set(13,0);
				colorDB.set(18,0);
				colorDB.set(23,0);
			}

			if(flag.equals("X4")) {

				colorDB.set(4,0);
				colorDB.set(9,0);
				colorDB.set(14,0);
				colorDB.set(19,0);
				colorDB.set(24,0);
			}

			if(flag.equals("X5")) {

				colorDB.set(5,0);
				colorDB.set(10,0);
				colorDB.set(15,0);
				colorDB.set(20,0);
				colorDB.set(25,0);
			}

			if(flag.equals("Y1")) {

				colorDB.set(1,0);
				colorDB.set(2,0);
				colorDB.set(3,0);
				colorDB.set(4,0);
				colorDB.set(5,0);
			}

			if(flag.equals("Y2")) {

				colorDB.set(6,0);
				colorDB.set(7,0);
				colorDB.set(8,0);
				colorDB.set(9,0);
				colorDB.set(10,0);
			}

			if(flag.equals("Y3")) {

				colorDB.set(11,0);
				colorDB.set(12,0);
				colorDB.set(13,0);
				colorDB.set(14,0);
				colorDB.set(15,0);
			}

			if(flag.equals("Y4")) {

				colorDB.set(16,0);
				colorDB.set(17,0);
				colorDB.set(18,0);
				colorDB.set(19,0);
				colorDB.set(20,0);
			}

			if(flag.equals("Y5")) {

				colorDB.set(21,0);
				colorDB.set(22,0);
				colorDB.set(23,0);
				colorDB.set(24,0);
				colorDB.set(25,0);

			} else {
				//処理なし
			}//if

		}//for

		System.out.println("After" + colorDB);

		return colorDB;

	}//meltPaint()

}//class

/*
Before[9, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0]
meltFlag[X1, X3, Y4]
After[9, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
*/
