package com.cjj.entity;
import java.util.Date;
public class CompanyEntity{
	private Integer id;
	private String name;
	private String address;
	private String contractor;
	private String phone;
	private String email;
	private String website;
	private String fax;
	private String introduce;
	private String jsonArr;
	private String thirdpartId;
	private String thirdpartUrl;
	private Date datetimeCreate;
	private Integer isDeleted;
	public CompanyEntity(){}
	public CompanyEntity(Integer id,String name,String address,String contractor,String phone,String email,String website,String fax,String introduce,String jsonArr,String thirdpartId,String thirdpartUrl,Date datetimeCreate,Integer isDeleted){
		this();
		this.id=id;
		this.name=name;
		this.address=address;
		this.contractor=contractor;
		this.phone=phone;
		this.email=email;
		this.website=website;
		this.fax=fax;
		this.introduce=introduce;
		this.jsonArr=jsonArr;
		this.thirdpartId=thirdpartId;
		this.thirdpartUrl=thirdpartUrl;
		this.datetimeCreate=datetimeCreate;
		this.isDeleted=isDeleted;
	}
	public void setId(Integer id){this.id=id;}
	public Integer getId(){return id;}
	public void setName(String name){this.name=name;}
	public String getName(){return name;}
	public void setAddress(String address){this.address=address;}
	public String getAddress(){return address;}
	public void setContractor(String contractor){this.contractor=contractor;}
	public String getContractor(){return contractor;}
	public void setPhone(String phone){this.phone=phone;}
	public String getPhone(){return phone;}
	public void setEmail(String email){this.email=email;}
	public String getEmail(){return email;}
	public void setWebsite(String website){this.website=website;}
	public String getWebsite(){return website;}
	public void setFax(String fax){this.fax=fax;}
	public String getFax(){return fax;}
	public void setIntroduce(String introduce){this.introduce=introduce;}
	public String getIntroduce(){return introduce;}
	public void setJsonArr(String jsonArr){this.jsonArr=jsonArr;}
	public String getJsonArr(){return jsonArr;}
	public void setThirdpartId(String thirdpartId){this.thirdpartId=thirdpartId;}
	public String getThirdpartId(){return thirdpartId;}
	public void setThirdpartUrl(String thirdpartUrl){this.thirdpartUrl=thirdpartUrl;}
	public String getThirdpartUrl(){return thirdpartUrl;}
	public void setDatetimeCreate(Date datetimeCreate){this.datetimeCreate=datetimeCreate;}
	public Date getDatetimeCreate(){return datetimeCreate;}
	public void setIsDeleted(Integer isDeleted){this.isDeleted=isDeleted;}
	public Integer getIsDeleted(){return isDeleted;}
}