package com.yifeng.yfcore.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YfUser {
    private Integer id;

    @NotEmpty(message = "用户名称不能为空")
    private String username;

    private String telephone;

    private String email;

    private String password;

    private Integer deptId;

    private Integer status;

    private String remark;

    private String operator;

    private Date operatorTime;

    private String salt;

    private Set<YfRole> roles;

}