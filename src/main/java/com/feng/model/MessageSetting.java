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
public class MessageSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "disable_create_dm")
    @FieldDescription("是否允许创建私信")
    private String disableCreateDm;

    @JSONField(name = "disable_push_msg")
    @FieldDescription("是否允许发主动消息")
    private String disablePushMsg;

    @JSONField(name = "channel_ids")
    @FieldDescription("子频道 id 数组")
    private List<String> channelIds;

    @JSONField(name = "channel_push_max_num")
    @FieldDescription("每个子频道允许主动推送消息最大消息条数")
    private int channelPushMaxNum;
}
