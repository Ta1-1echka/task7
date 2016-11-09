package database;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Tanya on 09.11.2016.
 */
@Repository("userDAO")
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User verifyUserByLoginPass(String login, String pass) {
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

    public void addUser(String login, String pass, String firstname, String lastname, String email) {
        this.jdbcTemplate.update("insert into userinfo (login, password, firstname, lastname, email)" +
                " values (?, ?, ?, ?, ?)", login, pass, firstname, lastname, email);
    }

    public User findUserByLogin(String login) {

        User returnUser = null;
        try {
            returnUser = this.jdbcTemplate.queryForObject("select * from userinfo where login = ?",
                    new Object[]{login}, new RowMapper<User>() {
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

    public void editUser(User user) {
        this.jdbcTemplate.update(
                "update userinfo set login = ?, password = ?, firstname = ?, lastname = ?," +
                        "email = ? where iduser = ?", user.getLogin(), user.getPassword(),
                user.getFirstname(), user.getLastname(), user.getEmail(), user.getIduser());
    }
}
