/**
 * 
 */
package test.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户实体Bean
 * 
 * @author wben
 *
 */

public class LoginUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 记录创建时间
	 */
	private Date createTime = new Date();

	/**
	 * 登录名
	 */
	// 前台返回参数名称
	@JsonProperty("username")
	private String loginName;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * 用户姓名
	 */
	private String name;

	/**
	 * 性别：男/女
	 */
	private String gender;

	/**
	 * 电子邮件
	 */
	private String email;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 归属部门
	 */
	private Department department;

	/**
	 * 无参构造方法
	 * 
	 * @author zack
	 *
	 */
	public LoginUser() {
		super();
	}

	/**
	 * 构造方法
	 * 
	 * @author zack
	 *
	 */
	public LoginUser(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
		this.createTime = new Date();
	}

	/**
	 * 构造方法
	 * 
	 * @author zack
	 *
	 */
	public LoginUser(Long id, Date createTime, String loginName, String password, String name, String gender,
			String email, String mobile, Department department) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.loginName = loginName;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.department = department;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	// 修改了一下，利用这个生成token
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		System.out.println( "zack " + this.id + " id.hashCode   "  + this.loginName + " loginName hash =" + loginName.hashCode());
		// result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginUser other = (LoginUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * set 方法
	 * 
	 * @author zack
	 *
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", createTime=" + createTime + ", loginName=" + loginName + ", password="
				+ password + ", name=" + name + ", gender=" + gender + ", email=" + email + ", mobile=" + mobile
				+ ", department=" + department + "]";
	}

}
