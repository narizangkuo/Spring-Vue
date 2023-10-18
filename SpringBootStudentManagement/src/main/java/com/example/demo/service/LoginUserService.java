package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson2.JSON;
import test.dao.LoginUserDAO;
import test.entity.LoginUser;

/**
 * @author liyong
 *
 */
@Service
public class LoginUserService {

	@Autowired
	private LoginUserDAO userDao;

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 取得全部用户
	 * 
	 * @return
	 */
	public List<LoginUser> getUserList() {
		return userDao.getUserList();
	}

	/**
	 * 添加一个用户
	 * 
	 * @param user
	 * @return
	 */
	public Long addUser(LoginUser user) {
		return userDao.addUser(user);
	}

	/**
	 * 根据ID取得一个用户
	 * 
	 * @param id
	 * @return
	 */
	public LoginUser getUser(Long id) {
		return userDao.getUser(id);
	}

	/**
	 * 通过名称查找用户，模糊匹配
	 * 
	 * @param userName
	 * @return
	 */
	public List<LoginUser> findUsersByName(String userName) {
		return userDao.findUsersByName(userName);
	}

	/**
	 * 通过名称查找用户，精准匹配
	 * 
	 * @param userName
	 * @return
	 */
	public LoginUser findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}

	public Map<String, Object> login(LoginUser loginUser) {
		// 根据用户名和密码查询
//		System.out.println("zack 获取到的用户名为:" + loginUser.getLoginName());
		LoginUser user = findUserByName(loginUser.getLoginName());
//		System.out.println(user);

		if (user != null) {
			if (loginUser.getPassword().equals(user.getPassword())) {
				String key = "user:" + loginUser.hashCode();

				// 存入redis
				loginUser.setPassword(null);
				redisTemplate.opsForValue().set(key, loginUser, 300, TimeUnit.MINUTES);

				Map<String, Object> data = new HashMap<String, Object>();
				data.put("token", key);
				return data;
			}
		}
		return null;
	}

	public Map<String, Object> getUserInfo(String token) {
		// 根据token获取用户信息,redis
		Object obj = redisTemplate.opsForValue().get(token);
//		System.out.println("zack: token=" + token);
//		System.out.println("zack obj =" + obj);
		if (obj != null) {
			LoginUser user = JSON.parseObject(JSON.toJSONString(obj), LoginUser.class);
			Map<String, Object> data = new HashMap<>();
			data.put("name", user.getLoginName());
			// 默认头像
			data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
			// data.put("roles", "admin");
			return data;
		}

		return null;
	}

	/**
	 * 根据token，用户退出
	 * 
	 * @author zack
	 *
	 */
	public void logout(String token) {
		// redis 删除相关信息
		redisTemplate.delete(token);
	}
}
