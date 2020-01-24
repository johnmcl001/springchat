package com.jmcl.springchat.web;

import com.jmcl.springchat.Chat;
import com.jmcl.springchat.data.ChatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/chat")
public class ChatController {

    private final ChatRepository chatRepo;

    @Autowired
    public ChatController(ChatRepository chatRepo) {
        this.chatRepo = chatRepo;
    }

    @GetMapping
    public String showChatHistory(Model model){

        List<Chat> chatHistory = new ArrayList<>();

        chatRepo.getHistory().forEach(chatHistory::add);

        model.addAttribute("chatHistory", chatHistory);
        model.addAttribute("chat", new Chat(null, null));

        log.info(model.toString());

        return "chat";
    }

    @PostMapping
    public String processChat(@Valid @ModelAttribute Chat chat, Errors errors){
        if (errors.hasErrors()){
            return "chat";
        }
        chatRepo.save(chat);
        return "redirect:chat";
    }

}
