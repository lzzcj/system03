package com.atguigu.bean;

import com.atguigu.service.Status;

public class Programmer extends Empolyee{
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Programmer() {
		super();
	}
	
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	
	@Override
	public String BaseInfo() {
		// TODO Auto-generated method stub
		return super.BaseInfo();
	}
	@Override
	public String toString() {
		return BaseInfo()+"程序员"+ "\t" + status + "\t\t\t" + equipment;
	}
	
	@Override
	public String getTeamBaseInfo() {
		// TODO Auto-generated method stub
		return BaseInfo()+"程序员"+ "\t\t\t";
	}
	
	
	
}
