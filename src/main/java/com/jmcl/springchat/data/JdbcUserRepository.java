package com.jmcl.springchat.data;

import com.jmcl.springchat.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcUserRepository implements UserRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcUserRepository(JdbcTemplate j) {
        jdbc = j;
    }

    @Override
    public User getUser(String userName) {
        return jdbc.queryForObject("select realName, userName from User where userName=?",
                this::mapRowToChat);
    }

    private User mapRowToChat(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getString("realName"),
                rs.getString("userName")
        );
    }

    @Override
    public void save(User user) {
        jdbc.update(
                "insert into User (realName, userName) values (?,?)",
                user.getRealName(),
                user.getUserName()
        );
    }
}
