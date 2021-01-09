package user_test;

import org.junit.jupiter.api.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
/**
 * �û�dao������
 * @author Powers
 *
 */
public class userDaoTest {
	UserDao dao = new UserDaoImpl();
	/**
	 * ͨ���û�������������û�
	 */
	@Test
	public void findByUsernamePasswordTest() {
		String userUsername = "yannis";
		String userPassword = "123123123";
		User user = dao.findByUsernamePassword(userUsername, userPassword);
		System.out.println(user);
	}
	/**
	 * ����û�
	 */
	@Test
	public void addUserTest() {
		User RegistUser = new User("testAddUser2","testAddUser2","test@qq.com",0,0);
		int result = dao.addUser(RegistUser);
		System.out.println(result);
	}
	/**
	 * �޸��û�
	 */
	@Test
	public void updateUserTest() {
		User user = new User("testUpdateUser","testUpdateUser","test@qq.com",0,0);
		int result = dao.updateUser(user);
		System.out.println(result);
	}
	/**
	 * ɾ���û�
	 */
	@Test
	public void deleteUserTest() {
		int result = dao.deleteUser(4);
		System.out.println(result);
	}
}
