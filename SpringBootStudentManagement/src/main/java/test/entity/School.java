package test.entity;

/**
 *    学院实体类
 * 
 * @author zack
 * @date 2023-10-01
 */

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class School implements Serializable {
	private static final long serialVersionUID = -644064058327051700L;
	// 学院id
	private Long id;
	// 学院名
	private String name;
	// 创办时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	// 学院介绍
	private String description;
	// 删除标记
	private int delete;
	// 记录更新时间
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

	/**
	 * @explain 重写toString()方法
	 */
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", createTime=" + createTime + ", description=" + description
				+ ", delete=" + delete + ", updateTime=" + updateTime + "]";
	}

	/**
	 * @explain 构造函数
	 * @author zack
	 *
	 */
	public School(Long id, String name, Date createTime, String description) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.description = description;
	}

	/**
	 * @explain 构造函数
	 * @author zack
	 *
	 */
	public School(Long id, String name, Date createTime, String description, int delete) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.description = description;
		this.delete = delete;
	}

	/**
	 * @explain 构造函数
	 * @author zack
	 *
	 */
	public School(String name, Date createTime) {
		super();
		this.name = name;
		this.createTime = createTime;
	}

	/**
	 * @explain 构造函数
	 * @author zack
	 *
	 */
	public School(String name, Date createTime, String description) {
		super();
		this.name = name;
		this.createTime = createTime;
		this.description = description;
	}

	/**
	 * @explain 构造函数
	 * @author zack
	 *
	 */
	public School() {
		super();
	}

}
