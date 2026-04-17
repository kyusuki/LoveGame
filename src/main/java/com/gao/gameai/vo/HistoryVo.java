package com.gao.gameai.vo;

import lombok.Data;
import org.springframework.ai.chat.messages.Message;

@Data
public class HistoryVo {
    private String role;
    private String content;
    public HistoryVo(Message message){
        switch (message.getMessageType()){
            case USER:
                role="user";
                break;
            case ASSISTANT:
                role="assistant";
                break;
            default:
                role="";
                break;
        }
        this.content= message.getText();
    }
}
