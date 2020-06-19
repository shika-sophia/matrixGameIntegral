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

    for (int i = 1; i <= 25; i++) {
      String str = binary.substring(i - 1, i);
      int onOff = Integer.parseInt(str);
      colorDB.add(i, onOff);
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

// ====== Test Result ======
//int[] colorDemo = {9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0};
//decimal: 24826868
//binary: 1011110101101001111110100
//colorDB:[9,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0]
*/