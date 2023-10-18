package test.dao;

/**
  *    专业DAO类
 * 
 * @author zack
 * @date 2023-10-01
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import test.entity.Major;

@Mapper
public interface MajorDAO {
	/**
	 * 获取所有专业
	 * 
	 * @return
	 */
	public List<Major> getMajorList();

	/**
	 * 添加一个专业
	 * 
	 * @param Major
	 */
	public Long addMajor(Major Major);

	/**
	 * 删除专业
	 * 
	 * @param id
	 */
	public Long deleteMajorById(Long id);

	/**
	 * 更新专业
	 * 
	 * @param Major
	 * @return
	 */
	public Long updateMajor(Major Major);

	/**
	 * 根据id，返回专业
	 * 
	 * @param id
	 * @return
	 */
	public Major getMajorById(Long id);

	/**
	 * 根据专业名，模糊查询
	 * 
	 * @return
	 */
	public List<Major> findMajorsByName(String name);
}
