package user_test;

import org.junit.jupiter.api.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
/**
 * 用户dao测试类
 * @author Powers
 *
 */
public class userDaoTest {
	UserDao dao = new UserDaoImpl();
	/**
	 * 通过用户名和密码查找用户
	 */
	@Test
	public void findByUsernamePasswordTest() {
		String userUsername = "yannis";
		String userPassword = "123123123";
		User user = dao.findByUsernamePassword(userUsername, userPassword);
		System.out.println(user);
	}
	/**
	 * 添加用户
	 */
	@Test
	public void addUserTest() {
		User RegistUser = new User("testAddUser2","testAddUser2","test@qq.com",0,0);
		int result = dao.addUser(RegistUser);
		System.out.println(result);
	}
	/**
	 * 修改用户
	 */
	@Test
	public void updateUserTest() {
		User user = new User("testUpdateUser","testUpdateUser","test@qq.com",0,0);
		int result = dao.updateUser(user);
		System.out.println(result);
	}
	/**
	 * 删除用户
	 */
	@Test
	public void deleteUserTest() {
		int result = dao.deleteUser(4);
		System.out.println(result);
	}
}
