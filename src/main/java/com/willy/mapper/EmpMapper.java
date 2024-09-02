package com.willy.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.willy.pojo.Emp;

@Mapper
public interface EmpMapper {
	
//	@Select("select count(*) from emp")
//	public Long count();
//	
//	@Select("select * from emp limit ${start}, #{pageSize}")
//	public List<Emp> page(Integer start, Integer pageSize);
	
//	@Select("select * from emp where ")
	public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

	public void delete(List<Integer> ids);
}
