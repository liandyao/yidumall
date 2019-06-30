package com.yidu.order.service;

import com.yidu.order.entity.YiduOrders;

/**
 * 订单服务接口
 */
public interface YiduOrdersService {

    /**
     * 根据订单id查询订单
     * @param ordersId
     * @return
     */
    YiduOrders findById(String ordersId);

    /**
     * 添加订单
     * @param orders
     * @return
     */
    boolean addOrders(YiduOrders orders);
}
