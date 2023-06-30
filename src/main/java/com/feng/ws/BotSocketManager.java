package com.feng.ws;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.jetty.JettyWebSocketSession;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@Configuration
@DependsOn("connectionManager")
public class BotSocketManager {

    @Resource
    private WebSocketConnectionManager connectionManager;

    @Scheduled(fixedDelay = 5000)
    public void reconnectTask() {
        if(BotSocketHandler.SESSION != null && !BotSocketHandler.SESSION.isOpen()){
            log.info("Bot已失联，尝试重新连接");
            connectionManager.stop();
            connectionManager.start();
        }
    }


    @Scheduled(fixedDelay = 30 * 1000)
    public void heartbeatTask() {
        if(BotSocketHandler.SESSION != null && BotSocketHandler.SESSION.isOpen()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("op",1);
            jsonObject.put("d",BotSocketHandler.D);
            TextMessage textMessage = new TextMessage(jsonObject.toJSONString());
            try {
                log.info("发送心跳");
                BotSocketHandler.SESSION.sendMessage(textMessage);
            } catch (IOException e) {
                log.error("发送心跳失败: {}", e.getMessage());
            }
        }
    }

}
