package com.debug.mooc.dubbo.one.api.service;

import com.debug.mooc.dubbo.one.api.response.BaseResponse;

/**
 * 面向对象接口服务,它的实现类在server子模块下实现,基于dubbo的rpc协议
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019年3月21日 16:36:55
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
public interface IDubboItemService {

    //查询的列表功能
    BaseResponse listItems();//基于dubbo的rpc协议实现

    BaseResponse listPageItems();

}