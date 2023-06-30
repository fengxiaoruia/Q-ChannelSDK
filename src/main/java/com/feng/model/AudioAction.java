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
public class AudioAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    @FieldDescription("频道id")
    private String guildId;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道id")
    private String channelId;

    @JSONField(name = "audio_url")
    @FieldDescription("音频数据的url")
    private String audioUrl;

    @JSONField(name = "text")
    @FieldDescription("状态文本")
    private String text;

}
