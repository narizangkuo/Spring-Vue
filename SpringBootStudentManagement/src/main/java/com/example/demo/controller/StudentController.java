package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.StudentService;
import common.Result;
import test.entity.Major;
import test.entity.School;
import test.entity.Student;

/**
 * 首页测试
 * 
 * @author liyong
 *
 */
@RestController
@RequestMapping("/student/")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * 处理添加专业请求
	 * 
	 * @author zack
	 *
	 */
	@PostMapping("/add_student")
	public Result<Map<String, Object>> addStudent(@RequestBody Student student) {
		System.out.println("zack");
		System.out.println(student);
		Long col = studentService.addStudent(student);
		// 前后端分离，插入信息
		if (col <= 0) {
			return Result.fail(20003, "学生添加失败");
		}
		Map<String, Object> data = new HashMap<>();
		data.put("total", col);
		data.put("rows", col);
		return Result.success(data, "新增学生成功");
	}

	/**
	 * 处理查询学生请求，封装了获取全部专业和按名称查找专业方法
	 * 
	 * @author zack
	 *
	 */
	@GetMapping("/list")
	public Result<Map<String, Object>> getSchoolList(
			@RequestParam(value = "searchType", required = false) Integer searchType,
			@RequestParam(value = "searchContent", required = false) String searchContent) {
		System.out.println("zangkuo 查询类型 + " + searchType + " 查询内容 " + searchContent);
		List<Student> list = null;
		if (searchType == 0 || searchContent.equals("")) {
			list = studentService.getStudentList();
		} else if (searchType == 1) {
			list = studentService.findStudentsByName(searchContent);
		} else if (searchType == 2) {
			Long id = Long.parseLong(searchContent);
			Student student = studentService.getStudentById(id);
			list = new ArrayList();
			if (student != null) {
				list.add(student);
			}
		} else if (searchType == 3) {
			list = studentService.findStudentsByMajor(searchContent);
		} else if (searchType == 4) {
			list = studentService.findStudentsBySchool(searchContent);
		} else if (searchType == 5) {
			int type = 0;
			// 把博士、本科、研究 处理为对应类型
			if (searchContent.contains("博") || searchContent.contains("士")) {
				type = 3;
			} else if (searchContent.contains("研") || searchContent.contains("究")) {
				type = 2;
			} else if (searchContent.contains("本") || searchContent.contains("科")) {
				type = 1;
			}
			list = studentService.findStudentsByType(type);
		} else {
			// 不处理
		}
		Map<String, Object> data = new HashMap<>();
		data.put("total", list.size());
		data.put("rows", list);
		return Result.success(data);
	}

	/**
	 * 处理更新专业请求
	 * 
	 * @author zack
	 *
	 */
	@PutMapping("/update_student")
	public Result<?> update(@RequestBody Student student) {
		System.out.println("zangkuo update_student " + student);
		Long col = studentService.updateStudent(student);
		if (col > 0) {
			return Result.success("更新学生信息成功");
		}
		return null;
	}

	/**
	 * 处理按id查询专业请求，主要配合更新、删除专业
	 * 
	 * @author zack
	 *
	 */
	@GetMapping("/{id}")
	public Result<Student> getSchoolById(@PathVariable("id") Long id) {
		Student student = studentService.getStudentById(id);
		return Result.success(student);
	}

	/**
	 * 处理按id删除专业专业请求
	 * 
	 * @author zack
	 *
	 */
	@DeleteMapping("/{id}")
	public Result<Student> deleteSchoolById(@PathVariable("id") Long id) {
		studentService.delStudentById(id);
		return Result.success("删除学生信息成功");
	}
}
