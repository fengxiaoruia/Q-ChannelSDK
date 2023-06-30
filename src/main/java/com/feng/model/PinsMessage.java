package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PinsMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    @FieldDescription("频道 id")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道 id")
    private String channelId;

    @JSONField(name = "message_ids")
    @FieldDescription("子频道内精华消息 id 数组")
    private List<String> messageIds;

}
