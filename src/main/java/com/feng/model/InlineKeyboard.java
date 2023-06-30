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
public class InlineKeyboard implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "rows")
    @FieldDescription("数组的一项代表消息按钮组件的一行,最多含有 5 行")
    private List<InlineKeyboardRow> rows;


}
