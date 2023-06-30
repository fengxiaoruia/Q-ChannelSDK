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
public class MessageDelete implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "message")
    @FieldDescription("被删除的消息内容")
    private Message message;

    @JSONField(name = "op_user")
    @FieldDescription("执行删除操作的用户")
    private User opUser;

}
