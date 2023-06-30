package com.feng.model.domain;

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
public class AddThreadResultModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "task_id")
    @FieldDescription("帖子任务ID")
    private String taskId;

    @JSONField(name = "create_time")
    @FieldDescription("发帖时间戳，单位：秒")
    private String createTime;

}
