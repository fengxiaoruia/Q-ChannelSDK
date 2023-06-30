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
public class TextElem implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "text")
    @FieldDescription("正文")
    private String text;

    @JSONField(name = "props")
    @FieldDescription("文本属性")
    private TextProps props;

}
