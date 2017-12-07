package com.cjj.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjj.common.Constants;
import com.cjj.common.ErrorCode;
import com.cjj.manage.service.UserService;
import com.cjj.request.PageRequest;
import com.cjj.response.GeneralResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = Constants.ROUTE_USER)
public class UserController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="获取子账号列表", notes="管理员获取子账号列表", produces = "application/json")  
//    @ApiResponses({ 
//			@ApiResponse(code = 200, message = "获取成功",response =OrderDetailDTO.class )
//	})
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public GeneralResponse getOrder(@RequestBody PageRequest request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger(logger,"list user" ,username, request);
//		List<UserDTO> list = userService.list(username);
		return new GeneralResponse("", ErrorCode.OK);
	}
	
}
