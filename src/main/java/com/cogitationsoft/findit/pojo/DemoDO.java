package com.cogitationsoft.findit.pojo;

/**
 * @author: Andy
 * @date: 5/4/2018 9:16 AM
 * @description: 样例
 * @version: 1.0
 */
public class DemoDO {
	private int id;
	private int no;
	private String name;

	public DemoDO(int id, int no, String name) {
		this.id = id;
		this.no = no;
		this.name = name;
	}

	public DemoDO(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
