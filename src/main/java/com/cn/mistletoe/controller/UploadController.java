package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonPath;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.common.MyImgLoad;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author jxingyu
 * date 2020-11-24 18:32
 * code 图片上传接口
 */
@RestController
@RequestMapping("/user")
public class UploadController {
    private static String imgurl = "/images/";

    @Autowired
    UserService userService;

    @PostMapping("/player/iconUpdate")
    public CommonResult uploadFile(@RequestParam int id, HttpServletRequest request,@RequestParam("icon") MultipartFile file) throws IOException {
        MyImgLoad.loadOne(request,file);
        User user = new User();
        user.setId(id);
        user.setIcon((String) request.getAttribute("imgHref"));
        Integer integer =userService.uploadFile(user);
        return CommonResult.success(integer,"code:200");
    }

}