package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "username")
    private String username;

    @JSONField(name = "avatar")
    private String avatar;

    @JSONField(name = "bot")
    private boolean bot;

    @JSONField(name = "union_openid")
    private String unionOpenid;

    @JSONField(name = "union_user_account")
    private String unionUserAccount;
}
