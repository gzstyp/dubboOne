package com.debug.mooc.dubbo.one.api.enums;

/**
 * 通用的状态码
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-21 14:42
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
public enum StatusCode{

    Success(0,"操作成功"),
    Fail(-1,"操作失败"),
    InvalidParams(200,"无效的参数"),
    ItemNotExist(201,"商品不存在");

    private Integer code;

    private String msg;

    StatusCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}