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
public class VideoElem implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "third_url")
    @FieldDescription("第三方视频文件链接")
    private String thirdUrl;


}
