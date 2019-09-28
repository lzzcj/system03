package com.atguigu.service;

import java.util.Arrays;

import com.atguigu.bean.Empolyee;
import com.atguigu.bean.Programmer;

public class TeamService {
	private int programmerCount=0;
	private int DesignerCount=0;
	private int ArchitectCount=0;
	
	public int getProgrammerCount() {
		return programmerCount;
	}
	public void setProgrammerCount(int programmerCount) {
		this.programmerCount = programmerCount;
	}
	public int getDesignerCount() {
		return DesignerCount;
	}
	public void setDesignerCount(int designerCount) {
		DesignerCount = designerCount;
	}
	public int getArchitectCount() {
		return ArchitectCount;
	}
	public void setArchitectCount(int architectCount) {
		ArchitectCount = architectCount;
	}
	Programmer[] team =new Programmer[2];
	private int totle = 0;
	public int getTotle() {
		return totle;
	}
	public boolean addMember(Programmer p){
		if(totle>=team.length){
			team = Arrays.copyOf(team,team.length*2);
		}
		p.setMemberId(totle+1);
		p.setStatus(Status.BUSY);
		team[totle++] = p;
		return true;
	}
	public void removeMemberByTid(int tid){
		int index = tid-1;
		System.arraycopy(team, index+1, team, index, team.length-index-1);
		team[--totle] = null;
	}
	public Programmer[] getAllMmber(){
		return team;
	}
}
