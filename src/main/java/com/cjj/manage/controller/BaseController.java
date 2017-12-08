package com.cjj.manage.controller;

import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {
	protected void logger(Logger logger,String desc, String username,Object request) {
		logger.info(desc + ",username={},request = {}", username,request.toString());
	}
	
	protected String username() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return username;
	}
}
