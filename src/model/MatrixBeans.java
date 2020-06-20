/**
* @title matrixGame/ model /class MatrixBeans/ MatrixBeans()
* @author Shika
* @date first:2020-05-30 /last:2020-06-14 9:00
* @see servlet:ColorServlet
* @see view: matrix.jsp
*
* @class javaBeans for coping matrix_tb in puzzle_db
* @class DBのmatrixテーブルの内容を保存し、次々に変わる色データを保存
* @parm colorDB: List<Integer>/ 既存の色を保存しているＤＢ、ここでは定数
* @parm puzzleId: int/ 登録時に自動生成されるId、matrix_tbのprimary key
* @palm saveDateTime: String/ save日時を保存
*/

package model;

import java.io.Serializable;
import java.util.List;

//====== constracter Beans for stock colorDB etc/ colorDB等を保持するBeans====
public class MatrixBeans implements Serializable {
  private List<Integer> colorDB;
  private int puzzleId;
  private String saveDateTime;

  private List<Integer> stoneAreaDB;
  private List<Integer> selectList;
  private String stoneSelect;


  public MatrixBeans() {}

  public MatrixBeans(List<Integer> colorDB) {
      this.colorDB = colorDB;
  }

  public MatrixBeans(List<Integer> colorDB, int puzzleId, String saveDateTime) {
      this.colorDB = colorDB;
      this.puzzleId = puzzleId;
      this.saveDateTime = saveDateTime;
  }

  // ====== getter and setter ======
  public List<Integer> getColorDB() {
      return colorDB;
  }

  public void setColorDB(List<Integer> colorDB) {
    this.colorDB = colorDB;
  }

  public int getPuzzleId() {
      return puzzleId;
  }

  public void setPuzzleId(int puzzleId) {
      this.puzzleId = puzzleId;
  }

  public String getSaveDateTime() {
      return saveDateTime;
  }

  public void setSaveDateTime(String saveDateTime) {
      this.saveDateTime = saveDateTime;
  }

  public List<Integer> getStoneAreaDB() {
      return stoneAreaDB;
  }

  public void setStoneAreaDB(List<Integer> stoneAreaDB) {
      this.stoneAreaDB = stoneAreaDB;
  }

  public List<Integer> getSelectList() {
      return selectList;
  }

  public void setSelectList(List<Integer> selectList) {
      this.selectList = selectList;
  }

  public String getStoneSelect() {
      return stoneSelect;
  }

  public void setStoneSelect(String stoneSelect) {
      this.stoneSelect = stoneSelect;
  }

}//class
