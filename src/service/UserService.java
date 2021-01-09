package service;

import java.util.List;

import domain.User;
/**
 * 用户业务接口
 * @author Powers
 *
 */
public interface UserService {
	/**
	 * 用户登录业务
	 * @param userUsername 用户名
	 * @param userPassword 密码
	 * @return user 登录成功的用户对象
	 */
	public User Login(String userUsername,String userPassword);
	/**
	 * 用户注册业务
	 * @param RegistUser 要注册的用户对象
	 * @return int 注册结果，1成功，0失败
	 */
	public int Regist(User RegistUser);
	/**
	 * 获取所有用户
	 * @return List 所有用户list集合
	 */
	public List showAllUser();
	/**
	 * 修改用户
	 * @param user
	 * @return int 修改结果
	 */
	public int updateUser(User user);
	/**
	 * 管理员登录
	 * @param userUsername 用户名
	 * @param userPassword 密码
	 * @return user 登录的用户对象
	 */
	public User ManagerLogin(String userUsername, String userPassword);
	/**
	 * 删除用户
	 * @param userId 用户id
	 * @return int 修改结果
	 */
	public int deleteUser(int userId);
	/**
	 * 通过用户名获得用户
	 * @param userUsername 用户名
	 * @return list 找到的用户对象的list集合
	 */
	public List showListByUsername(String userUsername);
	/**
	 * 添加会员
	 * @param userId 用户id
	 * @return int 添加结果
	 */
	public int addVip(Integer userId);
	/**
	 * 移除会员
	 * @param userId 用户id
	 * @return int 移除结果
	 */
	public int removeVip(Integer userId);
	/**
	 * 添加管理员
	 * @param userId 用户id
	 * @return int 添加结果
	 */
	public int addManager(Integer userId);
	/**
	 * 移除管理员
	 * @param userId 用户id
	 * @return int 移除结果
	 */
	public int removeManager(Integer userId);
}
