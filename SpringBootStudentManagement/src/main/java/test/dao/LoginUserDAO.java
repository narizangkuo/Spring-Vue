package test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import test.entity.LoginUser;

/**
 * @author liyong
 *
 */

@Mapper
public interface LoginUserDAO {

	/**
	 * 取得全部用户
	 * 
	 * @return
	 */
	public List<LoginUser> getUserList();

	/**
	 * 添加一个用户
	 * 
	 * @param user
	 * @return
	 */
	public Long addUser(LoginUser user);

	/**
	 * 根据ID取得一个用户
	 * 
	 * @param id
	 * @return
	 */
	public LoginUser getUser(Long id);

	/**
	 * 通过名称查找用户，模糊匹配
	 * 
	 * @param userName
	 * @return
	 */
	public List<LoginUser> findUsersByName(String userName);

	/**
	 * 通过名称查找用户，精准匹配
	 * 
	 * @param userName
	 * @return
	 */
	public LoginUser findUserByName(String userName);

}
