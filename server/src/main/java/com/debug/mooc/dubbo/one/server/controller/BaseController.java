package com.debug.mooc.dubbo.one.server.controller;

import com.debug.mooc.dubbo.one.api.enums.StatusCode;
import com.debug.mooc.dubbo.one.api.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由器|控制器
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-21 14:49
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@RestController
@RequestMapping("/base")
public class BaseController{

    private static final Logger Log = LoggerFactory.getLogger(BaseController.class);

    /**
     * 测试hello world
     * @param params
     * url http://127.0.0.1:8093/dubboOne/base/one
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/3/21 15:02
    */
    @RequestMapping(value = "/one",method = RequestMethod.GET)
    public BaseResponse one(@RequestParam String params){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        try {
            baseResponse.setData(params);
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse = new BaseResponse(StatusCode.Fail);
        }
        return baseResponse;
    }
}