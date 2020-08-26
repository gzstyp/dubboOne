package com.debug.mooc.dubbo.one.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单实体
 * @注意 本实体的字段要与需要调用的字段要一致,否则会报错:org.codehaus.jackson.map.exc.UnrecognizedPropertyException: Unrecognized field &quot;itemTotal&quot; 未知的字段
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-22 2:55
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@Data
public class PushOrderDto implements Serializable{

    /**商品id*/
    private Integer itemId;
    /**商品数量*/
    private Integer total = 1;
    /**客户姓名*/
    private String customerName;

    public Integer getItemId(){
        return itemId;
    }

    public void setItemId(Integer itemId){
        this.itemId = itemId;
    }

    public Integer getTotal(){
        return total;
    }

    public void setTotal(Integer total){
        this.total = total;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
}