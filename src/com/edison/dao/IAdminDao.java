package com.edison.dao;

import com.edison.entity.Admin;

public interface IAdminDao {
	//保存管理员
	void save(Admin admin);
	//根据管理员信息查询
	Admin findByAdmin(Admin admin);
	
	
	
}
