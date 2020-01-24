package com.jmcl.springchat.data;

import com.jmcl.springchat.Chat;

public interface ChatRepository {
    Iterable<Chat> getHistory();
    void save(Chat chat);
}
