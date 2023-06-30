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
public class AuditResult implements Serializable {

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

    @JSONField(name = "thread_id")
    @FieldDescription("主题ID")
    private String threadId;

    @JSONField(name = "post_id")
    @FieldDescription("帖子ID")
    private String postId;

    @JSONField(name = "reply_id")
    @FieldDescription("回复ID")
    private String replyId;

    @JSONField(name = "type")
    @FieldDescription("审核的类型")
    private int type;

    @JSONField(name = "result")
    @FieldDescription("审核结果")
    private int result;

    @JSONField(name = "err_msg")
    @FieldDescription("错误信息")
    private String errMsg;
}
