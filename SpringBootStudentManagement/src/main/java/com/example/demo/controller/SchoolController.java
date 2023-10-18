package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.example.demo.service.SchoolService;
import common.Result;
import test.entity.School;

/**
 * 首页测试
 * 
 * @author liyong
 *
 */
@RestController
@RequestMapping("/school/")
@CrossOrigin
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	/**
	 * 处理添加学院请求
	 * 
	 * @author zack
	 *
	 */
	@PostMapping("/add_school")
	public Result<Map<String, Object>> addSchool(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "createTime", required = false) String createTimeString,
			@RequestParam(value = "description", required = false) String description) {
//		System.out.println("zack");
//		System.out.println(name);
		// 前台返回的字符串，截取到yyyy-MM-dd
		// 时间处理一直不对，阶段重新处理
		createTimeString = createTimeString.substring(0, 10);
//		System.out.println(createTimeString);
//		System.out.println(description);

		// String 转换为时间
		java.text.SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = ft.parse(createTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		System.out.println(date);
		Long col = schoolService.addSchool(new School(name, date, description));
		// 前后端分离，插入信息
		if (col <= 0) {
			return Result.fail(20003, "学院记录添加失败");
		}
		Map<String, Object> data = new HashMap<>();
		data.put("total", col);
		data.put("rows", col);
		return Result.success(data, "新增学院成功");
	}

	/**
	 * 处理查询学院请求，封装了获取全部学院和按名称查找学院方法
	 * 
	 * @author zack
	 *
	 */
	@GetMapping("/list")
	public Result<Map<String, Object>> getSchoolList(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "createTime", required = false) Date createTime,
			@RequestParam(value = "pageNo", required = false) Long pageNo, @RequestParam(value = "pageSize", required = false) Long pageSize) {
		List<School> list;
		if (name == null) {
			list = schoolService.getSchoolList();
		} else {
			list = schoolService.findSchoolsByName(name);
		}
//		System.out.println("zack  schoolList= " + list);
		Map<String, Object> data = new HashMap<>();
		data.put("total", list.size());
		data.put("rows", list);
		return Result.success(data);
	}

	/**
	 * 处理更新学院请求
	 * 
	 * @author zack
	 *
	 */
	@PutMapping("/update_school")
	public Result<?> update(@RequestBody School school) {
		Long col = schoolService.updateSchool(school);
		if (col > 0) {
			return Result.success("更新学院信息成功");
		}
		return null;
	}

	/**
	 * 处理按id查询学院请求，主要配合更新、删除学院
	 * 
	 * @author zack
	 *
	 */
	@GetMapping("/{id}")
	public Result<School> getSchoolById(@PathVariable("id") Long id) {
		School school = schoolService.getSchoolById(id);
//		System.out.println(school);
		return Result.success(school);
	}

	/**
	 * 处理按id删除学院学院请求
	 * 
	 * @author zack
	 *
	 */
	@DeleteMapping("/{id}")
	public Result<School> deleteSchoolById(@PathVariable("id") Long id) {
		schoolService.deleteSchoolById(id);
		return Result.success("删除用户成功");
	}
}
