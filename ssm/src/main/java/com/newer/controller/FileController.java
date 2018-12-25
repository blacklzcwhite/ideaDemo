package com.newer.controller;



import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传和下载
 */


@Controller
public class FileController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upLoad(MultipartFile pic, HttpSession session) throws IOException {

        //获取当前项目目录下的imgs文件夹的绝对路径
        String path = session.getServletContext().getRealPath("imgs");

        //获取文件名称
        String fileName = pic.getOriginalFilename();

        //存入文件对象
        File file = new File(path, fileName);

        //上传的文件存到指定位置
        pic.transferTo(file);

        session.setAttribute("fileName",fileName);

        return "suc";

    }

    //下载 包装成二进制byte数组
    @RequestMapping("/download")
    public ResponseEntity<byte[]>downLoad(String fileName, HttpSession session) throws IOException {


        String path = session.getServletContext().getRealPath("imgs");

        File file = new File(path, fileName);

        HttpHeaders headers = new HttpHeaders();

        //设置头部数据 响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //设置通知浏览器处理方式   attachment附件
        headers.setContentDispositionFormData("attachment",fileName);


        return  new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }


}
