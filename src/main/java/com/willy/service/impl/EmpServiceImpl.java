package com.willy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willy.mapper.EmpMapper;
import com.willy.pojo.Emp;
import com.willy.pojo.PageBean;
import com.willy.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public PageBean page(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		Long count = empMapper.count();
		
		Integer start = (page - 1) * pageSize;
		List<Emp> empList = empMapper.page(start, pageSize);
		
		PageBean pageBean = new PageBean(count, empList);
		return pageBean;
	}

}
