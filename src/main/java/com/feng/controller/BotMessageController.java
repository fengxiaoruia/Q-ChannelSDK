package com.feng.controller;

import com.feng.config.ChannelBotClient;
import com.feng.constant.BotConsts;
import com.feng.model.Message;
import com.feng.model.domain.RestfulResponse;
import com.feng.model.domain.SendMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = BotConsts.MS_API_PREFIX + BotMessageController.API_PREFIX, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "消息接口")
@Validated
@Slf4j
public class BotMessageController {

    static final String API_PREFIX="/message";



    @Operation(summary = "主动发送消息")
    @Parameter(name = "channelId", description = "channelId", required = true, in = ParameterIn.QUERY)
    @RequestMapping(value = "/send-message", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public RestfulResponse<Message> detailById(@RequestParam String channelId, @RequestBody SendMessage sendMessage){
        ChannelBotClient channelBotClient = new ChannelBotClient();
        Message message = channelBotClient.sendChannelMessage(channelId, sendMessage);
        return RestfulResponse.success(message);
    }



}
