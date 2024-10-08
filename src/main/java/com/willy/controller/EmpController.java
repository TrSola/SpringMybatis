package com.willy.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.willy.pojo.Emp;
import com.willy.pojo.PageBean;
import com.willy.pojo.Result;
import com.willy.service.EmpService;

@RestController
@RequestMapping("emps")
public class EmpController {

	@Autowired
	private EmpService empService;

	@GetMapping
	public Result page(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer pageSize, String name, Short gender,
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
		PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
		return Result.success(pageBean);
	}

	@DeleteMapping("/{ids}")
	public Result delete(@PathVariable List<Integer> ids) {
		empService.delete(ids);
		return Result.success();
	}

	@PostMapping
	public Result save(@RequestBody Emp emp) {
		empService.save(emp);
		return Result.success();
	}

	@GetMapping("/{id}")
	public Result getById(@PathVariable Integer id) {
		Emp emp = empService.getById(id);
	return Result.success(emp);
	}
	
	@PutMapping
	public Result update(@RequestBody Emp emp) {
		empService.update(emp);
		return Result.success();
	}
}