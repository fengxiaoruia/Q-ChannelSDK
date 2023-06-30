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
public class ReactionTarget implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    @FieldDescription("表态对象ID")
    private String id;

    @JSONField(name = "type")
    @FieldDescription("表态对象类型，参考 ReactionTargetType")
    private String type;


}
