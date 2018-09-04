package com.example.demo.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author shancg
 * @data 2018/6/15
 */
public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        if (StringUtils.isEmpty(fileName)) {
            return;
        }
//        String newFileName = getFileName(0,filePath,fileName);
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static String getFileName(int i, String filePath, String fileName) {
        String name = fileName.substring(0,fileName.lastIndexOf("."));
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        File file;
        if(i==0){
            file=new File(filePath+name+suffix);
            if (file.exists()) {
                return getFileName(++i,filePath,fileName);
            }else{
                return filePath+name+suffix;
            }
        }else{
            file=new File(filePath+name+"("+i+")"+suffix);
            if (file.exists()) {
                return getFileName(++i,filePath,fileName);
            }else{
                return filePath+name+"("+i+")"+suffix;
            }
        }
    }

    public static String getFileNameNio(int i, String filePath, String fileName) {
        String name = fileName.substring(0,fileName.lastIndexOf("."));
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        Path path;
        if (i==0){
            path = Paths.get(filePath+name+suffix);
            if (Files.exists(path)) {
                return getFileNameNio(++i,filePath,fileName);
            }else{
                return filePath+name+suffix;
            }
        }else{
            path = Paths.get(filePath+name+"("+i+")"+suffix);
            if (Files.exists(path)) {
                return getFileNameNio(++i,filePath,fileName);
            }else{
                return filePath+name+"("+i+")"+suffix;
            }
        }
    }

    public static void deleteFile(String fullFilePath) {
        File deleteFile = new File(fullFilePath);
        deleteFile.delete();
    }
}
