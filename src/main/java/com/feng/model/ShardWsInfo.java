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
public class ShardWsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "url")
    @FieldDescription("WebSocket 的连接地址")
    private String url;

    @JSONField(name = "shards")
    @FieldDescription("建议的 shard 数")
    private int shards;

    @JSONField(name = "session_start_limit")
    @FieldDescription("创建 Session 限制信息")
    private SessionStartLimit sessionStartLimit;

}
