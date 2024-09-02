package com.willy.service;

import com.willy.pojo.PageBean;

public interface EmpService {

	PageBean page(Integer page, Integer pageSize);

}
