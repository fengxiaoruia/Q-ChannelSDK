package com.feng.ws;
import com.feng.config.ChannelBotClient;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;


@Configuration
@Slf4j
public class BotSocketClient{

    @Bean
    public StandardWebSocketClient webSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public BotSocketHandler clientWebSocketHandler() {
        return new BotSocketHandler();
    }

    @Bean
    @DependsOn("botClient")
    public WebSocketConnectionManager connectionManager() {
        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(
                webSocketClient(),
                clientWebSocketHandler(),
                ChannelBotClient.BOT_WS_URL
        );
        connectionManager.setAutoStartup(true);
        return connectionManager;
    }

}
