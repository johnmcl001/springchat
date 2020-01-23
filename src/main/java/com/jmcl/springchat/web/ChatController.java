package com.jmcl.springchat.web;

import com.jmcl.springchat.Chat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@Controller
@RequestMapping("/chat")
public class ChatController {

    /*private List<Chat> chatHistory = Arrays.asList(
            new Chat("john", "Hello"),
            new Chat("forest", "Hello"),
            new Chat("john", "how are you?"),
            new Chat("forest", "I'm good, you?"),
            new Chat("john", "not too bad")
    );*/

    private List<Chat> chatHistory = new ArrayList<>();

    @GetMapping
    public String showChatHistory(Model model){

        model.addAttribute("chatHistory", chatHistory);
        model.addAttribute("chat", new Chat(null, null));

        return ("chat");
    }

    @PostMapping
    public String processChat(Model model, @Valid @ModelAttribute Chat chat, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("chatHistory", chatHistory);
            return "chat";
        }
        chatHistory.add(chat);
        model.addAttribute("chatHistory", chatHistory);
        return "chat";
    }

}
