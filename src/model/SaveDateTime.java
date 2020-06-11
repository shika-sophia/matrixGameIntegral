package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveDateTime {

  //public static void main(String[] args) {
  public String saveDateTime() {

    LocalDateTime ldt = LocalDateTime.now();
    String saveDateTime = ldt.format(DateTimeFormatter.
        ofPattern("Y年L月d日(E) k時m分s秒"));

    //System.out.println(saveDateTime);

    return saveDateTime;
  }//saveDateTime() or main()

}//class

/* 結果
LocalDateTime: 2020-06-11T13:53:42.003
LocalDateTimeFormatter: 2020年6月11日(木) 14時20分7秒
*/