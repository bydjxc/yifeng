package com.yifeng.yfcore.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class YfLogWithBLOBs extends YfLog {
    private String oldValue;

    private String newValue;

}