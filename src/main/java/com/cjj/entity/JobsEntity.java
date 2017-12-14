package com.cjj.entity;
import java.util.Date;
import java.math.BigDecimal;
public class JobsEntity{
	private Integer id;
	private Integer companyId;
	private String jobName;
	private String jobType;
	private BigDecimal salaryF;
	private BigDecimal salaryT;
	private String keywords;
	private String school;
	private String thirdpartId;
	private String thirdpartUrl;
	private Date datetimeCreate;
	private Integer isDeleted;
	public JobsEntity(){}
	public JobsEntity(Integer id,Integer companyId,String jobName,String jobType,BigDecimal salaryF,BigDecimal salaryT,String keywords,String school,String thirdpartId,String thirdpartUrl,Date datetimeCreate,Integer isDeleted){
		this();
		this.id=id;
		this.companyId=companyId;
		this.jobName=jobName;
		this.jobType=jobType;
		this.salaryF=salaryF;
		this.salaryT=salaryT;
		this.keywords=keywords;
		this.school=school;
		this.thirdpartId=thirdpartId;
		this.thirdpartUrl=thirdpartUrl;
		this.datetimeCreate=datetimeCreate;
		this.isDeleted=isDeleted;
	}
	public void setId(Integer id){this.id=id;}
	public Integer getId(){return id;}
	public void setCompanyId(Integer companyId){this.companyId=companyId;}
	public Integer getCompanyId(){return companyId;}
	public void setJobName(String jobName){this.jobName=jobName;}
	public String getJobName(){return jobName;}
	public void setJobType(String jobType){this.jobType=jobType;}
	public String getJobType(){return jobType;}
	public void setSalaryF(BigDecimal salaryF){this.salaryF=salaryF;}
	public BigDecimal getSalaryF(){return salaryF;}
	public void setSalaryT(BigDecimal salaryT){this.salaryT=salaryT;}
	public BigDecimal getSalaryT(){return salaryT;}
	public void setKeywords(String keywords){this.keywords=keywords;}
	public String getKeywords(){return keywords;}
	public void setSchool(String school){this.school=school;}
	public String getSchool(){return school;}
	public void setThirdpartId(String thirdpartId){this.thirdpartId=thirdpartId;}
	public String getThirdpartId(){return thirdpartId;}
	public void setThirdpartUrl(String thirdpartUrl){this.thirdpartUrl=thirdpartUrl;}
	public String getThirdpartUrl(){return thirdpartUrl;}
	public void setDatetimeCreate(Date datetimeCreate){this.datetimeCreate=datetimeCreate;}
	public Date getDatetimeCreate(){return datetimeCreate;}
	public void setIsDeleted(Integer isDeleted){this.isDeleted=isDeleted;}
	public Integer getIsDeleted(){return isDeleted;}
}