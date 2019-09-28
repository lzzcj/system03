package com.atguigu.service;

import com.atguigu.bean.Architect;
import com.atguigu.bean.Designer;
import com.atguigu.bean.Empolyee;
import com.atguigu.bean.Equipment;
import com.atguigu.bean.NoteBook;
import com.atguigu.bean.PC;
import com.atguigu.bean.Printer;
import com.atguigu.bean.Programmer;

import static com.atguigu.service.Data.*;
public class NameListService {
	public Empolyee[] empolyees;
	
	public Empolyee getById(int id){
		return empolyees[id-1];
	}
	public NameListService() {
		empolyees = new Empolyee[EMPLOYEES.length];
		for (int i = 0; i < empolyees.length; i++) {
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			
			String name = EMPLOYEES[i][2];
			
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			if(10==Integer.parseInt(EMPLOYEES[i][0])){
				empolyees[i] = new Empolyee(id,name,age,salary);
			}else if(11==Integer.parseInt(EMPLOYEES[i][0])){
				empolyees[i] = new Programmer(id, name, age, salary,getByLineNum(i));
			}else if(12==Integer.parseInt(EMPLOYEES[i][0])){
				empolyees[i] = new Designer(id, name, age, salary, getByLineNum(i), Integer.parseInt(EMPLOYEES[i][5]));
			}else if(13==Integer.parseInt(EMPLOYEES[i][0])){
				empolyees[i] = new Architect(id, name, age, salary, getByLineNum(i), Integer.parseInt(EMPLOYEES[i][5]),Integer.parseInt(EMPLOYEES[i][6]));
			}
		}
	}
	private Equipment getByLineNum(int i) {
		// TODO Auto-generated method stub
		int type = Integer.parseInt(EQIPMENTS[i][0]);
		switch (type) {
		case 21:
			return new PC(EQIPMENTS[i][1],EQIPMENTS[i][2]);
		case 22:
			return new NoteBook(EQIPMENTS[i][1],Double.parseDouble(EQIPMENTS[i][2]));
		case 23:
			return new Printer(EQIPMENTS[i][1],EQIPMENTS[i][2]);
		default:
			return null;
		}
	
	}
	public Empolyee[] getAllEmpolyees(){
		return empolyees;
	}
	
}
