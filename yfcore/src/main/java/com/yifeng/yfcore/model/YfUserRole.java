package com.yifeng.yfcore.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YfUserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private String operator;

    private Date operatorTime;

    private YfUser yfUser;

    private YfRole yfRole;

}