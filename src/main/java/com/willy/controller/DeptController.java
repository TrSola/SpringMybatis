package com.willy.controller;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willy.pojo.Dept;
import com.willy.pojo.Result;
import com.willy.service.DeptService;


@RestController
public class DeptController {
	
	private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    private final DeptService deptService;
    
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }
	
	@GetMapping("/depts")
	public Result list() {
		log.info("查詢所有部門數據");
		
		List<Dept> deptList = deptService.list();
		
		return Result.success(deptList);
	}
}