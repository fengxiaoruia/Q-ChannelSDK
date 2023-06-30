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
public class URLInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "url")
    @FieldDescription("链接地址")
    private String url;

    @JSONField(name = "display_text")
    @FieldDescription("链接显示文本")
    private String displayText;
}
