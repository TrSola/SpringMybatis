package com.willy.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.willy.mapper.EmpMapper;
import com.willy.pojo.Emp;
import com.willy.pojo.PageBean;
import com.willy.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;
	
//	@Override
//	public PageBean page(Integer page, Integer pageSize) {
//		// TODO Auto-generated method stub
//		Long count = empMapper.count();
//		
//		Integer start = (page - 1) * pageSize;
//		List<Emp> empList = empMapper.page(start, pageSize);
//		
//		PageBean pageBean = new PageBean(count, empList);
//		return pageBean;
//	}
	
	@Override
	public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
		//設置分頁參數
		PageHelper.startPage(page, pageSize);
		//查詢
		List<Emp> empList = empMapper.list(name, gender, begin, end);
		Page<Emp> p = (Page<Emp>) empList;
		PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
		return pageBean;
	}

	@Override
	public void delete(List<Integer> ids) {
		empMapper.delete(ids);
	}

}
