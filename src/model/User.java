package model;

import java.io.Serializable;

public class User implements Serializable{


	private String name;
	private String pass;
	private String accountId;
	private int puzzleId;
	private int point;

	public User() {} //空のmethod

	public User(String name,String pass,String accountId) {

		this.name=name;
		this.pass=pass;
		this.accountId=accountId;
		this.puzzleId=puzzleId;
		this.point=point;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getPuzzleId() {
		return puzzleId;
	}

	public void setPuzzleId(int puzzleId) {
		this.puzzleId = puzzleId;
	}
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}//class
