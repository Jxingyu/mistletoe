/*
package com.cn.mistletoe.common;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json;charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8085");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        String path = req.getServletPath();
//        System.out.println(path + "path8085");
        */
/* Jedis jedis = new Jedis();*//*

        HttpSession session = req.getSession();

        String username = (String) session.getAttribute("username");

        if (path.startsWith("/back/")) {
            if (username != null) {
                filterChain.doFilter(req, resp);//放行
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("result", "未放行error");
                resp.getWriter().println(jsonObject);
            }
        } else {
            filterChain.doFilter(req, resp);//放行
        }
    }

    @Override
    public void destroy() {

    }
}
*/
