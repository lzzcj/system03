package com.atguigu.bean;

import com.atguigu.service.Status;

public class Designer extends Programmer{
	private double bonus;
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Designer() {
		super();
	}
	

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}
	
	@Override
	public String BaseInfo() {
		// TODO Auto-generated method stub
		return super.BaseInfo();
	}
	

	@Override
	public String getTeamBaseInfo() {
		// TODO Auto-generated method stub
		return BaseInfo()+"设计师" +"\t"+bonus+ "\t\t";
	}
	
	@Override
	public String toString() {
		return BaseInfo()+"设计师" +"\t"+getStatus()+"\t"+bonus+ "\t\t"+ getEquipment();
	}
	
}
