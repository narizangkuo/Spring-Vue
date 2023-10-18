package test.dao;

/**
  *    学院DAO类
 * 
 * @author zack
 * @date 2023-10-01
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import test.entity.School;

@Mapper
public interface SchoolDAO {
	/**
	 * 获取所有学院
	 * 
	 * @return
	 */
	public List<School> getSchoolList();

	/**
	 * 添加一个学院
	 * 
	 * @param school
	 */
	public Long addSchool(School school);

	/**
	 * 删除学院
	 * 
	 * @param id
	 */
	public Long deleteSchoolById(Long id);

	/**
	 * 更新学院
	 * 
	 * @param school
	 * @return
	 */
	public Long updateSchool(School school);

	/**
	 * 根据id，返回学院
	 * 
	 * @param id
	 * @return
	 */
	public School getSchoolById(Long id);

	/**
	 * 根据学院名，模糊查询
	 * 
	 * @return
	 */
	public List<School> findSchoolsByName(String name);
}
