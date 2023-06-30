package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
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
public class MessageArkKv implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "key")
    @FieldDescription("ark模板id（需要先申请")
    private String key;

    @JSONField(name = "value")
    @FieldDescription("value")
    private String value;

    @JSONField(name = "obj")
    @FieldDescription("ark obj类型的列表")
    private List<MessageArkObj> obj;
}
