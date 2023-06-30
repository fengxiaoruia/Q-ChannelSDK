package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.constant.BotConsts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelBotInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "bot_app_id")
    private String botAppId;

    @JSONField(name = "bot_secret")
    private String botSecret;

    @JSONField(name = "bot_token")
    private String botToken;

    /*
        0为正式环境 1为测试环境
     */
    private int botType;
    public String getAuthorization(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Bot ").append(this.botAppId).append(".").append(botToken);
        return stringBuffer.toString();
    }

    public String getUrl(){
        if(this.botType == 0){
            return BotConsts.URL;
        }else{
            return BotConsts.TEST_URL;
        }
    }
}
