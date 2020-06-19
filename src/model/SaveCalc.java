package model;

import java.util.List;

public class SaveCalc {

	public List<Integer> changeDecimal(){

		MatrixBeans matrixDB = new MatrixBeans();
		List<Integer> colorDB = matrixDB.getColorDB();
	//public static void main(String[] args) {
		//int[] colorDemo = {9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0};

		//List<Integer> colorDB = new ArrayList<>(32);

		//for(int i = 0; i <= 25; i++) {
		//	colorDB.add(colorDemo[i]);
		//}

		int[] power = new int[26];
		int decimal = 0;
		String binary = "";

		for(int i = 1; i <= 25;i++) {

			power[i-1] = colorDB.get(i) * ((int) Math.pow(2, 25-i));
			decimal += power[i-1];
		}
		System.out.println(decimal);

		binary = Integer.toBinaryString(decimal);
		System.out.println(binary);

		return colorDB;

	}

}
/*
int[] colorDemo = {9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0};
decimal: 24826868
binary: 1011110101101001111110100
*/
