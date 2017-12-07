package com.cjj.manage.service.impl;

import com.cjj.dto.CompanyWithJobDTO;
import com.cjj.manage.service.OfferService;
import com.cjj.request.offer.JobRequest;
import com.cjj.util.StrUtils;

public class OfferServiceImpl implements OfferService{

	@Override
	public CompanyWithJobDTO listCompanyAndJobs(JobRequest request) {
		if(StrUtils.EMPTY(request.getJob_type())) {
			
		}else {
			String jobType = request.getJob_type();
			
		}
		return null;
	}

}
