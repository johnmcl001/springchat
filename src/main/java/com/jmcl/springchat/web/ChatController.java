package com.jmcl.springchat.web;

import com.jmcl.springchat.Chat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/chat")
public class ChatController {

    @GetMapping
    public String showChatHistory(Model model){
        List<Chat> chatHistory = Arrays.asList(
                new Chat("john", "Hello"),
                new Chat("forest", "Hello"),
                new Chat("john", "how are you?"),
                new Chat("forest", "I'm good, you?"),
                new Chat("john", "not too bad")
        );

        model.addAttribute(chatHistory);
        log.info(model.toString());

        return("chat");
    }
}
