package com.edison.dao;

import com.edison.entity.Admin;

public interface IAdminDao {
	//�������Ա
	void save(Admin admin);
	//���ݹ���Ա��Ϣ��ѯ
	Admin findByAdmin(Admin admin);
	
	
	
}
