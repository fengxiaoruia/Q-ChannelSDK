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
public class AddThreadInfoModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "title")
    @FieldDescription("帖子标题")
    private String title;

    @JSONField(name = "content")
    @FieldDescription("帖子内容")
    private String content;

    @JSONField(name = "format")
    @FieldDescription("帖子文本格式 参考 Format")
    private String format;
}
