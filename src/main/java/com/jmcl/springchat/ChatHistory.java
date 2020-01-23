package com.jmcl.springchat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ChatHistory {

    private List<String> history;
}
