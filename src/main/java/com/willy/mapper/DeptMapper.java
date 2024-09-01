package com.willy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.willy.pojo.Dept;

@Mapper
public interface DeptMapper {

	@Select("select * from dept")
	List<Dept> list();

}