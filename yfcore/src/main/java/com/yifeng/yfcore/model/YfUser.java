package com.yifeng.yfcore.model;

import lombok.*;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 12:33 2019/3/18
 * @Modified By
 * @Version 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YfUser {
    private int id;
    private String name;
    private int age;
    private String addr;
}
