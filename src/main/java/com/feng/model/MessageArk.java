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
public class MessageArk implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "template_id")
    @FieldDescription("ark模板id（需要先申请")
    private int templateId;


    @JSONField(name = "kv")
    @FieldDescription("kv值列表")
    private List<MessageArkKv> kv;
}
