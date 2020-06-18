package model;//beans
//List<Integer> stoneAreaDB,List<Integer> stoneArea,stoneSelect
//List<Integer> stoneAreaDB
//使用箇所、MkmServletSample,３２

import java.io.Serializable;//implements Serializable
import java.util.List;//List

public class StoneBeans implements Serializable{
	private String stoneSelect;
	private List<Integer> stoneAreaDB;
	private List<String> stoneArea;
	private int select;
	private String stoneMove;

	public StoneBeans() {}//空のMethod

	public StoneBeans(String stoneSelect,List<Integer> stoneAreaDB,
			int select,String stoneMove) {//Servlet41にて使用
		this.stoneAreaDB=stoneAreaDB;
		this.stoneSelect=stoneSelect;
		this.select=select;
		this.stoneMove=stoneMove;
	}
	public StoneBeans(String stoneSelect, List<Integer> stoneAreaDB,
			int select) {//servlet54にて使用
		this.stoneAreaDB=stoneAreaDB;
		this.stoneSelect=stoneSelect;
		this.select=select;
	}

	//gettersetter
	public String getStoneSelect() {
		return stoneSelect;
	}

	public void setStoneSelect(String stoneSelect) {
		this.stoneSelect = stoneSelect;
	}

	public List<Integer> getStoneAreaDB() {
		return stoneAreaDB;
	}

	public void setStoneAreaDB(List<Integer> stoneAreaDB) {
		this.stoneAreaDB = stoneAreaDB;
	}

	public Integer getSelect() {
		return select;
	}

	public void setSelect(Integer select) {
		this.select = select;
	}

	public String getStoneMove() {
		return stoneMove;
	}

	public void setStoneMove(String stoneMove) {
		this.stoneMove = stoneMove;
	}




}//class
