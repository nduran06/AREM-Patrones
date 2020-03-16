package escuelaing.edu.arem.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import escuelaing.edu.arem.dao.UserDAO;
import escuelaing.edu.arem.model.User;

@Repository("postgresql")
public class UserPostgresImpl implements UserDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setName(resultSet.getString("user_name"));;
            user.setBirthday(resultSet.getDate("user_birth"));
            user.setDocument(resultSet.getString("user_doc"));
            user.setPhone(resultSet.getString("user_phone"));
            user.setEmail(resultSet.getString("user_email"));

            return user;
        }
    }
	

	@Override
	public Collection<User> getAllUsers() {
		final String sql = "SELECT * FROM pt_user";
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
		return users;
	}

	@Override
	public void addUser(User user) {
        final String sql = "INSERT INTO pt_user (user_name, user_birth, user_doc, user_phone, user_email) VALUES (?, ?, ?, ?, ?)";		
        final String name = user.getName();
        final Date birth = user.getBirthday();
        final String doc = user.getDocument(); 
        final String phone = user.getPhone();
        final String email = user.getEmail();
        
        jdbcTemplate.update(sql, new Object[]{name, birth, doc, phone, email});
	
	}

}
