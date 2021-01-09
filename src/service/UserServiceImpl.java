package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
/**
 * �û���¼ҵ��ӿ�ʵ����
 * @author Powers
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao dao = new UserDaoImpl();
	/**
	 * �û���¼����
	 */
	@Override
	public User Login(String userUsername,String userPassword) {
		return dao.findByUsernamePassword(userUsername,userPassword);
	}
	/**
	 * �û�ע�᷽��
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
	 * ��ȡ�����û�
	 */
	@Override
	public List showAllUser() {
		return dao.findAllUser();
	}
	/**
	 * �޸��û�
	 */
	@Override
	public int updateUser(User user) {
		return  dao.updateUser(user);
	}
	/**
	 * ����Ա��¼
	 */
	@Override
	public User ManagerLogin(String userUsername, String userPassword) {
		
		return dao.findByUsernamePasswordIsmanager(userUsername, userPassword);
	}
	/**
	 * ɾ���û�
	 */
	@Override
	public int deleteUser(int userId) {
		return dao.deleteUser(userId);
	}
	/**
	 * ͨ���û�������û�
	 */
	@Override
	public List showListByUsername(String userUsername) {
		return dao.findListByUsername(userUsername);
	}
	/**
	 * ��ӻ�Ա
	 */
	@Override
	public int addVip(Integer userId) {
		return dao.addIsvip(userId);
	}
	/**
	 * �Ƴ���Ա
	 */
	@Override
	public int removeVip(Integer userId) {
		return dao.removeIsvip(userId);
	}
	/**
	 * ��ӹ���Ա
	 */
	@Override
	public int addManager(Integer userId) {
		return dao.addIsManager(userId);
	}
	/**
	 * �Ƴ�����Ա
	 */
	@Override
	public int removeManager(Integer userId) {
		return dao.removeIsmanager(userId);
	}
	
}
