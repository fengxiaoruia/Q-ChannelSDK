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
public class PlatImage implements Serializable {

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

    @JSONField(name = "image_id")
    @FieldDescription("图片ID")
    private String imageId;

}
