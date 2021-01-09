package service;

import java.util.List;

import domain.User;
/**
 * �û�ҵ��ӿ�
 * @author Powers
 *
 */
public interface UserService {
	/**
	 * �û���¼ҵ��
	 * @param userUsername �û���
	 * @param userPassword ����
	 * @return user ��¼�ɹ����û�����
	 */
	public User Login(String userUsername,String userPassword);
	/**
	 * �û�ע��ҵ��
	 * @param RegistUser Ҫע����û�����
	 * @return int ע������1�ɹ���0ʧ��
	 */
	public int Regist(User RegistUser);
	/**
	 * ��ȡ�����û�
	 * @return List �����û�list����
	 */
	public List showAllUser();
	/**
	 * �޸��û�
	 * @param user
	 * @return int �޸Ľ��
	 */
	public int updateUser(User user);
	/**
	 * ����Ա��¼
	 * @param userUsername �û���
	 * @param userPassword ����
	 * @return user ��¼���û�����
	 */
	public User ManagerLogin(String userUsername, String userPassword);
	/**
	 * ɾ���û�
	 * @param userId �û�id
	 * @return int �޸Ľ��
	 */
	public int deleteUser(int userId);
	/**
	 * ͨ���û�������û�
	 * @param userUsername �û���
	 * @return list �ҵ����û������list����
	 */
	public List showListByUsername(String userUsername);
	/**
	 * ��ӻ�Ա
	 * @param userId �û�id
	 * @return int ��ӽ��
	 */
	public int addVip(Integer userId);
	/**
	 * �Ƴ���Ա
	 * @param userId �û�id
	 * @return int �Ƴ����
	 */
	public int removeVip(Integer userId);
	/**
	 * ��ӹ���Ա
	 * @param userId �û�id
	 * @return int ��ӽ��
	 */
	public int addManager(Integer userId);
	/**
	 * �Ƴ�����Ա
	 * @param userId �û�id
	 * @return int �Ƴ����
	 */
	public int removeManager(Integer userId);
}
