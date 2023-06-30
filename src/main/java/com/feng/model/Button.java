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
public class Button implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    @FieldDescription("按钮 id")
    private String id;

    @JSONField(name = "render_data")
    @FieldDescription("按钮渲染展示对象")
    private RenderData renderData;

    @JSONField(name = "action")
    @FieldDescription("按钮操作相关字段")
    private Action action;

}
