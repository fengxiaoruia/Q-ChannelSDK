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
public class APIPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "path")
    @FieldDescription("API 接口名，例如 /guilds/{guild_id}/members/{user_id}")
    private String path;

    @JSONField(name = "method")
    @FieldDescription("请求方法，例如 GET")
    private String method;

    @JSONField(name = "desc")
    @FieldDescription("API 接口名称，例如 获取频道信")
    private String desc;

    @JSONField(name = "auth_status")
    @FieldDescription("授权状态，auth_stats 为 1 时已授权")
    private int authStatus;

}
