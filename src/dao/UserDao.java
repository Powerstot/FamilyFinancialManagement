package dao;

import java.util.List;

import domain.User;
/**
 * 用户数据库连接接口
 * @author Powers
 *
 */
public interface UserDao {
	/**
	 * 通过用户名和密码查找用户
	 * @param userUsername 用户名
	 * @param userPassword 密码
	 * @return user 登录后的用户对象
	 */
	public User findByUsernamePassword(String userUsername,String userPassword);
	/**
	 * 添加新用户
	 * @param RegistUser 要添加的用户对象
	 * @return int 添加结果
	 */
	public int addUser(User RegistUser);
	/**
	 * 通过用户名查找用户
	 * @param userUsername 用户名
	 * @return user 查找到的用户对象
	 */
	public User findByUsername(String userUsername);
	/**
	 * 查找所有用户
	 * @return list 所有用户的list集合
	 */
	public List findAllUser();
	/**
	 * 修改用户
	 * @param user 要修改成的用户对象
	 * @return int 修改结果
	 */
	public int updateUser(User user);
	/**
	 * 通过用户名，密码和管理员查找用户
	 * @param userUsername 用户名 
	 * @param userPassword 密码
	 * @return user 查找到的用户
	 */
	public User findByUsernamePasswordIsmanager(String userUsername, String userPassword);
	/**
	 * 删除用户
	 * @param userId 用户id
	 * @return int 删除结果
	 */
	public int deleteUser(int userId);
	/**
	 * 通过用户名查找用户
	 * @param userUsername 用户名
	 * @return list 查找到的用户的list集合
	 */
	public List findListByUsername(String userUsername);
	/**
	 * 添加会员
	 * @param userId 用户id
	 * @return int 添加结果
	 */
	public int addIsvip(Integer userId);
	/**
	 * 移除会员
	 * @param userId 用户id
	 * @return int 移除结果
	 */
	public int removeIsvip(Integer userId);
	/**
	 * 添加管理员
	 * @param userId 用户id
	 * @return int 添加结果
	 */
	public int addIsManager(Integer userId);
	/**
	 * 移除管理员
	 * @param userId 用户id
	 * @return int 移除结果
	 */
	public int removeIsmanager(Integer userId);
}
