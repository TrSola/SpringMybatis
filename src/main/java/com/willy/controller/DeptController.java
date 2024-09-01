package com.willy.controller;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@DeleteMapping("/depts/{id}")
	public Result delete(@PathVariable Integer id) {
		log.info("根據id刪除部門:{}", id);
		deptService.delete(id);
		return Result.success();
	}
	
	@PostMapping("/depts")
	public Result add(@RequestBody Dept dept) {
		log.info("新增部門：{}", dept);
		deptService.add(dept);
		return Result.success();
	}
	
	@PutMapping("/depts/{id}")
	public Result update(@PathVariable Integer id ,@RequestBody Dept dept) {
		log.info("根據id更新部門:{}", dept);
		dept.setId(id);
		deptService.update(dept);
		return Result.success();
	}
}