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
public class ThreadInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "thread_id")
    @FieldDescription("主帖ID")
    private String threadId;

    @JSONField(name = "title")
    @FieldDescription("帖子标题")
    private String title;

    @JSONField(name = "content")
    @FieldDescription("帖子内容")
    private String content;

    @JSONField(name = "date_time")
    @FieldDescription("发表时间")
    private String dateTime;
}
