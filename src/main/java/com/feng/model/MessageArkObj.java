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
public class MessageArkObj implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "obj_kv")
    @FieldDescription("ark objkv列表")
    private List<MessageArkObjKv> objKv;
}
