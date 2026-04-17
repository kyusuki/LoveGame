package com.gao.gameai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/ai")
public class GameController {
    private final ChatClient gameChatClient;

    public GameController(ChatClient gameChatClient) {
        this.gameChatClient = gameChatClient;
    }

    @RequestMapping(value="/game",produces="text/html;charset=utf-8")
    public Flux<String> chat(@RequestParam String prompt,@RequestParam String chatId){
        return gameChatClient.prompt()
                .user(prompt)
                .advisors(a->a.param(CONVERSATION_ID,chatId))
                .stream()
                .content()
                .map(chunk->chunk.replace("\n","<br/>"));

    }
}
