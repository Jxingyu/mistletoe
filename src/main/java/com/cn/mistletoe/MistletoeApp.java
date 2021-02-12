package com.cn.mistletoe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.cn.mistletoe.mapper")
// SpringBoot使@WebServlet注解生效，需要在启动类中添加servlet路径扫描：例子@ServletComponentScan("com.xx.xx....") 验证码工具路径
@ServletComponentScan("com.cn.mistletoe.common")
@EnableTransactionManagement
public class MistletoeApp {
    public static void main(String[] args) {
        SpringApplication.run(MistletoeApp.class,args);
    }
}
