package com.cjj.dto;

import com.cjj.entity.CompanyEntity;
import com.cjj.entity.JobsEntity;

public class JobsWithCompanyDTO {
	private JobsEntity job;
	private CompanyEntity company;
	public JobsEntity getJob() {
		return job;
	}
	public void setJob(JobsEntity job) {
		this.job = job;
	}
	public CompanyEntity getCompany() {
		return company;
	}
	public void setCompany(CompanyEntity company) {
		this.company = company;
	}
	public JobsWithCompanyDTO(JobsEntity job, CompanyEntity company) {
		super();
		this.job = job;
		this.company = company;
	}
	public JobsWithCompanyDTO() {
		super();
	}
	
}
