package com.cjj.request;

import io.swagger.annotations.ApiModelProperty;

public class AidRequest {
	@ApiModelProperty(value = "专利申请号", required = true)
	private String aid;

	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
}
