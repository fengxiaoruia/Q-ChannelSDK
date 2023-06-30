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
public class InlineKeyboardRow implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "buttons")
    @FieldDescription("数组的一项代表一个按钮，每个 InlineKeyboardRow 最多含有 5 个 Button")
    private List<Button> buttons;


}
