package model;//beans
//List<Integer> stoneAreaDB,List<Integer> stoneArea,stoneSelect
//List<Integer> stoneAreaDB

import java.io.Serializable;//implements Serializable
import java.util.List;//List

public class StoneBeans implements Serializable{
	private String stoneSelect;
	private List<Integer> stoneAreaDB;
	private List<String> stoneArea;
	private Integer select;

	public StoneBeans() {}//空のMethod

	/*public StoneBeans( String stoneSelect, Integer select) {
		this.stoneSelect=stoneSelect;
		this.select=select;

	}*/
	public StoneBeans(String stoneSelect,List<Integer> stoneAreaDB,
			List<String> stoneArea,Integer select) {//Servlet41にて使用
		this.stoneAreaDB=stoneAreaDB;
		this.stoneSelect=stoneSelect;
		this.select=select;
		this.stoneArea=stoneArea;
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

	public List<String> getStoneArea() {
		return stoneArea;
	}

	public void setStoneArea(List<String> stoneArea) {
		this.stoneArea = stoneArea;
	}

	public Integer getSelect() {
		return select;
	}

	public void setSelect(Integer select) {
		this.select = select;
	}


}//class
