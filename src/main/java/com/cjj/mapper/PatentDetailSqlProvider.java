package com.cjj.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.cjj.util.StrUtils;

public class PatentDetailSqlProvider {
	
	public String getTransfer(String aid)  
	{  
		String tableName = "transfer";
		return selectAllFromTable(aid, tableName);
	}
	
	
	
	private String selectAllFromTable(String aid,String tbName) {
		
		String dbName = "patent_";
		return new SQL() {{  
			SELECT("*");  
			FROM("`" + dbName + "`.`" + tbName + "`");  
			WHERE("aid='" + aid + "'");  
			}}.toString();  
	}
}
