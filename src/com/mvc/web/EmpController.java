package com.mvc.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.dao.EmpDao;
import com.mvc.pojo.Dept;
import com.mvc.pojo.Emp;
import com.mvc.pojo.EmpCustm;

@Controller
public class EmpController {
	
	@Autowired
	private EmpDao empDao;
	
	@RequestMapping("/listEmp.do")
	public String listEmp(HttpServletRequest request, Emp emp){
		
		List<Emp> emplist = empDao.listEmp(emp);
		List<Dept> deptlist = empDao.listDept();
		
		request.setAttribute("emplist", emplist);
		request.setAttribute("deptlist", deptlist);
		
		return "emp";
	}
	
	@RequestMapping("/delEmpAll.do")
	public String delEmpAll(Integer[] ids){
		
		empDao.delEmp(ids);
		
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/showEditsEmp.do")
	public String showEditsEmp(HttpServletRequest request, Emp emp){
		
		List<Emp> emplist = empDao.listEmp(emp);
		List<Dept> deptlist = empDao.listDept();
		
		request.setAttribute("emplist", emplist);
		request.setAttribute("deptlist", deptlist);
		
		return "emp_edits";
	}
	
	@RequestMapping("/editsEmp.do")
	public String editsEmp(EmpCustm empCustm){
		for (Emp emp : empCustm.getEmps()) {
			empDao.editEmp(emp);
		}
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/showSaveEmp.do")
	public String showSaveEmp(HttpServletRequest request){
		List<Dept> deptlist = empDao.listDept();
		
		request.setAttribute("deptlist", deptlist);
		return "emp_save";
	}
	
	@RequestMapping("/saveEmp.do")
	public String saveEmp(Emp emp){
		
		empDao.saveEmp(emp);
		
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/showEditEmp.do")
	public String showEditEmp(HttpServletRequest request, Integer eid){
		List<Dept> deptlist = empDao.listDept();
		Emp emp = empDao.getEmp(eid);
		
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("emp", emp);
		
		return "emp_edit";
	}
	
	@RequestMapping("/editEmp.do")
	public String editEmp(Emp emp){
		
		empDao.editEmp(emp);
		
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/delEmp.do")
	public String delEmp(Integer eid){
		
		empDao.delEmp(eid);
		
		return "redirect:listEmp.do";
	}
}
