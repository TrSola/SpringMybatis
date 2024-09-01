package com.willy.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emp {
	private Integer id;
	private String username;
	private String password;
	private Short gender;
	private String image;
	private Short job;
	private LocalDate entrydate;
	private Integer deptId;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(Integer id, String username, String password, Short gender, String image, Short job, LocalDate entrydate,
			Integer deptId, LocalDateTime createTime, LocalDateTime updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.image = image;
		this.job = job;
		this.entrydate = entrydate;
		this.deptId = deptId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Short getGender() {
		return gender;
	}
	public void setGender(Short gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Short getJob() {
		return job;
	}
	public void setJob(Short job) {
		this.job = job;
	}
	public LocalDate getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(LocalDate entrydate) {
		this.entrydate = entrydate;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender + ", image="
				+ image + ", job=" + job + ", entrydate=" + entrydate + ", deptId=" + deptId + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}

