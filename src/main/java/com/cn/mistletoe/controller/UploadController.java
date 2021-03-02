package com.cn.mistletoe.controller;

import cn.hutool.http.HttpRequest;
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

    /**
     * 队员个人信息编辑功能
     *
     * @param id
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/player/iconUpdate")
    public CommonResult uploadFile(@RequestParam int id, HttpServletRequest request, @RequestParam("icon") MultipartFile file) throws IOException {
        MyImgLoad.loadOne(request, file);
        User user = new User();
        user.setId(id);
        user.setIcon((String) request.getAttribute("imgHref"));
        Integer integer = userService.uploadFile(user);
        return CommonResult.success(integer, "code:200");
    }

    @PostMapping("/registerIconUpdate")
    public CommonResult registerIconUpdate(@RequestParam int id,HttpServletRequest request, @RequestParam("icon") MultipartFile file) {
        MyImgLoad.loadOne(request, file);
        User user = new User();
        user.setId(id);
        user.setIcon((String) request.getAttribute("imgHref"));
        Integer integer = userService.registerIconUpdate(user);
        return CommonResult.success(integer, "code:200");
    }
}