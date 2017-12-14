package com.cjj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cjj.common.DBConsts;
import com.cjj.entity.CompanyEntity;

public interface CompanyMapper {
	@Select("SELECT * FROM " + DBConsts.T_COMPANY
			+ " limit #{fromindex},#{pagesize}")
	List<CompanyEntity> listCompanyByPage(@Param("fromindex")Integer fromindex,@Param("pagesize")Integer pagesize);
	
	@Select("SELECT * FROM " + DBConsts.T_COMPANY
			+ " WHERE id in (${ids})")
	List<CompanyEntity> listCompanyByIds(@Param("ids")String ids);
}
