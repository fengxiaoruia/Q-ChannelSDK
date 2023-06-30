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
public class TextProps implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "font_bold")
    @FieldDescription("加粗")
    private boolean fontBold;

    @JSONField(name = "italic")
    @FieldDescription("斜体")
    private boolean italic;

    @JSONField(name = "underline")
    @FieldDescription("下划线")
    private boolean underline;

}
