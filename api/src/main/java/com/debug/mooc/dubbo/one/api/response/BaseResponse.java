package com.debug.mooc.dubbo.one.api.response;

import com.debug.mooc.dubbo.one.api.enums.StatusCode;

import java.io.Serializable;

/**
 * 通用的响应模型
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-21 14:36
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
/*因为是多种类型,所以要用泛型*/
public class BaseResponse<T> implements Serializable{

    private Integer code;

    private String msg;

    private T data;

    public Integer getCode(){
        return code;
    }

    public BaseResponse(){
    }

    public BaseResponse(final Integer code,final String msg){
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(final StatusCode statusCode){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public BaseResponse(final Integer code,final String msg,final T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }
}