package com.debug.mooc.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.debug.mooc.dubbo.one.api.enums.StatusCode;
import com.debug.mooc.dubbo.one.api.request.PushOrderDto;
import com.debug.mooc.dubbo.one.api.response.BaseResponse;
import com.debug.mooc.dubbo.one.api.service.IDubboRecordService;

import com.debug.mooc.dubbo.one.model.entity.OrderRecord;
import com.debug.mooc.dubbo.one.model.mapper.OrderRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 发布注册中心的用户下单,基于rest的http请求协议
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-22 3:02
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 3000)
@Path("orderRecord")
public class DubboRecordService implements IDubboRecordService{

    private static final Logger Log = LoggerFactory.getLogger(DubboRecordService.class);

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    /**
     * 用户下单服务,基于rest的http请求协议,其中的v1是配置文件spring-dubbo.xml的contextpath="v1" 值,其url的含义是当前类的Path的值/本方法的Path值
     * url : http://127.0.0.1:9013/v1/orderRecord/pushOrder
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019年3月22日 03:08:41
    */
    @Override
    @Path("/pushOrder")
    @POST//下单嘛肯定的POST请求,基于http协议
    @Consumes(value = MediaType.APPLICATION_JSON)//JSON格式,是需要被消费,基于http协议
    @Produces(value = MediaType.APPLICATION_JSON)//异步处理,Produces是响应,基于http协议
    public BaseResponse pushOrder(final PushOrderDto dto){
        if(dto.getItemId() == null || dto.getItemId() == null){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //处理业务逻辑,这里简单的处理
            final OrderRecord entity = new OrderRecord();
            BeanUtils.copyProperties(dto,entity);
            final int rows = orderRecordMapper.insertSelective(entity);
            if(rows <= 0){
                response = new BaseResponse(199,"购买失败!");
                response.setData(entity.getId());//获取主键
            }
        } catch (Exception e) {
            Log.error("用户下单服务,基于rest的http请求协议{}出异常",e.getMessage());
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    /**
     * 用户下单服务,基于rest的http请求协议,其中的v1是配置文件spring-dubbo.xml的contextpath="v1" 值,其url的含义是当前类的Path的值/本方法的Path值,方法上的注解Path不支持多态,方法名可以支持多态!
     * url : http://127.0.0.1:9013/v1/orderRecord/pushOrder2
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019年3月22日 03:08:41
     */
    @Override
    @Path("/pushOrder2")//注解Path不支持多态,方法名可以支持多态
    @POST//下单嘛肯定的POST请求,基于http协议
    @Consumes(value = MediaType.APPLICATION_JSON)//JSON格式,是需要被消费,基于http协议
    @Produces(value = MediaType.APPLICATION_JSON)//异步处理,Produces是响应,基于http协议
    public BaseResponse pushOrder(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //处理业务逻辑,这里简单的处理
            final OrderRecord entity = new OrderRecord();
            entity.setItemId(5);
            entity.setTotal(2);
            entity.setCustomerName("田卓智");
            final int rows = orderRecordMapper.insertSelective(entity);
            if(rows <= 0){
                response = new BaseResponse(199,"购买失败!");
                response.setData(entity.getId());//获取主键
            }
        } catch (Exception e) {
            Log.error("用户下单服务,基于rest的http请求协议{}出异常",e.getMessage());
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }
}