package com.gao.gameai.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMemoryJdbc {
    private static final int DEFAULT_MAX_MESSAGES=20;
    private static final Logger log = LoggerFactory.getLogger(ChatMemoryJdbc.class);

    @Bean
    public ChatMemory chatMemory(JdbcChatMemoryRepository chatMemoryRepository){
        log.info("Initializing JDBC-based MessageWindowChatMemory with maxMessages={}", DEFAULT_MAX_MESSAGES);
        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(chatMemoryRepository)
                .maxMessages(DEFAULT_MAX_MESSAGES)
                .build();
    }
}
