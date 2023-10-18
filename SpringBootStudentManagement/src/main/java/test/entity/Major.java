package test.entity;

/**
 *    专业实体类
 * 
 * @author zack
 * @date 2023-10-01
 */
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Major implements Serializable {
	private static final long serialVersionUID = -7688222812659260509L;
	private Long id;
	private String name;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	private String description;
	private int delete;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;
	
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
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	

	
	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + ", createTime=" + createTime + ", description=" + description
				+ ", delete=" + delete + ", updateTime=" + updateTime + "]";
	}

	/**
	 * 构造方法
	 * 
	 * @author zack
	 *
	 */
	public Major(Long id, String name, Date createTime, String description, int delete, Date updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.description = description;
		this.delete = delete;
		this.updateTime = updateTime;
	}

	/**
	 * 构造方法
	 * 
	 * @author zack
	 *
	 */
	public Major() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * 
	 * @author zack
	 *
	 */
	public Major(String name, Date createTime, String description) {
		super();
		this.name = name;
		this.createTime = createTime;
		this.description = description;
	}

}
