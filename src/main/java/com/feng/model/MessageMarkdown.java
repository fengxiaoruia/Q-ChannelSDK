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
public class MessageMarkdown implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "template_id")
    @FieldDescription("markdown 模板 id")
    private int templateId;

    @JSONField(name = "custom_template_id")
    @FieldDescription("markdown 自定义模板 id")
    private String customTemplateId;

    @JSONField(name = "params")
    @FieldDescription("markdown 模板模板参数")
    private MessageMarkdownParams params;

    @JSONField(name = "content")
    @FieldDescription("原生 markdown 内容")
    private String content;

}
