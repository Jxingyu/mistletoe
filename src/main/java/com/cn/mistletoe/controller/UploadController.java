package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.common.MyImgLoad;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

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