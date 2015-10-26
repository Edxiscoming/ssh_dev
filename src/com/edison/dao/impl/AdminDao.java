package com.edison.dao.impl;

import org.hibernate.SessionFactory;

import com.edison.dao.IAdminDao;
import com.edison.entity.Admin;

public class AdminDao implements IAdminDao {

	//IOCÈÝÆ÷×¢ÈëSessionFactory¶ÔÏó
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(admin);
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		// TODO Auto-generated method stub
		 return (Admin)sessionFactory.getCurrentSession().createQuery("from Admin where adminName=? and pwd=?")
		 .setString(0, admin.getAdminName())
		 .setString(1, admin.getPwd())
		 .uniqueResult();
	}

}
