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
public class MessageMarkdownParams implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "key")
    @FieldDescription("markdown 模版 key")
    private String key;

    @JSONField(name = "values")
    @FieldDescription("markdown 模版 key 对应的 values ，列表长度大小为 1，传入多个会报错")
    private String[] values;

}
