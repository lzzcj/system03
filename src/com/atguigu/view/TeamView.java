package com.atguigu.view;

import static com.atguigu.service.Data.EMPLOYEES;

import com.atguigu.bean.Architect;
import com.atguigu.bean.Designer;
import com.atguigu.bean.Empolyee;
import com.atguigu.bean.Programmer;
import com.atguigu.service.NameListService;
import com.atguigu.service.Status;
import com.atguigu.service.TeamException;
import com.atguigu.service.TeamService;
import com.atguigu.utils.TSUtility;

public class TeamView {
	TeamService ts = new TeamService();
	NameListService ns = new NameListService();
	public void menu(){
		while(true){
		System.out.println();
		System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
		System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		showAllEmpolyees();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：_");
		char select = TSUtility.readMenuSelection();
		switch(select){
		case '1':
			teamList();
			break;
		case '2':
			try {
				add();
			} catch (TeamException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case '3':
			try {
				delete();
			} catch (TeamException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case '4':
			System.out.println("see you!");
			return;
		}
	}
}
	Empolyee[] all = ns.getAllEmpolyees();
	private void showAllEmpolyees() {
		// TODO Auto-generated method stub
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i].toString());
		}
	}
	private void delete() throws TeamException {
		// TODO Auto-generated method stub
		System.out.print("输入要删除的团队成员编号(TID)：");
		int num = TSUtility.readInt();
		if(num<=0||num>ts.getTotle()){
			throw new TeamException("不存在");
		}else{
			System.out.print("确认是否删除(Y/N):");
			char confirm = TSUtility.readConfirmSelection();
			if(confirm == 'Y'){
			ts.removeMemberByTid(num);
			System.out.println("删除成功");
			}else{
				return;
			}
		}
	}

	private void teamList() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("--------------------------------------团队成员列表--------------------------------------");
		System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
		Programmer[] allTeam = ts.getAllMmber();
		for (int i = 0; i < ts.getTotle(); i++) {
			System.out.println(allTeam[i].getMemberId()+"/"+allTeam[i].getTeamBaseInfo());
		}
	}

	private void add() throws TeamException {
		NameListService ns = new NameListService();
		// TODO Auto-generated method stub
		System.out.println("---------------------添加成员---------------------");
		System.out.print("请输入想要拉入团队的员工ID：");
		int num = TSUtility.readInt();
		Programmer p;
		Designer d;
		Architect a;
		if(num<1||num>all.length){
			throw new TeamException("添加失败，员工不存在。");
		}else if(10==Integer.parseInt(EMPLOYEES[num-1][0])){
			throw new TeamException("添加失败，该员工为普通员工，不能加入团队");
		}else if(Integer.parseInt(EMPLOYEES[num-1][0])==11){
			p = (Programmer)all[num-1];
			if((p.getStatus() == Status.BUSY)){
				throw new TeamException("添加失败，员工已是团队成员。");
			}else{
				if(ts.getProgrammerCount()==3){
					throw new TeamException("添加失败，程序员人数已满(最多三人)");
				}else{
					if(ts.addMember(p)){
						System.out.println("添加成功");
						ts.setProgrammerCount(ts.getProgrammerCount()+1);
						TSUtility.readReturn();
					}else{
						System.out.println("添加失败。");
					}
				}
			}
		}else if(Integer.parseInt(EMPLOYEES[num-1][0])==12){
			d = (Designer)all[num-1];
			if((d.getStatus() == Status.BUSY)){
				throw new TeamException("添加失败，员工已是团队成员。");
			}else{
				if(ts.getDesignerCount()==2){
					throw new TeamException("添加失败，设计师人数已满(最多两人)");
				}else{
					if(ts.addMember(d)){
						System.out.println("添加成功");
						ts.setDesignerCount(ts.getDesignerCount()+1);
						TSUtility.readReturn();
					}else{
						System.out.println("添加失败");
					}
				}
			}
		}else if(Integer.parseInt(EMPLOYEES[num-1][0])==13){
			a = (Architect)all[num-1];
			if((a.getStatus() == Status.BUSY)){
				throw new TeamException("添加失败，员工已是团队成员。");
			}else{
				if(ts.getArchitectCount()==1){
					throw new TeamException("架构师人数已满(最多一人)");
				}else{
					if(ts.addMember(a)){
						System.out.println("添加成功");
						ts.setArchitectCount(ts.getArchitectCount()+1);
						TSUtility.readReturn();
					}else{
						System.out.println("添加失败");
					}
				}
			}
		}
	}
}
