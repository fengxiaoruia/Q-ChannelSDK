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
public class ImageElem implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "third_url")
    @FieldDescription("第三方图片链接")
    private String thirdUrl;

    @JSONField(name = "width_percent")
    @FieldDescription("宽度比例（缩放比，在屏幕里显示的比例）")
    private double widthPercent;

}
