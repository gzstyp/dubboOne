package com.debug.mooc.dubbo.one.api.service;

import com.debug.mooc.dubbo.one.api.request.PushOrderDto;
import com.debug.mooc.dubbo.one.api.response.BaseResponse;

/**
 * 用户下单,基于rest的http请求协议
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-22 2:51
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
public interface IDubboRecordService{

    BaseResponse pushOrder(final PushOrderDto dto);//基于rest的http协议实现

    BaseResponse pushOrder();//基于rest的http协议实现,方法上的注解Path不支持多态,方法名可以支持多态!
}