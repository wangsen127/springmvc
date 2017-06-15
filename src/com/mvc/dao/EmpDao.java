package com.mvc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.pojo.Dept;
import com.mvc.pojo.Emp;

@Repository
public class EmpDao {

	private List<Emp> emplist = new ArrayList<Emp>();
	private List<Dept> deptlist = new ArrayList<Dept>();
	/**
	 * 模拟保存
	 */
	public void saveEmp(Emp emp){
		emp.setEid(emplist.get(emplist.size()-1).getEid()+1);
		emplist.add(emp);
	}
	/**
	 * 模拟修改
	 */
	public void editEmp(Emp emp){
		for (int i = 0; i < emplist.size(); i++) {
			Emp e = emplist.get(i);
			if(e.getEid().equals(emp.getEid())){
				emplist.set(i, emp);
				break;
			}
		}
	}
	/**
	 * 模拟修改
	 */
	public void delEmp(Integer eid){
		for (int i = 0; i < emplist.size(); i++) {
			Emp e = emplist.get(i);
			if(e.getEid().equals(eid)){
				emplist.remove(i);
				break;
			}
		}
	}
	/**
	 * 模拟查询单个
	 */
	public Emp getEmp(Integer eid){
		for (int i = 0; i < emplist.size(); i++) {
			Emp e = emplist.get(i);
			if(e.getEid().equals(eid)){
				return e;
			}
		}
		return null;
	}
	/**
	 * 模拟批量删除emp
	 */
	public void delEmp(Integer[] ids){
		if(ids != null && ids.length!=0){
			for (Integer id : ids) {
				for (Emp e : emplist) {
					if(id.equals(e.getEid())){
						emplist.remove(e);
						break;
					}
				}
			}
		}
	}
	/**
	 * 模拟条件查询
	 */
	public List<Emp> listEmp(Emp emp){
		List<Emp> list = new ArrayList<Emp>();
		if(emp.getEname()==null && emp.getDept()==null
				|| emp.getEname().equals("") && emp.getDept().getDid().equals(0)){
			return emplist;
		}
		if(!emp.getEname().equals("") && emp.getDept().getDid().equals(0)){
			for (Emp e : emplist) {
				if(emp.getEname().equals(e.getEname())){
					list.add(e);
				}
			}
			
		}else if(emp.getEname().equals("") && !emp.getDept().getDid().equals(0)){
			for (Emp e : emplist) {
				if(emp.getDept().getDid().equals(e.getDept().getDid())){
					list.add(e);
				}
			}
		}else{
			for (Emp e : emplist) {
				if(emp.getEname().equals(e.getEname()) && 
						emp.getDept().getDid().equals(e.getDept().getDid())){
					list.add(e);
				}
			}
		}
		return list;
	}
	/**
	 * 模拟查询全部dept
	 */
	public List<Dept> listDept(){
		return deptlist;
	}
	/**
	 * 模拟查询全部emp
	 */
	public List<Emp> listEmpAll(){
		return emplist;
	}
	/**
	 * 初始化模拟数据
	 */
	public EmpDao(){
		//部门
		Dept d1 = new Dept();
		d1.setDid(10);
		d1.setDname("销售部");
		Dept d2 = new Dept();
		d2.setDid(20);
		d2.setDname("人事部");
		Dept d3 = new Dept();
		d3.setDid(30);
		d3.setDname("财务部");
		deptlist.add(d1);
		deptlist.add(d2);
		deptlist.add(d3);
		//员工
		Date hireDate = new Date();
		Emp e1 = new Emp();
		e1.setEid(1001);
		e1.setEname("张三");
		e1.setSal(3500.0);
		e1.setHireDate(hireDate);
		e1.setDept(d1);
		Emp e2 = new Emp();
		e2.setEid(1002);
		e2.setEname("李四");
		e2.setSal(4200.0);
		e2.setHireDate(hireDate);
		e2.setDept(d1);
		Emp e3 = new Emp();
		e3.setEid(1003);
		e3.setEname("郭靖");
		e3.setSal(5700.0);
		e3.setHireDate(hireDate);
		e3.setDept(d2);
		Emp e4 = new Emp();
		e4.setEid(1004);
		e4.setEname("黄蓉");
		e4.setSal(4800.0);
		e4.setHireDate(hireDate);
		e4.setDept(d2);
		Emp e5 = new Emp();
		e5.setEid(1005);
		e5.setEname("汤姆");
		e5.setSal(2500.0);
		e5.setHireDate(hireDate);
		e5.setDept(d3);
		Emp e6 = new Emp();
		e6.setEid(1006);
		e6.setEname("杰瑞");
		e6.setSal(1800.0);
		e6.setHireDate(hireDate);
		e6.setDept(d3);
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		emplist.add(e4);
		emplist.add(e5);
		emplist.add(e6);
	}
}
