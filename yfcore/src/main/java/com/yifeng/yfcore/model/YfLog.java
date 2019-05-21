package com.yifeng.yfcore.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YfLog {
    private Integer id;

    private Integer type;

    private Integer targetId;

    private String operator;

    private Date operateTime;

    private Integer status;

}