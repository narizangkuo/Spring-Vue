package com.example.demo.service;
/**
 *    专业Service类
* 
* @author zack
* @date 2023-10-01
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import test.dao.MajorDAO;
import test.entity.Major;

@Service
@CrossOrigin
public class MajorService {
	
	@Autowired
	private MajorDAO MajorDao;
	
	/**
	 * 获取所有专业
	 * 
	 * @return
	 */
	public List<Major> getMajorList() {
		return MajorDao.getMajorList();
	}
	/**
	 * 添加一个专业
	 * 
	 * @param Major
	 */
	public Long addMajor(Major Major) {
		return MajorDao.addMajor(Major);
	}
	/**
	 * 删除专业
	 * 
	 * @param id
	 */
	public Long deleteMajorById(Long id) {
		return MajorDao.deleteMajorById(id);
	}
	/**
	 * 更新专业
	 * 
	 * @param Major
	 * @return
	 */
	public Long updateMajor(Major Major) {
		return MajorDao.updateMajor(Major);
	}
	/**
	 * 根据id，返回专业
	 * 
	 * @param id
	 * @return
	 */
	public Major getMajorById(Long id) {
		return MajorDao.getMajorById(id);
	}
	/**
	 * 根据专业名，模糊查询
	 * 
	 * @return
	 */
	public List<Major> findMajorsByName(String name) {
		return MajorDao.findMajorsByName(name);
	}
	
}
