package com.feng.model;

import com.alibaba.fastjson2.JSONObject;
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
public class BotSocketMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "op")
    @FieldDescription("opcode")
    private int op;

    @JSONField(name = "d")
    @FieldDescription("代表事件内容")
    private JSONObject d;

    @JSONField(name = "s")
    @FieldDescription("下行消息都会有一个序列号，标识消息的唯一性，客户端需要再发送心跳的时候，携带客户端收到的最新的s")
    private int s;

    @JSONField(name = "t")
    @FieldDescription("代表事件类型")
    private String t;


}