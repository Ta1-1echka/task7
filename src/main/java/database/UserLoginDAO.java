package database;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Tanya on 07.11.2016.
 */
@Repository
public class UserLoginDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User verifyUser(String login, String pass) {
        User returnUser = null;
        try {
            returnUser = this.jdbcTemplate.queryForObject("select * from userinfo where login = ? and password = ?",
                    new Object[]{login, pass}, new RowMapper<User>() {
                        @Override
                        public User mapRow(ResultSet rs, int i) throws SQLException {
                            if (i >= 0) {
                                User newUser = new User();
                                newUser.setIduser(rs.getInt("iduser"));
                                newUser.setLogin(rs.getString("login"));
                                newUser.setPassword(rs.getString("password"));
                                newUser.setFirstname(rs.getString("firstname"));
                                newUser.setLastname(rs.getString("lastname"));
                                newUser.setEmail(rs.getString("email"));
                                return newUser;
                            } else return null;
                        }

                    });
        } catch (IncorrectResultSizeDataAccessException ex) {
            return null;
        }
        return returnUser;
    }
}
