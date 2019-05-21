package com.yifeng.yfcore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 16:36 2019/4/9
 * @Modified By
 * @Version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FastDFSFile {
    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;
    public FastDFSFile(String name, byte[] content, String ext){
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
}
