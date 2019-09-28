package com.atguigu.bean;

public class Architect extends Designer{
	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Architect() {
		super();
	}
	
	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}
	
	@Override
	public String BaseInfo() {
		// TODO Auto-generated method stub
		return super.BaseInfo();
	}
	
	@Override
	public String getTeamBaseInfo() {
		// TODO Auto-generated method stub
		return BaseInfo()+"架构师"+"\t"+getBonus()+"\t"+stock;
	}

	@Override
	public String toString() {
		return BaseInfo()+"架构师"+"\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment();
	}
	
}
