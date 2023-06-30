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
public class MessageEmbedField implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "name")
    @FieldDescription("字段名")
    private String name;


}
