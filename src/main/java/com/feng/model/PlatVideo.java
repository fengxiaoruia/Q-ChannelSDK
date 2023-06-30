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
public class PlatVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "url")
    @FieldDescription("架平图片链接")
    private String url;

    @JSONField(name = "width")
    @FieldDescription("图片宽度")
    private int width;

    @JSONField(name = "height")
    @FieldDescription("图片高度")
    private int height;

    @JSONField(name = "video_id")
    @FieldDescription("视频ID")
    private String videoId;

    @JSONField(name = "duration")
    @FieldDescription("视频时长")
    private int duration;

    @JSONField(name = "cover")
    @FieldDescription("视频封面图属性")
    private PlatImage cover;

}
