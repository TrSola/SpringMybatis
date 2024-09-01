package com.willy.service;

import java.util.List;

import com.willy.pojo.Dept;

public interface DeptService {
	
	List<Dept> list();

	void delete(Integer id);

	void add(Dept dept);

	void update(Dept dept);

}