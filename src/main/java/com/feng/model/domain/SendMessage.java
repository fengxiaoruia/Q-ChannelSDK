package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.EmptyValueFilter;
import com.feng.config.FieldDescription;
import com.feng.model.*;
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
public class SendMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "content")
    @FieldDescription("选填，消息内容，文本内容，支持内嵌格式")
    private String content;

    @JSONField(name = "embed", serializeUsing = EmptyValueFilter.class)
    @FieldDescription("选填，embed 消息，一种特殊的 ark，详情参考Embed消息")
    private MessageEmbed embed;

    @JSONField(name = "ark", serializeUsing = EmptyValueFilter.class)
    @FieldDescription("ark 消息对象")
    private MessageArk ark;

    @JSONField(name = "message_reference", serializeUsing = EmptyValueFilter.class)
    @FieldDescription("引用消息对象")
    private MessageReference messageReference;

    @JSONField(name = "image")
    @FieldDescription("图片URL地址")
    private String image;

    @JSONField(name = "msg_id")
    @FieldDescription("要回复的消息ID")
    private String msgId;

    @JSONField(name = "event_id")
    @FieldDescription("要回复的事件ID")
    private String eventId;

    @JSONField(name = "markdown", serializeUsing = EmptyValueFilter.class)
    @FieldDescription("markdown 消息对象")
    private MessageMarkdown markdown;
}
