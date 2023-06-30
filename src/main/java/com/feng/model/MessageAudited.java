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
public class MessageAudited implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "audit_id")
    @FieldDescription("消息审核 id")
    private String auditId;

    @JSONField(name = "message_id")
    @FieldDescription("消息 id")
    private String messageId;

    @JSONField(name = "guild_id")
    @FieldDescription("频道 id")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道 id")
    private String channelId;

    @JSONField(name = "audit_time")
    @FieldDescription("消息审核时间")
    private String auditTime;

    @JSONField(name = "create_time")
    @FieldDescription("消息创建时间")
    private String createTime;

    @JSONField(name = "seq_in_channel")
    @FieldDescription("子频道消息 seq")
    private String seqInChannel;
}
