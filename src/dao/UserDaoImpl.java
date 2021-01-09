package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.User;
import utils.JDBCUtils;
/**
 * �û����ݿ����ӽӿ�ʵ����
 * @author Powers
 *
 */
public class UserDaoImpl implements UserDao{
	//��ȡtemplate����
	private JdbcTemplate template = new JdbcTemplate((DataSource) JDBCUtils.getDataSource());
	/**
	 * ͨ���û�������������û�
	 */
	@Override
	public User findByUsernamePassword(String userUsername,String userPassword) {
		User u = null;
		String sql = "select * from user where user_username = ? and user_password = ?";
		try {
			u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),userUsername,userPassword);
		}catch(Exception e) {
			
		}
		return u;
	}
	/**
	 * ����û���Ϣ�����ݿ�
	 */
	@Override
	public int addUser(User RegistUser) {
		String sql = "insert into user values (null,?,?,?,?,?)";
		int result = template.update(sql,RegistUser.getUserUsername(),RegistUser.getUserPassword(),RegistUser.getUserEmail(),0,0);
		return result;
	}
	/**
	 * ͨ���û��������û�
	 */
	@Override
	public User findByUsername(String userUsername) {
		User u = null;
		String sql = "select * from user where user_username = ?";
		try {
			u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),userUsername);
		}catch(Exception e) {
			
		}
		return u;
	}
	/**
	 * ���������û�
	 */
	@Override
	public List findAllUser() {
		String sql = "select * from user";
		return template.queryForList(sql);
	}
	/**
	 * �޸��û�
	 */
	@Override
	public int updateUser(User user) {
		String sql = "update user set user_username = ?,user_password = ?,user_email = ? where user_id = ?";
		return template.update(sql,user.getUserUsername(),user.getUserPassword(),user.getUserEmail(),user.getUserId());
		
	}
	/**
	 * ͨ���û���������͹���Ա�����û�
	 */
	@Override
	public User findByUsernamePasswordIsmanager(String userUsername, String userPassword) {
		User u = null;
		String sql = "select * from user where user_username = ? and user_password = ? and user_ismanager = 1";
		try{
			u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),userUsername,userPassword);
		}catch(Exception e) {
			
		}
		return u;
	}
	/**
	 * ɾ���û�
	 */
	@Override
	public int deleteUser(int userId) {
		String sql = "delete from user where user_id = ?";
		return template.update(sql,userId);
	}
	/**
	 * ͨ���û��������û���list����
	 */
	@Override
	public List findListByUsername(String userUsername) {
		String sql = "select * from user where user_username = ?";
		List list = null;
		try {
			list = template.queryForList(sql,userUsername);
		}catch(Exception e) {
			
		}
		return list;
	}
	/**
	 * ��ӻ�Ա
	 */
	@Override
	public int addIsvip(Integer userId) {
		String sql = "update user set user_isvip = 1 where user_id = ?";
		int result = 0;
		try {
			result = template.update(sql,userId);
		}catch(Exception e) {
		}
		return result;
	}
	/**
	 * �Ƴ���Ա
	 */
	@Override
	public int removeIsvip(Integer userId) {
		String sql = "update user set user_isvip = 0 where user_id = ?";
		int result = 0;
		try {
			result = template.update(sql,userId);
		}catch(Exception e) {
		}
		return result;
	}
	/**
	 * ��ӹ���Ա
	 */
	@Override
	public int addIsManager(Integer userId) {
		String sql = "update user set user_ismanager = 1 where user_id = ?";
		int result = 0;
		try {
			result = template.update(sql,userId);
		}catch(Exception e) {
		}
		return result;
	}
	/**
	 * �Ƴ�����Ա
	 */
	@Override
	public int removeIsmanager(Integer userId) {
		String sql = "update user set user_ismanager = 0 where user_id = ?";
		int result = 0;
		try {
			result = template.update(sql,userId);
		}catch(Exception e) {
		}
		return result;
	}
	
	
}
