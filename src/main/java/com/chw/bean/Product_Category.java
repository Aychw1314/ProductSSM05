package com.chw.bean;

public class Product_Category {

	private int id;
	private int pid;
	private int cid;

	public Product_Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product_Category [id=" + id + ", pid=" + pid + ", cid=" + cid + "]";
	}

}
