package com.jmcl.springchat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Chat {

    private final String user;
    private final String message;

}
