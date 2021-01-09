package dao;

import java.util.List;

import domain.User;
/**
 * �û����ݿ����ӽӿ�
 * @author Powers
 *
 */
public interface UserDao {
	/**
	 * ͨ���û�������������û�
	 * @param userUsername �û���
	 * @param userPassword ����
	 * @return user ��¼����û�����
	 */
	public User findByUsernamePassword(String userUsername,String userPassword);
	/**
	 * ������û�
	 * @param RegistUser Ҫ��ӵ��û�����
	 * @return int ��ӽ��
	 */
	public int addUser(User RegistUser);
	/**
	 * ͨ���û��������û�
	 * @param userUsername �û���
	 * @return user ���ҵ����û�����
	 */
	public User findByUsername(String userUsername);
	/**
	 * ���������û�
	 * @return list �����û���list����
	 */
	public List findAllUser();
	/**
	 * �޸��û�
	 * @param user Ҫ�޸ĳɵ��û�����
	 * @return int �޸Ľ��
	 */
	public int updateUser(User user);
	/**
	 * ͨ���û���������͹���Ա�����û�
	 * @param userUsername �û��� 
	 * @param userPassword ����
	 * @return user ���ҵ����û�
	 */
	public User findByUsernamePasswordIsmanager(String userUsername, String userPassword);
	/**
	 * ɾ���û�
	 * @param userId �û�id
	 * @return int ɾ�����
	 */
	public int deleteUser(int userId);
	/**
	 * ͨ���û��������û�
	 * @param userUsername �û���
	 * @return list ���ҵ����û���list����
	 */
	public List findListByUsername(String userUsername);
	/**
	 * ��ӻ�Ա
	 * @param userId �û�id
	 * @return int ��ӽ��
	 */
	public int addIsvip(Integer userId);
	/**
	 * �Ƴ���Ա
	 * @param userId �û�id
	 * @return int �Ƴ����
	 */
	public int removeIsvip(Integer userId);
	/**
	 * ��ӹ���Ա
	 * @param userId �û�id
	 * @return int ��ӽ��
	 */
	public int addIsManager(Integer userId);
	/**
	 * �Ƴ�����Ա
	 * @param userId �û�id
	 * @return int �Ƴ����
	 */
	public int removeIsmanager(Integer userId);
}
