/**
 * 
 */
package test.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * 部门实体Bean
 * 
 * @author wben
 *
 */
public class Department implements Serializable {

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
	 * 部门名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

	
	
	/**
	 * 管理者
	 */
	private LoginUser manager;

	
	/**
	 * 部门成员
	 */
	private List<LoginUser> userList = new ArrayList<LoginUser>();

	
	
	/**
	 * 
	 */
	public Department() {
		super();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the manager
	 */
	public LoginUser getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(LoginUser manager) {
		this.manager = manager;
	}
	
	

	/**
	 * @return the userList
	 */
	public List<LoginUser> getUserList() {
		return userList;
	}


	/**
	 * @return the createTime
	 */
	//public Date getCreateTime() {
	//	return createTime;
	//}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id=" + id + ", createTime=" + createTime + ", name=" + name + ", description="
				+ description + ", manager=" + manager + "]";
	}
	
	

}
