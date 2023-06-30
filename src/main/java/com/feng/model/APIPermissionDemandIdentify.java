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
public class APIPermissionDemandIdentify implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "path")
    @FieldDescription("API 接口名，例如 /guilds/{guild_id}/members/{user_id}")
    private String path;

    @JSONField(name = "method")
    @FieldDescription("请求方法，例如 GET")
    private String method;
}
