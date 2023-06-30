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
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "type")
    @FieldDescription("操作类型")
    private int type;

    @JSONField(name = "permission")
    @FieldDescription("操作按钮所需的权限")
    private Permission permission;

    @JSONField(name = "click_limit")
    @FieldDescription("可点击的次数")
    private int clickLimit;

    @JSONField(name = "data")
    @FieldDescription("操作相关数据")
    private String data;

    @JSONField(name = "at_bot_show_channel_list")
    @FieldDescription("是否弹出子频道选择器")
    private boolean atBotShowChannelList;

}
