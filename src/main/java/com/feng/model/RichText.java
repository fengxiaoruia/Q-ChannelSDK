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
public class RichText implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "paragraphs")
    @FieldDescription("段落，一段落一行，段落内无元素的为空行")
    private Paragraph paragraphs;

    
}
