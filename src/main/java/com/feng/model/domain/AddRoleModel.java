package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddRoleModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "name")
    private String name;

    @JSONField(name = "color")
    private long color;

    @JSONField(name = "hoist")
    private long hoist;


}
