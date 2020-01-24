package com.jmcl.springchat.data;

import com.jmcl.springchat.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcChatRepository implements ChatRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcChatRepository(JdbcTemplate j) {
        jdbc = j;
    }

    @Override
    public Iterable<Chat> getHistory() {
        return jdbc.query("select user, message from Chat",
                this::mapRowToChat);
    }

    @Override
    public void save(Chat chat) {
        jdbc.update(
                "insert into Chat (user, message) values (?,?)",
                chat.getUser(),
                chat.getMessage()
        );
    }

    private Chat mapRowToChat(ResultSet rs, int rowNum) throws SQLException {
        return new Chat (
                rs.getString("user"),
                rs.getString("message")
        );
    }
}
