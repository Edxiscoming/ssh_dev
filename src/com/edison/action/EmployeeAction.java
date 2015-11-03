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
 * Ա��ģ�����������
 * 1.Ա���б�չʾ
 * ClassName: EmployeeAction
 * @Description: TODO
 * @author Administrator
 * @date 2015��10��26��
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, RequestAware   {
	
	/**
	 * ��װ����
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
		request.put("listEmp",listEmp);
		return "list";
	}
	
	/**
	 * 2.�������Ա��ҳ��
	 */
	public String viewAdd(){
		//�Ȳ�����в��������Ա����ʱ�����ѡ����
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
	//�����޸Ľ���
	public String viewUpdate(){
		//�鵽���в���
		List<Dept> listDept=deptService.getAll();
		request.put("listDept", listDept);   
		//���ݵ���������ҳ���õĲ���id���鵽��Ҫ�޸ĵ�Ա���ĳ�ʼ��Ϣ
		int id=employee.getId();
		Employee emp=employeeService.findById(id);
		ValueStack vsStack=ActionContext.getContext().getValueStack();
		//�Ƴ�ջ��
		vsStack.pop();
		//�ѻ�õ�Ա����Ϣ����ջ
		vsStack.push(emp);
		return "edit";
	}
	//����
	public String update(){
		Dept dept=deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.update(employee);
		
		
		return "listAction";
	}
	//ɾ��Ա��
	public String delete() {
		
		int id=employee.getId();
		employeeService.delete(id);
		
		return "listAction";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ���տ������ʱ����Ĵ���request�����map
	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}


	
}
