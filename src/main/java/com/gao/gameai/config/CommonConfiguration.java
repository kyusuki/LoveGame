package com.gao.gameai.config;

import com.gao.gameai.chatsystem.ChatSystem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Configuration
public class CommonConfiguration {
    private final ChatClient chatClient;

    public CommonConfiguration(ChatModel model, ChatMemory chatMemory){
        chatClient=ChatClient.builder(model)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        new SimpleLoggerAdvisor())
                .build();
    }
    @Bean
    public ChatClient gameChatClient(OpenAiChatModel model, ChatMemory chatMemory){
        return ChatClient
                .builder(model)
                .defaultSystem(ChatSystem.GAME_SYSTEM)
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }
}
