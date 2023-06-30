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
public class ChannelInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道ID")
    private long channelId;

    @JSONField(name = "channel_name")
    @FieldDescription("子频道名称")
    private String channelName;

}
