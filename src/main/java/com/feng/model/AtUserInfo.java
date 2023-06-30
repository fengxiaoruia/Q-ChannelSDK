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
public class AtUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    @FieldDescription("身份组ID")
    private String id;

    @JSONField(name = "nick")
    @FieldDescription("用户昵称")
    private String nick;


}
