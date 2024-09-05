package com.willy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.willy.pojo.Emp;
import com.willy.pojo.Result;
import com.willy.service.EmpService;
import com.willy.utils.JwtUtils;

@RestController
public class LoginController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/login.html/login")
	public Result login(@RequestBody Emp emp) {  
		Emp e = empService.login(emp);
		
		// 登錄成功，生成令牌，發放令牌
		if (e != null) {
		    Map<String, Object> claims = new HashMap<>(); // 創建一個 HashMap 來存儲聲明
		    claims.put("id", e.getId()); // 添加 id 聲明
		    claims.put("name", e.getName()); // 添加姓名聲明
		    claims.put("username", e.getUsername()); // 添加用戶名聲明

		    String jwt = JwtUtils.generateToken(claims, 0); // jwt 包含了當前登錄的員工信息
		    return Result.success(jwt); // 返回成功結果和 jwt
		}

		
		return e != null?Result.success():Result.error("用戶名或密碼錯誤");
	}
}
