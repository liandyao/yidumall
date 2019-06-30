package com.yidu.order.controller;

import com.yidu.order.entity.YiduOrders;
import com.yidu.order.service.YiduOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(description = "Restful风格的订单接口")
@RestController
public class YiduOrdersController {

    @Resource
    YiduOrdersService yiduOrdersService;
    /**
     * 根据ID查询商品信息
     *这里用的是路径变量，就是{}括起来的，会当做变量读进来
     * @param id 根据路径传入的id
     */
    @ApiOperation("根据订单ID获取商品订单详情")
    @RequestMapping(method = RequestMethod.GET,value = "/order/{id}")
    public YiduOrders getYiduProduct(@PathVariable String id) {
        return yiduOrdersService.findById(id);
    }

    @ApiOperation("根据订单ID获取商品订单详情")
    @RequestMapping(method = RequestMethod.POST,value = "/order")
    public boolean addOrders(@RequestBody YiduOrders orders) {
        return yiduOrdersService.addOrders(orders);
    }

}
