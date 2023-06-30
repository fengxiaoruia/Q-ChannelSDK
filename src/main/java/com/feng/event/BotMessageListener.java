package com.feng.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BotMessageListener {
    @EventListener
    public void getMessage(AbstractEvent event) {
        log.info("客户端接受到消息:{}", event.getSource().toString());
    }
}
