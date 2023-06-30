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
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "type")
    @FieldDescription("权限类型，参考 PermissionType")
    private String type;

    @JSONField(name = "specify_role_ids")
    @FieldDescription("有权限的身份组id的列表")
    private String[] specify_role_ids;

    @JSONField(name = "specify_user_ids")
    @FieldDescription("有权限的用户id的列表")
    private String[] specify_user_ids;

}
