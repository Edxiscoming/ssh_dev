package com.edison.dao;



import java.util.List;

import com.edison.entity.Dept;



/**
 * 部门模块dao接口设计
 * 
 * @author Jie.Yuan
 * 
 */
public interface IDeptDao {

	/**
	 * 查询全部
	 * @return 返回全部信息
	 */
	List<Dept> getAll();

	/**
	 * 根据主键查询
	 * @param id  主键
	 * @return 返回查询后的结果
	 */
	Dept findById(int id);

}
