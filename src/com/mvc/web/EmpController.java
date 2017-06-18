package com.mvc.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.dao.EmpDao;
import com.mvc.exception.CustomException;
import com.mvc.pojo.Dept;
import com.mvc.pojo.Emp;
import com.mvc.pojo.EmpCustm;
import com.mvc.validation.ValidGroup1;

@Controller
public class EmpController {
	
	@Autowired
	private EmpDao empDao;
	
	@RequestMapping("/listEmp.do")
	public String listEmp(HttpServletRequest request, Emp emp)  throws Exception{
		
		List<Emp> emplist = empDao.listEmp(emp);
		List<Dept> deptlist = empDao.listDept();
		
		request.setAttribute("emplist", emplist);
		request.setAttribute("deptlist", deptlist);
		
		return "emp";
	}
	
	@RequestMapping("/delEmpAll.do")
	public String delEmpAll(Integer[] ids)  throws Exception{
		
		empDao.delEmp(ids);
		
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/showEditsEmp.do")
	public String showEditsEmp(HttpServletRequest request, Emp emp)  throws Exception{
		
		List<Emp> emplist = empDao.listEmp(emp);
		List<Dept> deptlist = empDao.listDept();
		
		request.setAttribute("emplist", emplist);
		request.setAttribute("deptlist", deptlist);
		
		return "emp_edits";
	}
	
	@RequestMapping("/editsEmp.do")
	public String editsEmp(EmpCustm empCustm)  throws Exception{
		for (Emp emp : empCustm.getEmps()) {
			empDao.editEmp(emp);
		}
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/showSaveEmp.do")
	public String showSaveEmp(HttpServletRequest request)  throws Exception{
//		List<Dept> deptlist = empDao.listDept();
//		request.setAttribute("deptlist", deptlist);
		return "emp_save";
	}
	
	/**
	 * 在跳转校验错误页面前，springmvc会将pojo对象自动放入request域中
	 * 而@ModelAttribute可以设置request域中pojo对象的名称
	 */
	@RequestMapping("/saveEmp.do")
	public String saveEmp(HttpServletRequest request, 
			@ModelAttribute("empBean")@Validated(value=ValidGroup1.class) Emp emp, BindingResult bs)  throws Exception{
		
		if(bs.hasErrors()){
			List<ObjectError> allErrors = bs.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			request.setAttribute("allErrors", allErrors);
			return "forward:showSaveEmp.do";
		}
		
		empDao.saveEmp(emp);
		
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/showEditEmp.do")
	public String showEditEmp(HttpServletRequest request, Integer eid)  throws Exception{
		List<Dept> deptlist = empDao.listDept();
		Emp emp = empDao.getEmp(eid);
		
		if(emp == null){
			throw new CustomException("修改的员工信息不存在！");
		}
		
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("emp", emp);
		
		return "emp_edit";
	}
	
	@RequestMapping("/editEmp.do")
	public String editEmp(Emp emp)  throws Exception{
		
		empDao.editEmp(emp);
		
		return "redirect:listEmp.do";
	}
	
	@RequestMapping("/delEmp.do")
	public String delEmp(Integer eid)  throws Exception{
		
		empDao.delEmp(eid);
		
		return "redirect:listEmp.do";
	}
	
	/**
	 * @ModelAttribute将方法的返回值放入request域中
	 */
	@ModelAttribute("deptlist")
	public List<Dept> listDept()  throws Exception{
		return empDao.listDept();
	}
}
