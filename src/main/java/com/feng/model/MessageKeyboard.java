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
public class MessageKeyboard implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "id")
    @FieldDescription("ekyboard 模板 id")
    private String id;

    @JSONField(name = "content")
    @FieldDescription("自定义 keyboard 内容,与 id 参数互斥,参数都传值将报错")
    private InlineKeyboard content;

}
