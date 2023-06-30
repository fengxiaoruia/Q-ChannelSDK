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
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    @FieldDescription("日程 id")
    private String id;

    @JSONField(name = "name")
    @FieldDescription("日程名称")
    private String name;

    @JSONField(name = "description")
    @FieldDescription("日程描述")
    private String description;

    @JSONField(name = "start_timestamp")
    @FieldDescription("日程开始时间戳(ms)")
    private String startTimestamp;

    @JSONField(name = "end_timestamp")
    @FieldDescription("日程结束时间戳(ms)")
    private String endTimestamp;

    @JSONField(name = "creator")
    @FieldDescription("创建者")
    private Member creator;

    @JSONField(name = "jump_channel_id")
    @FieldDescription("日程开始时跳转到的子频道 id")
    private String jumpChannelId;

    @JSONField(name = "remind_type")
    @FieldDescription("日程提醒类型，取值参考RemindType")
    private String remindType;

}
