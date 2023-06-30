package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
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
public class RenderData implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "label")
    @FieldDescription("按钮上的文字")
    private String label;

    @JSONField(name = "visited_label")
    @FieldDescription("点击后按钮上的文字")
    private String visitedLabel;

    @JSONField(name = "style")
    @FieldDescription("按钮样式")
    private int style;


}
