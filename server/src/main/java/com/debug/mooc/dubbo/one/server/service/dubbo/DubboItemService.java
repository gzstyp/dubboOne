package com.debug.mooc.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.debug.mooc.dubbo.one.api.enums.StatusCode;
import com.debug.mooc.dubbo.one.api.response.BaseResponse;
import com.debug.mooc.dubbo.one.api.service.IDubboItemService;
import com.debug.mooc.dubbo.one.model.entity.ItemInfo;
import com.debug.mooc.dubbo.one.model.mapper.ItemInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import java.util.List;

/**
 * 对外提供服务接口的实现类,接口子模块在api模块,在配置文件spring-dubbo.xml里的已指定 <dubbo:annotation package="com.debug.mooc.dubbo.one.server.service.dubbo" />
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-21 16:42
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
/*注解成alibaba的dubbo服务,它包含两大协议,dubbo和rpc,本次使用的是两个协议dubbo和rpc,并指定校验,版本号,超时设置*/
@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 3000)
@Path("moocOne")//用Path来区分不同的服务或实现方法,因为一个接口可能含有多个实现类,即小的上下文,注意不要有相同的值
public class DubboItemService implements IDubboItemService{

    private static final Logger Log = LoggerFactory.getLogger(DubboItemService.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    /**
     * 商品列表查询服务-实际的业务实现逻辑,即在api子模块下发布,而实际实现的是在本子模块server实现逻辑处理,此处使用的是dubbo-rpc协议
     * @param 
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/3/21 16:55
    */
    @Override
    @Path("item/list")//用于区分访问路径,这个值随便写,但是不能同一个小的上下文有相同的值,基于dubbo的rpc协议
    public BaseResponse listItems(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            final List<ItemInfo> itemInfos = itemInfoMapper.selectAll();
            response.setData(itemInfos);
        } catch (Exception e) {
            Log.error("商品列表查询服务-实际的业务实现逻辑{}出异常",e.getMessage());
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    /**
     * 带分页的商品列表查询服务-实际的业务实现逻辑,即在api子模块下发布,而实际实现的是在本子模块server实现逻辑处理
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/3/21 16:55
     */
    @Override
    @Path("item/page/list")//用于区分访问路径
    public BaseResponse listPageItems(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        return response;
    }
}