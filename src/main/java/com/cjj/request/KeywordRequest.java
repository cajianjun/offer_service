package com.cjj.request;

import io.swagger.annotations.ApiModelProperty;

public class KeywordRequest{
	
	@ApiModelProperty(value = "关键字", required = true)
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "KeywordRequest [keyword=" + keyword + ", getKeyword()=" + getKeyword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
