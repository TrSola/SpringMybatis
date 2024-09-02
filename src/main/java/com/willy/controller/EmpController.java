package com.willy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.willy.pojo.PageBean;
import com.willy.pojo.Result;
import com.willy.service.EmpService;


@RestController
public class EmpController { 
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/emps")
	public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize) {
		PageBean pageBean = empService.page(page, pageSize);
		return Result.success(pageBean);
	}
}
