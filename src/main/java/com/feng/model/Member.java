package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "user")
    private User user;

    @JSONField(name = "nick")
    private String nick;

    @JSONField(name = "roles")
    private String[] roles;

    @JSONField(name = "joined_at")
    private String joinedAt;


}
