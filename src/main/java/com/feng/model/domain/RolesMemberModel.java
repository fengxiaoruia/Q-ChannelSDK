package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.model.Member;
import com.feng.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesMemberModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "data")
    private List<Member> member;

    @JSONField(name = "next")
    private String next;


}
