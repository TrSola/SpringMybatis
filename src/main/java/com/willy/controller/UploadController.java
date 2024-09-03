package com.willy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.willy.pojo.Result;

@RestController
public class UploadController {

	@PostMapping("/upload")
	public Result upload(String username, Integer age, MultipartFile image) {
	return Result.success();
}
}