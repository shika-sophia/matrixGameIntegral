package model;

import java.util.ArrayList;
import java.util.List;

public class SaveCalc {

  //====== binary to decimal ======
  public int changeDecimal(List<Integer> colorDB){

    int decimal = 0;

    for(int i = 1; i <= 25;i++) {
        int a = colorDB.get(i);          //Listの各要素を取得
        int b = (int) Math.pow(2, 25-i); //2の24乗,2の23乗,...,2の0乗
        decimal += (a * b);
    }//for

    return decimal;

  }//changeDecimal()


  //====== decimal to binary ======
  public List<Integer> changeBinary(int decimal){

    String binary = Integer.toBinaryString(decimal);
    List<Integer> colorDB = new ArrayList<>(32);
    colorDB.add(0, 9);

    int binaryLength = binary.length();

    int count = 0; //substringのindexに合わせるためのcount
    for (int i = 1; i <= 25; i++) {
      if (i < (25 - binaryLength)) { //binaryが25桁に満たない場合
    	  colorDB.add(0);
    	  count++;
      } else {
    	  String str = binary.substring((i - 1 -count), i - count);
          int onOff = Integer.parseInt(str);
          colorDB.add(i, onOff);
      }
    }//for

    return colorDB;

  }//changeBinary()

}//class

/*
  // ###### このクラスで使っているアルゴリズム ######
  // ====== 01のbinary(２進数)データを decimal(10進数)にして保存 ======
 public static void main(String[] args) {
        int[] colorDemo = {9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0};

        List<Integer> colorDB = new ArrayList<>(32);

        for(int i = 0; i <= 25; i++) {
            colorDB.add(colorDemo[i]);
        }

        int decimal = 0;
        String binary = "";

        for(int i = 1; i <= 25;i++) {
            int a = colorDB.get(i);          //Listの各要素を取得
            int b = (int) Math.pow(2, 25-i); //2の24乗,2の23乗,...,2の0乗
            decimal += (a * b);
        }
        System.out.println(decimal);


        // ---- colorDBを初期化 ----
        colorDB.clear();
        colorDB.add(0, 9);

     // ====== decimal を binary に再変換 ======
        binary = Integer.toBinaryString(decimal);
        System.out.println(binary);

        // ---- colorDBを再生 ----
        for (int i = 1; i <= 25; i++) {
          String str = binary.substring(i - 1, i);
          int onOff = Integer.parseInt(str);
          colorDB.add(i, onOff);
        }//for

        System.out.println("colorDB:" + colorDB);

    }//main()
}//class
*/
/*
// ====== Test Result ======
//int[] colorDemo = {9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0};
//decimal: 24826868
//binary: 1011110101101001111110100
//colorDB:[9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0]

 ＊考察
 このdecimal to binary は初項1なので25桁ある。
 substringのindex Errorは出なかった。
 charAt()でためしてみる
 *
 */
 /*
	public static void main(String[] args) {
        int[] colorDemo = {9,0,0,0,0,0,0,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0};

        List<Integer> colorDB = new ArrayList<>(32);

        for(int i = 0; i <= 25; i++) {
            colorDB.add(colorDemo[i]);
        }

        int decimal = 0;
        String binary = "";

        for(int i = 1; i <= 25;i++) {
            int a = colorDB.get(i);          //Listの各要素を取得
            int b = (int) Math.pow(2, 25-i); //2の24乗,2の23乗,...,2の0乗
            decimal += (a * b);
        }
        System.out.println(decimal);


        // ---- colorDBを初期化 ----
        colorDB.clear();
        colorDB.add(0, 9);

     // ====== decimal を binary に再変換 ======
        binary = Integer.toBinaryString(decimal);

        int binaryLength = binary.length();

        System.out.println(binary);
        System.out.println(binaryLength);

        // ---- colorDBを再生 ----
        int count = 0;
        for (int i = 1; i <= 25; i++) {
          if (i <= (25 - binaryLength)) {
        	  colorDB.add(i, 0);
        	  count++;
          } else {
            char bit = binary.charAt(i - count);
            int onOff = Integer.parseInt(String.valueOf(bit));
            colorDB.add(i, onOff);
          }
        }//for

        System.out.println("colorDB:" + colorDB);

    }//main()
}//class
*/
/*185332
101101001111110100
18
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 18
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:47)
	at java.base/java.lang.String.charAt(String.java:693)
	at model.SaveCalc.main(SaveCalc.java:145)
*/
