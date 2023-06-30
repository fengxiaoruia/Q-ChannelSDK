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
public class UpdateChannelPermissionsModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "add")
    private String add;

    @JSONField(name = "remove")
    private String remove;


}
