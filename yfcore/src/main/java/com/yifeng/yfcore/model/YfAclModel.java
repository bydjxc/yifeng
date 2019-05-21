package com.yifeng.yfcore.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YfAclModel {
    private Integer id;

    private String aclModelName;

    private Integer pid;

    private Integer level;

    private Integer seq;

    private String status;

    private String remark;

    private String operator;

    private Date operatorTime;

}