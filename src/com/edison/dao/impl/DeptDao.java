package com.edison.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edison.dao.IDeptDao;
import com.edison.entity.Dept;

public class DeptDao implements IDeptDao {

	//IOCÈÝÆ÷×¢ÈëSessionFactory¶ÔÏó
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
	@SuppressWarnings("unchecked")	
	@Override
	public List<Dept> getAll() {
	
		return sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

	@Override
	public Dept findById(int id) {
		return (Dept)sessionFactory.getCurrentSession().get(Dept.class, id);
		
	}

}
