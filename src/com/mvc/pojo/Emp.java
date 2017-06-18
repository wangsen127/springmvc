package com.mvc.pojo;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.mvc.validation.ValidGroup1;

public class Emp {

	private Integer eid;
	@NotBlank(message="{emp.ename.isnull}",groups={ValidGroup1.class})
	@Size(min=4,max=8,message="{emp.ename.size}",groups={ValidGroup1.class})
	private String ename;
	@NotNull(message="{emp.sal.isnull}",groups={ValidGroup1.class})
	@DecimalMin(value="0",message="{emp.sal.min}",groups={ValidGroup1.class})
	private Double sal;
	@NotNull(message="{emp.hireDate.isnull}")
	private Date hireDate;
	private Dept dept;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", hireDate=" + hireDate + ", dept=" + dept
				+ "]";
	}
	
}
