package com.yifeng.yfcore.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YfDept {
    private Integer id;

    private String deptName;

    private Integer pid;

    private Integer level;

    private Integer seq;

    private String remark;

    private String operator;

    private Date operatorTime;

}