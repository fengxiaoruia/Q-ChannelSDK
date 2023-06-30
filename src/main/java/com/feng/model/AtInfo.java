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
public class AtInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "type")
    @FieldDescription("at类型")
    private String type;

    @JSONField(name = "user_info")
    @FieldDescription("用户信息")
    private AtUserInfo userInfo;

    @JSONField(name = "role_info")
    @FieldDescription("角色组信息")
    private AtRoleInfo roleInfo;

    @JSONField(name = "guild_info")
    @FieldDescription("频道信息")
    private AtGuildInfo guildInfo;


}
