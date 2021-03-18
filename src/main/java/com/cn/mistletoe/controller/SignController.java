package com.cn.mistletoe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Sign;
import com.cn.mistletoe.service.ISignService;
import com.cn.mistletoe.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;


@RestController
@RequestMapping("/sign")
public class SignController {
    @Autowired
    ISignService iSignService;

    @Autowired
    RedisService redisService;

    /**
     *
     * @param sign
     * @return
     */
    @PostMapping("/insertRecord")
    @PreAuthorize("hasAuthority('permission:attendance')")
    public CommonResult insertSignRecord(@RequestBody Sign sign) {
        Boolean b = iSignService.insertSignRecord(sign);
        return CommonResult.success(b, "200");
    }

    /**
     * 查询所有点到记录(支持模糊查询功能 )
     *
     * @param sign
     * @param response
     * @throws IOException
     */
    @GetMapping("/selectSignRecord")
    @PreAuthorize("hasAuthority('permission:attendance:notes')")
    public void selectSignRecord(Sign sign, HttpServletResponse response) throws IOException {
        Vector<Sign> v = iSignService.selectSignRecord(sign);
        int totalCount = iSignService.selectTotalCount(sign);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("SignRecord", v);
        jsonObject.put("totalCount", totalCount);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    /**
     * 更新sign 点到记录
     *
     * @param sign
     * @return
     */
    @PostMapping("/updateSign")
    @PreAuthorize("hasAuthority('permission:record:update')")
    public CommonResult updateSign(@RequestBody Sign sign) {
        int i = iSignService.updateSign(sign);
        return CommonResult.success(i, "200");
    }

    @GetMapping("/findSignById")
    public void findSignById(@RequestParam int id, HttpServletResponse response) throws IOException {
        String result = iSignService.findSignById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

}
