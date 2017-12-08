package com.cjj.manage.service;

import java.util.List;

import com.cjj.dto.CompanyWithJobDTO;
import com.cjj.dto.JobsWithCompanyDTO;
import com.cjj.request.PageRequest;
import com.cjj.request.offer.JobRequest;

public interface OfferService {
	/**
	 * list jobs with its company informations
	 * @param request
	 * @return
	 */
	List<JobsWithCompanyDTO> listJobsWithCompany(JobRequest request);
	
	/**
	 * list company with its jobs informations
	 * @param request
	 * @return
	 */
	List<CompanyWithJobDTO> listCompanyWithJobs(PageRequest request);
}
