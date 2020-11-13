package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.beans.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate template;

	@Autowired
	AddressDaoImpl addressDB;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<User> getAllUsers() {
		return template.query("select * from customer", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
						rs.getString("username"), rs.getString("password"), User.ROLE.valueOf(rs.getNString("role")),
						addressDB.getAddress(rs.getInt("address_id")), rs.getString("phone"));
				return u;
			}

		});
	}

	@Override
	public User getUser(int userId) {
		String query = "select * from user where user_id=?";
		return template.queryForObject(query, new Object[] {userId}, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User getUser(String email) {
		String query = "select * from user where email=?";
		return template.queryForObject(query, new Object[] {email}, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public boolean userExists(int id) {
		return getUser(id) != null;
	}

	@Override
	public User addUser(User u) {
		String query = "insert into user(username, password, first_name, last_name, email, phone, address_id, role) values("
				+ u.getUsername() + "," + u.getUserPass() + "," + u.getFirstName() + "," + u.getLastName() + "," + u.getUserEmail() + ","
				+ addressDB.createAddress(u.getBillingAddress()).getId() + "," + u.getUserRole().toString() + ")";
		template.update(query);
		return getUser(u.getUserEmail());
	}

	@Override
	public boolean editUser(User u) {
		String query = "update user set username='"+u.getUsername()+"', password='"+u.getUserPass()+"', first_name='"+u.getFirstName()
			+"', last_name='"+u.getLastName()+"', email='"+u.getUserEmail()+"', address_id="+addressDB.editAddress(u.getBillingAddress()).getId()
			+", role='"+u.getUserRole().toString()
			+" where user_id='" + u.getId();
		return template.update(query) != 0;
	}

	@Override
	public boolean deleteUser(User user) {
		String query = "delete from user where user_id=" + user.getId();
		addressDB.deleteAddress((int) user.getBillingAddress().getId());
		return template.update(query) != 0;
	}

}