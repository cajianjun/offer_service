package com.cjj.manage.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.cjj.common.DBConsts;
import com.cjj.util.StrUtils;

@Component
@ConfigurationProperties(prefix = "common.conf")
public class CommonProperties {
	
	private String picHost;
	private String baseDbname;

	

	public String getBaseDbname() {
		return baseDbname;
	}

	public void setBaseDbname(String baseDbname) {
		this.baseDbname = baseDbname;
	}

	public String getPicHost() {
		return picHost;
	}

	public void setPicHost(String picHost) {
		this.picHost = picHost;
	}
	
	@PostConstruct
	public void afterPropertiesSet() {
		StrUtils.prefix = picHost;
		DBConsts.DBNAME_BASE = baseDbname;
	}
}
