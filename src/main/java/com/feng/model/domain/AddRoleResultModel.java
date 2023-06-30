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
public class AddRoleResultModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "role_id")
    private String roleId;

    @JSONField(name = "role")
    private Role role;

}
