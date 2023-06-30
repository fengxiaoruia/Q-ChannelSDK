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
public class AudioControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "audio_url")
    @FieldDescription("音频数据的url")
    private String audioUrl;

    @JSONField(name = "text")
    @FieldDescription("状态文本")
    private String text;

    @JSONField(name = "status")
    @FieldDescription("播放状态，参考 AudioStatus")
    private String status;

}
