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
public class Announces implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    @FieldDescription("频道 id")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道 id")
    private String channelId;

    @JSONField(name = "message_id")
    @FieldDescription("消息 id")
    private String messageId;

    @JSONField(name = "announces_type")
    @FieldDescription("公告类别 0:成员公告 1:欢迎公告，默认成员公告")
    private int announcesType;

    @JSONField(name = "recommend_channels")
    @FieldDescription("推荐子频道详情列表")
    private List<RecommendChannel> recommendChannels;

}
