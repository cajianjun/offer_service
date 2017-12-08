package com.cjj.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjj.dto.CompanyWithJobDTO;
import com.cjj.dto.JobsWithCompanyDTO;
import com.cjj.entity.CompanyEntity;
import com.cjj.entity.JobsEntity;
import com.cjj.manage.service.OfferService;
import com.cjj.mapper.CompanyMapper;
import com.cjj.mapper.JobsMapper;
import com.cjj.request.PageRequest;
import com.cjj.request.offer.JobRequest;
import com.cjj.util.StrUtils;
@Service
public class OfferServiceImpl implements OfferService{

	@Autowired
	JobsMapper jobsMapper;
	@Autowired
	CompanyMapper companyMapper; 
	
	@Override
	public List<JobsWithCompanyDTO> listJobsWithCompany(JobRequest request) {
		List<JobsEntity> jobs = null;
		if(StrUtils.EMPTY(request.getJob_type())) {
			jobs = jobsMapper.listJobsByPage(request.getFrom(),request.getPageSize());
		}else {
			String jobType = request.getJob_type();
			jobs = jobsMapper.listJobsByJobType(jobType,request.getFrom(),request.getPageSize());
		}
		
		List<String> companyIds = new ArrayList<String>();
		for(JobsEntity e:jobs) {
			if(!companyIds.contains(e.getCompanyId() + "")) {
				companyIds.add(e.getCompanyId() + "");
			}
		}
		
		String ids = StrUtils.list2String(companyIds,false);
		List<CompanyEntity> companys = companyMapper.listCompanyByIds(ids);
		Map<Integer,CompanyEntity> id_comp = new HashMap<Integer,CompanyEntity>();
		companys.forEach(x->{
			id_comp.put(x.getId(),x);
		});
		
		List<JobsWithCompanyDTO> respList = new ArrayList<JobsWithCompanyDTO>();
		jobs.forEach(x->{
			JobsWithCompanyDTO dto = new JobsWithCompanyDTO();
			dto.setCompany(id_comp.get(x.getCompanyId()));
			dto.setJob(x);
			respList.add(dto);
		});
		return respList;
	}

	@Override
	public List<CompanyWithJobDTO> listCompanyWithJobs(PageRequest request) {
		
		List<CompanyEntity> cmps = companyMapper.listCompanyByPage(request.getFrom(),request.getPageSize());
		List<String> cids = new ArrayList<String>();
		cmps.forEach(x->{
			cids.add(x.getId() + "");
		});
		String whereInStr = StrUtils.list2String(cids,false);
		List<JobsEntity> jobsEntities = jobsMapper.listJobsByCids(whereInStr);
		List<CompanyWithJobDTO> respList = new ArrayList<CompanyWithJobDTO>();
		Map<Integer,CompanyWithJobDTO> cid_cwjd = new HashMap<Integer,CompanyWithJobDTO>();
		cmps.forEach(x->{
			CompanyWithJobDTO dto = new CompanyWithJobDTO();
			respList.add(dto);
			List<JobsEntity> tmpJobs = new ArrayList<JobsEntity>();
			dto.setCompany(x);
			dto.setList(tmpJobs);
			cid_cwjd.put(x.getId(), dto);
		});
		jobsEntities.forEach(x->{
			cid_cwjd.get(x.getCompanyId()).getList().add(x);
		});
		return respList;
	}

}
