package com.cjj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cjj.common.DBConsts;
import com.cjj.entity.JobsEntity;

public interface JobsMapper {
	@Select("SELECT * FROM " + DBConsts.T_JOBS
			+ " limit #{fromindex},#{pagesize}")
	List<JobsEntity> listJobsByPage(@Param("fromindex")Integer fromindex,@Param("pagesize")Integer pagesize);

	@Select("SELECT * FROM " + DBConsts.T_JOBS
			+ " WHERE job_type = #{job_type} limit #{fromindex},#{pagesize}")
	List<JobsEntity> listJobsByJobType(@Param("job_type")String job_type,
			@Param("fromindex")Integer fromindex,@Param("pagesize")Integer pagesize);
	
	@Select("SELECT * FROM " + DBConsts.T_JOBS
			+ " WHERE company_id=#{company_id}")
	List<JobsEntity> listJobsByCid(@Param("company_id")Integer company_id);
	
	@Select("SELECT * FROM " + DBConsts.T_JOBS
			+ " WHERE company_id in (#{ids})")
	List<JobsEntity> listJobsByCids(@Param("ids")String ids);
	
}

