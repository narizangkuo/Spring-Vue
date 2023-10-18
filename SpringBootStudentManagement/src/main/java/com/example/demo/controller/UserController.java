package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginUserService;

import common.Result;
import test.entity.LoginUser;

/**
 * 首页测试
 * 
 * @author liyong
 *
 */
@RestController
@RequestMapping("/user/")
@CrossOrigin
public class UserController {

	@Autowired
	private LoginUserService loginUserService;

	/**
	 * 获取全部用户
	 * 
	 * @author zack
	 *
	 */
	@RequestMapping("/all")
	public List<LoginUser> list() {
		return loginUserService.getUserList();
	}

	/**
	 * 处理查找请求，通过名称查找用户，模糊匹配
	 * 
	 * @author zack
	 *
	 */
	@RequestMapping("/find")
	public List<LoginUser> getUserByName(String userName) {
		return loginUserService.findUsersByName(userName);
	}

	/**
	 * 处理登录请求
	 * 
	 * @author zack
	 *
	 */
	@PostMapping("/login")
	public Result<Map<String, Object>> login(@RequestBody LoginUser user) {
		Map<String, Object> data = loginUserService.login(user);
		if (data != null) {
			return Result.success(data);
		}
		return Result.fail(20002, "用户名或密码错误");
	}

	/**
	 * 根据token判断用户登录状态
	 * 
	 * @author zack
	 *
	 */
	@GetMapping("/info")
	public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token) {
		// 根据token获取用户信息,redis
		Map<String, Object> data = loginUserService.getUserInfo(token);
		if (data != null) {
			return Result.success(data);
		}
		return Result.fail(20003, "登录信息无效，请重新登录");
	}

	/**
	 * 处理退出请求
	 * 
	 * @author zack
	 *
	 */
	@PostMapping("/logout")
	public Result<?> logout(@RequestHeader("X-Token") String token) {
		loginUserService.logout(token);
		return Result.success();
	}

}
