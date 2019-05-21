package com.yifeng.yfcore.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YfRole {
    private Integer id;

    private String roleName;

    private Integer type;

    private Integer status;

    private String remark;

    private String operator;

    private Date operatorTime;

    private Set<YfAcl> acls;

}