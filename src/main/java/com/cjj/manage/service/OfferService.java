package com.cjj.manage.service;

import com.cjj.dto.CompanyWithJobDTO;
import com.cjj.request.offer.JobRequest;

public interface OfferService {
	CompanyWithJobDTO listCompanyAndJobs(JobRequest request);
}
