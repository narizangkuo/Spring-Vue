package test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import test.entity.Department;


 

/**
 * @author liyong
 *
 */

@Mapper
public interface DepartmentDAO {
	
	/**
	 * 取得指定部门,包含全部成员
	 * @return
	 */
	public Department getUsersByDepartmentID(Long id);
	
	/**
	 * 添加一个部门
	 * @param department
	 * @return 记录条数
	 */
	public  Long addDepartment(Department department) ;
	
	/**
	 * 根据ID取得一个部门
	 * @param id
	 * @return
	 */
	public  Department getDepartment(Long id) ;
	
	/**
	 * 删除一个指定ID的部门
	 * @param id
	 * @return
	 */
	public  Long deleteDepartment(Long id) ;
	
	/**
	 * 更新一个部门
	 * @param department
	 * @return
	 */
	public  Long updateDepartment(Department department) ;
	
	
}
