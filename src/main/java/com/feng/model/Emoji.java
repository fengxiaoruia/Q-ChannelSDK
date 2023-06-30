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
public class Emoji implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    @FieldDescription("表情ID，系统表情使用数字为ID，emoji使用emoji本身为id，参考 Emoji 列表")
    private String id;

    @JSONField(name = "type")
    @FieldDescription("表情类型 EmojiType")
    private int type;


}
