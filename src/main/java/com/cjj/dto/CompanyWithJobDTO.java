package com.cjj.dto;

import java.util.List;

import com.cjj.entity.CompanyEntity;
import com.cjj.entity.JobsEntity;

import io.swagger.annotations.ApiModelProperty;

public class CompanyWithJobDTO {
	@ApiModelProperty(value = "公司信息")
	private  CompanyEntity company;
	@ApiModelProperty(value = "职位列表")
	private List<JobsEntity> list;
	public CompanyEntity getCompany() {
		return company;
	}
	public void setCompany(CompanyEntity company) {
		this.company = company;
	}
	public List<JobsEntity> getList() {
		return list;
	}
	public void setList(List<JobsEntity> list) {
		this.list = list;
	}
	public CompanyWithJobDTO(CompanyEntity company, List<JobsEntity> list) {
		super();
		this.company = company;
		this.list = list;
	}
	public CompanyWithJobDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CompanyWithJobDTO [company=" + company + ", list=" + list + ", getCompany()=" + getCompany()
				+ ", getList()=" + getList() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
} 
