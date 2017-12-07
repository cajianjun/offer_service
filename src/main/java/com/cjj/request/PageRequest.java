package com.cjj.request;

import io.swagger.annotations.ApiModelProperty;

public class PageRequest {
	@ApiModelProperty(value = "size of per page ,default:10", required = true)
	protected Integer pageSize;
	@ApiModelProperty(value = "current page index ,default:1", required = true)
	protected Integer page;
	public Integer getPageSize() {
		if(pageSize == null || pageSize <= 0)return 10;
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPage() {
		if(page == null || page <= 0)return 1;
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public PageRequest() {
		super();
	}
	
	public Integer getFrom() {
		return (this.getPage()-1)*this.getPageSize();
	}
	@Override
	public String toString() {
		return "PageRequest [pageSize=" + pageSize + ", page=" + page + "]";
	}
	
	
}
