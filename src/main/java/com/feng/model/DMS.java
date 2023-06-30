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
public class DMS implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    @FieldDescription("私信会话关联的频道 id")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("私信会话关联的子频道 id")
    private String channelId;

    @JSONField(name = "create_time")
    @FieldDescription("创建私信会话时间戳")
    private String createTime;

}
