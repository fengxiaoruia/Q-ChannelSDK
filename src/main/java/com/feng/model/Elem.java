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
public class Elem implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "text")
    @FieldDescription("文本元素 参考elemType")
    private String text;

    @JSONField(name = "image")
    @FieldDescription("图片元素")
    private ImageElem image;

    @JSONField(name = "video")
    @FieldDescription("视频元素")
    private VideoElem video;

    @JSONField(name = "url")
    @FieldDescription("URL元素")
    private URLElem url;

    @JSONField(name = "type")
    @FieldDescription("元素类型 参考elemType")
    private String type;

}
