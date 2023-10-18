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
import com.example.demo.service.MajorService;
import common.Result;
import test.entity.Major;

/**
 * 首页测试
 * 
 * @author liyong
 *
 */
@RestController
@RequestMapping("/major/")
@CrossOrigin
public class MajorController {

	@Autowired
	private MajorService majorService;

	/**
	 * 处理添加专业请求
	 * 
	 * @author zack
	 *
	 */
	@PostMapping("/add_major")
	public Result<Map<String, Object>> addMajor(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "createTime", required = false) String createTimeString,
			@RequestParam(value = "description", required = false) String description) {
		// 前台返回的字符串，截取到yyyy-MM-dd
		// 时间处理一直不对，阶段重新处理
		createTimeString = createTimeString.substring(0, 10);
		// String 转换为时间
		java.text.SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = ft.parse(createTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long col = majorService.addMajor(new Major(name, date, description));
		// 前后端分离，插入信息
		if (col <= 0) {
			return Result.fail(20003, "专业记录添加失败");
		}
		Map<String, Object> data = new HashMap<>();
		data.put("total", col);
		data.put("rows", col);
		return Result.success(data, "新增专业成功");
	}

	/**
	 * 处理查询专业请求，封装了获取全部专业和按名称查找专业方法
	 * 
	 * @author zack
	 *
	 */
	@GetMapping("/list")
	public Result<Map<String, Object>> getSchoolList(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "createTime", required = false) Date createTime,
			@RequestParam(value = "pageNo", required = false) Long pageNo, @RequestParam(value = "pageSize", required = false) Long pageSize) {
		List<Major> list;
		if (name == null) {
			list = majorService.getMajorList();
		} else {
			list = majorService.findMajorsByName(name);
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
	@PutMapping("/update_major")
	public Result<?> update(@RequestBody Major major) {
		Long col = majorService.updateMajor(major);
		if (col > 0) {
			return Result.success("更新专业信息成功");
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
	public Result<Major> getSchoolById(@PathVariable("id") Long id) {
		Major major = majorService.getMajorById(id);
		return Result.success(major);
	}

	/**
	 * 处理按id删除专业专业请求
	 * 
	 * @author zack
	 *
	 */
	@DeleteMapping("/{id}")
	public Result<Major> deleteSchoolById(@PathVariable("id") Long id) {
		majorService.deleteMajorById(id);
		return Result.success("删除用户成功");
	}
}
