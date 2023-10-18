package test.dao;

/**
  *    学生DAO类
 * 
 * @author zack
 * @date 2023-10-01
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import test.entity.Student;

@Mapper
public interface StudentDAO {
	/**
	 * 获取所有学生
	 * 
	 * @return
	 */
	public List<Student> getStudentList();

	/**
	 * 根据学号，返回学生
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentById(Long id);

	/**
	 * 根据学生名，模糊查询
	 * 
	 * @return
	 */
	public List<Student> findStudentsByName(String name);

	/**
	 * 根据专业，精准查询
	 * 
	 * @return
	 */
	public List<Student> findStudentsByMajor(String major);
	/**
	 * 根据学院，精准查询
	 * 
	 * @return
	 */
	public List<Student> findStudentsBySchool(String school);
	/**
	 * 根据类型，精准查询
	 * 
	 * @return
	 */
	public List<Student> findStudentsByType(int type);
	
	/**
	 * 根据学生名，精准查询
	 * 
	 * @return
	 */
	public List<Student> findStudentByName(String name);
	
	
	/**
	 * 添加一个学生
	 * 
	 * @param student
	 */
	public Long addStudent(Student student);

	/**
	 * 删除学生
	 * 
	 * @param id
	 */
	public Long delStudentById(Long id);

	/**
	 * 更新学生
	 * 
	 * @param student
	 * @return
	 */
	public Long updateStudent(Student student);
}
