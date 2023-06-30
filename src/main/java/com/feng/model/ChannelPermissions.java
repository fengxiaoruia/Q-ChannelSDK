package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelPermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "channel_id")
    private String channelId;

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "role_id")
    private String roleId;

    @JSONField(name = "permissions")
    private String permissions;


}
