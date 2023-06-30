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
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    @FieldDescription("频道ID")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道ID")
    private String channelId;

    @JSONField(name = "author_id")
    @FieldDescription("作者ID")
    private String authorId;

    @JSONField(name = "reply_info")
    @FieldDescription("回复内容")
    private ReplyInfo replyInfo;
}
