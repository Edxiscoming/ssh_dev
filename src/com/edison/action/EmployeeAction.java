package com.edison.action;

import java.util.List;
import java.util.Map;

import com.edison.entity.Employee;
import com.edison.service.IDeptService;
import com.edison.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 员工模块控制器开发
 * 1.员工列表展示
 * ClassName: EmployeeAction
 * @Description: TODO
 * @author Administrator
 * @date 2015年10月26日
 */
public class EmployeeAction {
	
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
		Map<String,Object> request=(Map<String,Object>)ActionContext.getContext().get("request");
		request.put("listEmp",listEmp);
		return "list";
		
		
	}
	
}
