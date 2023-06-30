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
public class EmojiInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    @FieldDescription("表情ID")
    private String id;

    @JSONField(name = "type")
    @FieldDescription("表情类型")
    private String type;

    @JSONField(name = "name")
    @FieldDescription("名称")
    private String name;

    @JSONField(name = "url")
    @FieldDescription("链接")
    private String url;
}
