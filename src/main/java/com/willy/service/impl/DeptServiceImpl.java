package com.willy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willy.mapper.DeptMapper;
import com.willy.pojo.Dept;
import com.willy.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	private final DeptMapper deptMapper;
	
	 public DeptServiceImpl(DeptMapper deptMapper) {
	        this.deptMapper = deptMapper;
	    }
	
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptMapper.list();
	}
}