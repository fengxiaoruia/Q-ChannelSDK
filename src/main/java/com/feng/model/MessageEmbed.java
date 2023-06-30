package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.feng.config.FieldDescription;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageEmbed implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "title")
    @FieldDescription("标题")
    private String title;

    @JSONField(name = "prompt")
    @FieldDescription("消息弹窗内容")
    private String prompt;

    @JSONField(name = "thumbnail")
    @FieldDescription("缩略图")
    private MessageEmbedThumbnail thumbnail;

    @JSONField(name = "fields")
    @FieldDescription("embed 字段数据")
    private List<MessageEmbedField> fields;


}
