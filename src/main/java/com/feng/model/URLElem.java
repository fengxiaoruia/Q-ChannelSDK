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
public class URLElem implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "url")
    @FieldDescription("URL链接")
    private String url;

    @JSONField(name = "desc")
    @FieldDescription("URL描述")
    private String desc;

}
