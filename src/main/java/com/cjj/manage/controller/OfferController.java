package com.cjj.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjj.common.Constants;
import com.cjj.common.ErrorCode;
import com.cjj.dto.CompanyWithJobDTO;
import com.cjj.dto.JobsWithCompanyDTO;
import com.cjj.manage.service.OfferService;
import com.cjj.request.PageRequest;
import com.cjj.request.offer.JobRequest;
import com.cjj.response.GeneralResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = Constants.ROUTE_OFFER)
public class OfferController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);
	
	@Autowired
	private OfferService offerService;
	
	@ApiOperation(value="公司列表", notes="获取公司列表，并返回各个公司的职位表", produces = "application/json")  
    @ApiResponses({ 
			@ApiResponse(code = 200, message = "获取成功",response =CompanyWithJobDTO.class )
	})
	@RequestMapping(value = "listc", method = RequestMethod.POST)
	public GeneralResponse listc(@RequestBody PageRequest request) {
		logger(logger,"listc" ,"", request);
		offerService.listCompanyWithJobs(request);
		return new GeneralResponse(offerService.listCompanyWithJobs(request), ErrorCode.OK);
	}
	
	@ApiOperation(value="职位列表", notes="获取职位列表，并返回各个职位的公司信息", produces = "application/json")  
    @ApiResponses({ 
			@ApiResponse(code = 200, message = "获取成功",response =JobsWithCompanyDTO.class )
	})
	@RequestMapping(value = "listj", method = RequestMethod.POST)
	public GeneralResponse listj(@RequestBody JobRequest request) {
		logger(logger,"listj" ,"", request);
		return new GeneralResponse(offerService.listJobsWithCompany(request), ErrorCode.OK);
	}
}
