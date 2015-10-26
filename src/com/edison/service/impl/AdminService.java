package com.edison.service.impl;


import com.edison.dao.IAdminDao;
import com.edison.entity.Admin;
import com.edison.service.IAdminService;

public class AdminService implements IAdminService {
	
	// 注入dao  【这里一定要用接口接收】
	private IAdminDao adminDao; //JDK
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}	

	@Override
	public Admin login(Admin admin) {
		return adminDao.findByAdmin(admin);
	}

	@Override
	public void register(Admin admin) {
		adminDao.save(admin);
	}

}
