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
public class AtRoleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "role_id")
    @FieldDescription("身份组ID")
    private long roleId;

    @JSONField(name = "name")
    @FieldDescription("身份组名称")
    private String name;

    @JSONField(name = "color")
    @FieldDescription("颜色值")
    private int color;

}
