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
public class MessageReaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "user_id")
    @FieldDescription("用户ID")
    private String userId;

    @JSONField(name = "guild_id")
    @FieldDescription("频道ID")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道ID")
    private String channelId;

    @JSONField(name = "target")
    @FieldDescription("表态对象")
    private ReactionTarget target;

    @JSONField(name = "emoji")
    @FieldDescription("表态所用表情")
    private Emoji emoji;


    @JSONField(name = "message_id")
    @FieldDescription("表态所用表情")
    private String messageId;
}
