package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.User;
import utils.JDBCUtils;
/**
 * 用户数据库连接接口实现类
 * @author Powers
 *
 */
public class UserDaoImpl implements UserDao{
	//获取template对象
	private JdbcTemplate template = new JdbcTemplate((DataSource) JDBCUtils.getDataSource());
	/**
	 * 通过用户名和密码查找用户
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
	 * 添加用户信息到数据库
	 */
	@Override
	public int addUser(User RegistUser) {
		String sql = "insert into user values (null,?,?,?,?,?)";
		int result = template.update(sql,RegistUser.getUserUsername(),RegistUser.getUserPassword(),RegistUser.getUserEmail(),0,0);
		return result;
	}
	/**
	 * 通过用户名查找用户
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
	 * 查找所有用户
	 */
	@Override
	public List findAllUser() {
		String sql = "select * from user";
		return template.queryForList(sql);
	}
	/**
	 * 修改用户
	 */
	@Override
	public int updateUser(User user) {
		String sql = "update user set user_username = ?,user_password = ?,user_email = ? where user_id = ?";
		return template.update(sql,user.getUserUsername(),user.getUserPassword(),user.getUserEmail(),user.getUserId());
		
	}
	/**
	 * 通过用户名，密码和管理员查找用户
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
	 * 删除用户
	 */
	@Override
	public int deleteUser(int userId) {
		String sql = "delete from user where user_id = ?";
		return template.update(sql,userId);
	}
	/**
	 * 通过用户名查找用户的list集合
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
	 * 添加会员
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
	 * 移除会员
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
	 * 添加管理员
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
	 * 移除管理员
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
