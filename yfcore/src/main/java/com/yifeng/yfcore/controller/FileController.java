package com.yifeng.yfcore.controller;

import com.yifeng.yfcore.common.YfBaseData;
import com.yifeng.yfcore.model.FastDFSFile;
import com.yifeng.yfcore.utils.FastDFSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 10:39 2019/4/10
 * @Modified By
 * @Version 1.0
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @RequestMapping("/upload")
    public String saveFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath={};
        String fileName=multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream=multipartFile.getInputStream();
        if(inputStream!=null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            log.error("upload file Exception!",e);
        }
        if (fileAbsolutePath==null) {
            log.error("upload file failed,please upload again!");
        }
        String path=FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];
        System.out.println("测试");
        return path;
    }

    @RequestMapping("/download")
    public void downloadFile(String groupName, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream inputStream = FastDFSClient.downFile(groupName, fileName);
        byte[] file_buff = null;
        if(inputStream!=null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode( fileName.substring(fileName.lastIndexOf("/")), "UTF-8"));
        response.getOutputStream().write(file_buff);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public YfBaseData deleteFile(String groupName, String fileName) throws Exception {
        try{
            FastDFSClient.deleteFile(groupName, fileName);

        }catch(Exception e){
            return YfBaseData.failure("删除失败");
        }
        return YfBaseData.success("删除成功");
    }

}
