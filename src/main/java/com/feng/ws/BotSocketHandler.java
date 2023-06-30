package com.feng.ws;

import com.alibaba.fastjson2.JSONObject;
import com.feng.config.ChannelBotClient;
import com.feng.event.AbstractEvent;
import com.feng.model.BotSocketMessage;
import com.feng.util.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketConnectionManager;

import javax.annotation.Resource;

@Slf4j
public class BotSocketHandler implements WebSocketHandler {
    public static WebSocketSession SESSION;

    public static JSONObject D;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("客户端连接成功:{}", session.getId());
        BotSocketHandler.SESSION = session;

        // 鉴权链接
        JSONObject message = new JSONObject();
        message.put("token", ChannelBotClient.BOT_OPEN_KEY);
        message.put("intents", 512);
        message.put("shard", new int[]{0, 4});
        message.put("properties", "{}");
        BotSocketMessage build = BotSocketMessage.builder()
                .op(2)
                .d(message)
                .build();
        this.D = null;
        TextMessage textMessage = new TextMessage(JSONObject.toJSONString(build));
        session.sendMessage(textMessage);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        log.info("客户端接受到消息:{},{}", session.getId(), message.getPayload());

        JSONObject d = JSONObject.parseObject((String) message.getPayload()).getJSONObject("d");
        if(d!=null) {
            this.D = d;
        }

        ApplicationContext getApplicationContext = SpringContextUtils.applicationContext;
        getApplicationContext.publishEvent(new AbstractEvent(message.getPayload()));

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("客户端发送错误:{},{}", session.getId(), exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        session.close();
        log.info("客户端关闭连接:{},{}", session.getId(), closeStatus.getCode());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }



}
