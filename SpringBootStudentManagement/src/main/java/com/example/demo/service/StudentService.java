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
import test.dao.StudentDAO;
import test.entity.Student;

@Service
@CrossOrigin
public class StudentService {

	@Autowired
	private StudentDAO studentDao;

	/**
	 * 获取所有学生
	 * 
	 * @return
	 */
	public List<Student> getStudentList() {
		return studentDao.getStudentList();
	}

	/**
	 * 根据学号，返回学生
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentById(Long id) {
		return studentDao.getStudentById(id);
	}

	/**
	 * 根据学生名，模糊查询
	 * 
	 * @return
	 */
	public List<Student> findStudentsByName(String name) {
		return studentDao.findStudentsByName(name);
	}

	/**
	 * 根据专业，精准查询
	 */
	public List<Student> findStudentsByMajor(String major) {
		return studentDao.findStudentsByMajor(major);
	}

	/**
	 * 根据学院，精准查询
	 * 
	 * @return
	 */
	public List<Student> findStudentsBySchool(String school) {
		return studentDao.findStudentsBySchool(school);
	}

	/**
	 * 根据类型，精准查询
	 * 
	 * @return
	 */
	public List<Student> findStudentsByType(int type) {
		return studentDao.findStudentsByType(type);
	}

	/**
	 * 根据学生名，精准查询
	 * 
	 * @return
	 */
	public List<Student> findStudentByName(String name) {
		return studentDao.findStudentByName(name);
	}

	/**
	 * 添加一个学生
	 * 
	 * @param student
	 */
	public Long addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	/**
	 * 删除学生
	 * 
	 * @param id
	 */
	public Long delStudentById(Long id) {
		return studentDao.delStudentById(id);
	}

	/**
	 * 更新学生
	 * 
	 * @param student
	 * @return
	 */
	public Long updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

}
