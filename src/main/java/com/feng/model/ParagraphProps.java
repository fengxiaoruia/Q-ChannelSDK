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
public class ParagraphProps implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "alignment")
    @FieldDescription("段落对齐方向属性，数值可以参考Alignment")
    private int alignment;


}
