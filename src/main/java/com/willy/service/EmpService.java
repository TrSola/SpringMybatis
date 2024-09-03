package com.willy.service;

import java.time.LocalDate;
import java.util.List;

import com.willy.pojo.Emp;
import com.willy.pojo.PageBean;

public interface EmpService {

	PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

	void delete(List<Integer> ids);

	void save(Emp emp);
	
}