package com.willy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.willy.pojo.Emp;

@Mapper
public interface EmpMapper {
	
	@Select("select count(*) from emp")
	public Long count();
	
	@Select("select * from emp limit ${start}, #{pageSize}")
	public List<Emp> page(Integer start, Integer pageSize);
}
