package com.edison.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.edison.entity.Admin;
import com.edison.entity.Dept;
import com.edison.entity.Employee;
import com.edison.service.IDeptService;
import com.edison.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 员工模块控制器开发
 * 1.员工列表展示
 * ClassName: EmployeeAction
 * @Description: TODO
 * @author Administrator
 * @date 2015年10月26日
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, RequestAware   {
	
	/**
	 * 封装数据
	 */
	private Employee employee=new Employee();
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	private int deptId;
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getDeptId() {
		return deptId;
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}

	
	
	//注入员工service
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	// 部门Service
		private IDeptService deptService;
		public void setDeptService(IDeptService deptService) {
			this.deptService = deptService;
		}
	
	
	/**
	 * 1.员工列表展示
	 */
	public String list(){
		//查询所有员工
		List<Employee> listEmp=employeeService.getAll();
		//保存到request
		request.put("listEmp",listEmp);
		return "list";
	}
	
	/**
	 * 2.进入添加员工页面
	 */
	public String viewAdd(){
		//先查出所有部门在添加员工的时候可以选择部门
		List<Dept> listDept=deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	
	
	public String save() {
		Dept dept=deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.save(employee);
		
		
		return "listAction";
		
	}
	//进入修改界面
	public String viewUpdate(){
		//查到所有部门
		List<Dept> listDept=deptService.getAll();
		request.put("listDept", listDept);   
		//根据点击进入更新页面获得的参数id，查到需要修改的员工的初始信息
		int id=employee.getId();
		Employee emp=employeeService.findById(id);
		ValueStack vsStack=ActionContext.getContext().getValueStack();
		//移除栈顶
		vsStack.pop();
		//把获得的员工信息加入栈
		vsStack.push(emp);
		return "edit";
	}
	//更新
	public String update(){
		Dept dept=deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.update(employee);
		
		
		return "listAction";
	}
	//删除员工
	public String delete() {
		
		int id=employee.getId();
		employeeService.delete(id);
		
		return "listAction";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 接收框架运行时候传入的代表request对象的map
	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}


	
}
