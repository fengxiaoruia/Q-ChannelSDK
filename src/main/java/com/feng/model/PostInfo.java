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
public class PostInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "thread_id")
    @FieldDescription("主题ID")
    private String threadId;

    @JSONField(name = "post_id")
    @FieldDescription("帖子ID")
    private String postId;

    @JSONField(name = "content")
    @FieldDescription("帖子内容")
    private String content;

    @JSONField(name = "date_time")
    @FieldDescription("评论时间")
    private String dateTime;
}
