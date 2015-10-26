package com.edison.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edison.dao.IEmployeeDao;
import com.edison.entity.Employee;

public class EmployeeDao implements IEmployeeDao {

	//IOC容器注入SessionFactory对象
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public void delete(int id) {
		//HQL语句区分大小写，对象/对象属性区分大小写
		//数据库关键字不区分大小写
		sessionFactory.getCurrentSession().createQuery("delete from Employee where id=?").setParameter(0, id).executeUpdate();
		
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(String employeeName) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee where empName like ?")
				.setParameter(0, "%"+employeeName+"%")
				.list();
	}

}
