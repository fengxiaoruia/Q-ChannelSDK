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
public class MessageReference implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "message_id")
    @FieldDescription("需要引用回复的消息 id")
    private String messageId;


    @JSONField(name = "ignore_get_message_error")
    @FieldDescription("是否忽略获取引用消息详情错误，默认否")
    private boolean ignoreGetMessageError;

}
