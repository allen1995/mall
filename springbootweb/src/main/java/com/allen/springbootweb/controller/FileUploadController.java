package com.allen.springbootweb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: allen
 * @Date: 2020-06-07 11:27
 * @Description:
 */
@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping("upload")
    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest req){
        String realPath = req.getSession().getServletContext().getRealPath("/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + "uploadFile/" + format);
        if( !folder.exists()){
            System.out.println(folder.mkdirs());
        }

        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

        try {
            uploadFile.transferTo(new File(folder,newName));
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +
                    "/static/uploadFile/" + format+ "/" + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传失败";
    }
}
