package com.example.demo.service;
/**
 *    学院Service类
* 
* @author zack
* @date 2023-10-01
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import test.dao.SchoolDAO;
import test.entity.School;

@Service
@CrossOrigin
public class SchoolService {
	
	@Autowired
	private SchoolDAO schoolDao;
	
	/**
	 * 获取所有学院
	 * 
	 * @return
	 */
	public List<School> getSchoolList() {
		return schoolDao.getSchoolList();
	}
	/**
	 * 添加一个学院
	 * 
	 * @param school
	 */
	public Long addSchool(School school) {
		return schoolDao.addSchool(school);
	}
	/**
	 * 删除学院
	 * 
	 * @param id
	 */
	public Long deleteSchoolById(Long id) {
		return schoolDao.deleteSchoolById(id);
	}
	/**
	 * 更新学院
	 * 
	 * @param school
	 * @return
	 */
	public Long updateSchool(School school) {
		return schoolDao.updateSchool(school);
	}
	/**
	 * 根据id，返回学院
	 * 
	 * @param id
	 * @return
	 */
	public School getSchoolById(Long id) {
		return schoolDao.getSchoolById(id);
	}
	/**
	 * 根据学院名，模糊查询
	 * 
	 * @return
	 */
	public List<School> findSchoolsByName(String name) {
		return schoolDao.findSchoolsByName(name);
	}
	
}
