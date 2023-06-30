package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.model.Role;
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
public class RoleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    private String guildId;

    @JSONField(name = "roles")
    private List<Role> roles;

    @JSONField(name = "role_num_limit")
    private String roleNumLimit;



}
