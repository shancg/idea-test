package com.example.demo.controller;

import com.example.demo.common.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.util.List;
/**
 * 文件上传控制类
 *
 * @author shancg
 * @data 2018/6/15
 */
@Controller
public class FileUploadController {

    // 访问路径为：http://ip:port/upload
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "/fileupload";
    }

    // 访问路径为：http://ip:port/upload/batch
    @RequestMapping(value = "/upload/batch", method = RequestMethod.GET)
    public String batchUpload() {
        return "/mutifileupload";
    }

    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\upload\\";
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回json
        return "uploadimg success";
    }

    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public @ResponseBody
    String batchUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file;
        String filePath = "E:\\upload\\";
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String fileName = file.getOriginalFilename();
            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            } catch (Exception e) {
                e.printStackTrace();
                return "You failed to upload " + i + " => " + e.getMessage();
            }
        }
        return "upload successful";
    }

}
