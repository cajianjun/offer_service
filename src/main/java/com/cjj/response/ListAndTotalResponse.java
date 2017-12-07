package com.cjj.response;

public class ListAndTotalResponse {
	private Object list;
	private Integer total;
	public Object getList() {
		return list;
	}
	public void setList(Object list) {
		this.list = list;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public void setTotal(Long total) {
		this.total = Integer.valueOf(total + "");
	}
	
}
