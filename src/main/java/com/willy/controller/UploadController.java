package com.willy.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.willy.pojo.Result;

@RestController
public class UploadController {

	@PostMapping("/upload")
	public Result upload(String username, Integer age, MultipartFile image) throws Exception {
	    
	    String originalFilename = image.getOriginalFilename();
	    
	    int index = originalFilename.lastIndexOf(".");
	    String extname = originalFilename.substring(index);
	    String newFileName = UUID.randomUUID().toString() + extname;
	    
	    image.transferTo(new File("/Users/willy/eclipse-workspace/SpringMybatis/src/main/resources/static/" + newFileName));
	    
	    return Result.success();
	}
}