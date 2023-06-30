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
public class Paragraph implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "elems")
    @FieldDescription("元素列表")
    private List<Elem> elems;

    @JSONField(name = "props")
    @FieldDescription("段落属性")
    private ParagraphProps props;

}
