package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIPermissionDemand implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    @FieldDescription("申请接口权限的频道 id")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("接口权限需求授权链接发送的子频道 id")
    private String channelId;

    @JSONField(name = "api_identify")
    @FieldDescription("权限接口唯一标识")
    private APIPermissionDemandIdentify apiIdentify;

    @JSONField(name = "title")
    @FieldDescription("接口权限链接中的接口权限描述信息")
    private String title;

    @JSONField(name = "desc")
    @FieldDescription("接口权限链接中的机器人可使用功能的描述信息")
    private String desc;
}
