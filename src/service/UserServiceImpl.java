package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
/**
 * 用户登录业务接口实现类
 * @author Powers
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao dao = new UserDaoImpl();
	/**
	 * 用户登录方法
	 */
	@Override
	public User Login(String userUsername,String userPassword) {
		return dao.findByUsernamePassword(userUsername,userPassword);
	}
	/**
	 * 用户注册方法
	 */
	@Override
	public int Regist(User RegistUser) {
		User u = dao.findByUsername(RegistUser.getUserUsername());
		if(u != null) {
			return 0;
		}else {
			dao.addUser(RegistUser);
			return 1;
		}
	}
	/**
	 * 获取所有用户
	 */
	@Override
	public List showAllUser() {
		return dao.findAllUser();
	}
	/**
	 * 修改用户
	 */
	@Override
	public int updateUser(User user) {
		return  dao.updateUser(user);
	}
	/**
	 * 管理员登录
	 */
	@Override
	public User ManagerLogin(String userUsername, String userPassword) {
		
		return dao.findByUsernamePasswordIsmanager(userUsername, userPassword);
	}
	/**
	 * 删除用户
	 */
	@Override
	public int deleteUser(int userId) {
		return dao.deleteUser(userId);
	}
	/**
	 * 通过用户名获得用户
	 */
	@Override
	public List showListByUsername(String userUsername) {
		return dao.findListByUsername(userUsername);
	}
	/**
	 * 添加会员
	 */
	@Override
	public int addVip(Integer userId) {
		return dao.addIsvip(userId);
	}
	/**
	 * 移除会员
	 */
	@Override
	public int removeVip(Integer userId) {
		return dao.removeIsvip(userId);
	}
	/**
	 * 添加管理员
	 */
	@Override
	public int addManager(Integer userId) {
		return dao.addIsManager(userId);
	}
	/**
	 * 移除管理员
	 */
	@Override
	public int removeManager(Integer userId) {
		return dao.removeIsmanager(userId);
	}
	
}
