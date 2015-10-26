package com.edison.service.impl;

import java.util.List;

import com.edison.dao.IDeptDao;
import com.edison.entity.Dept;
import com.edison.service.IDeptService;

public class DeptService implements IDeptService {
	
	private IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public Dept findById(int id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> getAll() {
		return deptDao.getAll();
	}

}
