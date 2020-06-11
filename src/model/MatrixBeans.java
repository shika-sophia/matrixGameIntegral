/**
* @title matrixGame/ model /class Color/ setColor()
* @author Shika
* @date first:2020-05-30 /last:2020-06-03 22:00
* @see servlet:ColorServlet
* @see view: matrix.jsp
*
* @class make color ArrayList for cell-color change.
* @class 色変換のためのリストを生成するクラス
* @parm color: ArrayList<String> 色名を25個 設定するリスト
* @parm colorDB: 既存の色を保存しているＤＢ、ここでは定数
* @parm select: int インプットされた色変換するセル番号
* @palm onOff: colorDBにselect番で保存してる値
*/

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//====== constracter Beans for stock colorDB/ colorDBを保持するBeans====
public class MatrixBeans implements Serializable {
  private List<Integer> colorDB;
  private String puzzleId;
  private String saveDateTime;

  public MatrixBeans() {}

  public MatrixBeans(List<Integer> colorDB) {
	  this.colorDB = colorDB;
  }

  public MatrixBeans(List<Integer> colorDB, String puzzleId, String saveDateTime) {
      this.colorDB = colorDB;
      this.puzzleId = puzzleId;
      this.saveDateTime = saveDateTime;

  }

  public List<Integer> getColorDB() {
    return colorDB;
  }

  public void setColorDB(List<Integer> colorDB) {
    this.colorDB = colorDB;
  }

  public String getPuzzleId() {
	return puzzleId;
  }

  public void setPuzzleID(String puzzleId) {
	this.puzzleId = puzzleId;
  }

  public String getSaveDateTime() {
	return saveDateTime;
  }

  public void setSaveDateTime(String saveDateTime) {
	this.saveDateTime = saveDateTime;
  }

//以下、ColorLogicクラスとして分離予定
//====== putColor() / colorDBから色指定をset ======
  public List<String> putColor(int select, List<Integer> colorDB){
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
