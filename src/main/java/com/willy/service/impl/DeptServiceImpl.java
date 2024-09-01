package com.willy.service.impl;

import java.time.LocalDateTime;
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

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		deptMapper.deleteById(id);
	}

	@Override
	public void add(Dept dept) {
		// TODO Auto-generated method stub
		dept.setCreateTime(LocalDateTime.now());
		dept.setUpdateTime(LocalDateTime.now());
		deptMapper.insert(dept);
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		dept.setUpdateTime(LocalDateTime.now());
		deptMapper.update(dept);
	}
}