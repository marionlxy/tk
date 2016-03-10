package com.taikang.iu.biz.appliance.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class MyMultipartResolver extends CommonsMultipartResolver{
	@Override
	public boolean isMultipart(HttpServletRequest request) {
		if(request.getRequestURI().contains("/kindeditor/upload/")){
			return false;
		}else{
			return super.isMultipart(request);
		}
		
	}
}
