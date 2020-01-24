package com.jmcl.springchat.data;

import com.jmcl.springchat.User;

public interface UserRepository {
    User getUser(String userName);
    void save(User user);
}
