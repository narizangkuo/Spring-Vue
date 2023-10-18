package test.entity;

/**
 *    学生实体类
 * 
 * @author zack
 * @date 2023-10-01
 */
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Student implements Serializable {
	private static final long serialVersionUID = -7688222812659260509L;
	//学号
	private Long id;
	//姓名
	private String name;
	//身份证
	private Long idCard;
	//性别
	private int sex;
	//班级
	private int sClass;
	//类型
	private int sType;
	//入学时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rollTime;
	//联系方式
	private String mobile;
	//删除标记
	private int delete;
	//更新时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;

	/**
	 * 所属专业
	 */
	private Major major;
	/**
	 * 所属学院
	 */
	private School school;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the idCard
	 */
	public Long getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the sClass
	 */
	public int getsClass() {
		return sClass;
	}

	/**
	 * @param sClass the sClass to set
	 */
	public void setsClass(int sClass) {
		this.sClass = sClass;
	}

	/**
	 * @return the sType
	 */
	public int getsType() {
		return sType;
	}

	/**
	 * @param sType the sType to set
	 */
	public void setsType(int sType) {
		this.sType = sType;
	}

	/**
	 * @return the rollTime
	 */
	public Date getRollTime() {
		return rollTime;
	}

	/**
	 * @param rollTime the rollTime to set
	 */
	public void setRollTime(Date rollTime) {
		this.rollTime = rollTime;
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
	 * @return the delete
	 */
	public int getDelete() {
		return delete;
	}

	/**
	 * @param delete the delete to set
	 */
	public void setDelete(int delete) {
		this.delete = delete;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(Major major) {
		this.major = major;
	}

	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * 构造函数
	 * 
	 * @author zack
	 *
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造函数
	 * 
	 * @author zack
	 *
	 */

	public Student(Long id, String name, Long idCard, int sex, int sClass, int sType, Date rollTime, String mobile,
			int delete, Date updateTime, Major major, School school) {
		super();
		this.id = id;
		this.name = name;
		this.idCard = idCard;
		this.sex = sex;
		this.sClass = sClass;
		this.sType = sType;
		this.rollTime = rollTime;
		this.mobile = mobile;
		this.delete = delete;
		this.updateTime = updateTime;
		this.major = major;
		this.school = school;
	}

	/**
	 * 构造函数
	 * 
	 * @author zack
	 *
	 */
	public Student(Long id, String name, Long idCard, int sex, int sClass, int sType, Date rollTime, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.idCard = idCard;
		this.sex = sex;
		this.sClass = sClass;
		this.sType = sType;
		this.rollTime = rollTime;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", idCard=" + idCard + ", sex=" + sex + ", sClass=" + sClass
				+ ", sType=" + sType + ", rollTime=" + rollTime + ", mobile=" + mobile + ", delete=" + delete
				+ ", updateTime=" + updateTime + ", major=" + major + ", school=" + school + "]";
	}
}
