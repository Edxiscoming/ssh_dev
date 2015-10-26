package com.edison.action;

import java.util.List;
import java.util.Map;

import com.edison.entity.Employee;
import com.edison.service.IDeptService;
import com.edison.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;

/**
 * Ա��ģ�����������
 * 1.Ա���б�չʾ
 * ClassName: EmployeeAction
 * @Description: TODO
 * @author Administrator
 * @date 2015��10��26��
 */
public class EmployeeAction {
	
	//ע��Ա��service
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	// ����Service
		private IDeptService deptService;
		public void setDeptService(IDeptService deptService) {
			this.deptService = deptService;
		}
	
	
	/**
	 * 1.Ա���б�չʾ
	 */
	public String list(){
		//��ѯ����Ա��
		List<Employee> listEmp=employeeService.getAll();
		//���浽request
		Map<String,Object> request=(Map<String,Object>)ActionContext.getContext().get("request");
		request.put("listEmp",listEmp);
		return "list";
		
		
	}
	
}
