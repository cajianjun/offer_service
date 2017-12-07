package com.cjj.manage.controller;

import org.slf4j.Logger;

public class BaseController {
	protected void logger(Logger logger,String desc, String username,Object request) {
		logger.info(desc + ",username={},request = {}", username,request.toString());
	}
}
