package com.debug.mooc.dubbo.one.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019年3月21日 05:15:00
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring-jdbc.xml","classpath:spring/spring-dubbo.xml"})
@MapperScan(basePackages = "com.debug.mooc.dubbo.one.model.mapper")
@ComponentScan({"com.debug.mooc.dubbo.one"})
public class Launch extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Launch.class);
    }

    public static void main(String[] args){
        SpringApplication.run(Launch.class,args);
        System.out.println("应用启动成功");
    }
}