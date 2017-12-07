package com.cjj.request.offer;

import com.cjj.request.PageRequest;

import io.swagger.annotations.ApiModelProperty;

public class JobRequest extends PageRequest{
	@ApiModelProperty(value = "type of job like,JAVA,PHP", required = true)
	private String job_type;

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public JobRequest(String job_type) {
		super();
		this.job_type = job_type;
	}

	public JobRequest() {
		super();
	}

	@Override
	public String toString() {
		return "JobRequest [job_type=" + job_type + ", pageSize=" + pageSize + ", page=" + page + ", getJob_type()="
				+ getJob_type() + ", getPageSize()=" + getPageSize() + ", getPage()=" + getPage() + ", getFrom()="
				+ getFrom() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
}
