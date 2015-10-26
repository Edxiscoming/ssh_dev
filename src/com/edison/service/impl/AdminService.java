package com.edison.service.impl;


import com.edison.dao.IAdminDao;
import com.edison.entity.Admin;
import com.edison.service.IAdminService;

public class AdminService implements IAdminService {
	
	// ע��dao  ������һ��Ҫ�ýӿڽ��ա�
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
