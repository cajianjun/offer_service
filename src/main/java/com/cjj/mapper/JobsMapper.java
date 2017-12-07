package com.cjj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cjj.entity.JobsEntity;

public interface JobsMapper {
	@Select("SELECT * FROM jobs limit #{fromindex},#{pagesize}")
	List<JobsEntity> listJobs(@Param("fromindex")Integer fromindex,@Param("pagesize")Integer pagesize);

	@Select("SELECT * FROM jobs where job_type = #{job_type} limit #{fromindex},#{pagesize}")
	List<JobsEntity> listJobs(@Param("job_type")String job_type,
			@Param("fromindex")Integer fromindex,@Param("pagesize")Integer pagesize);
	
	@Select("SELECT * FROM jobs limit #{fromindex},#{pagesize}")
	List<JobsEntity> listJobs(@Param("fromindex")Integer fromindex,@Param("pagesize")Integer pagesize);
}

