package com.yidu.order.mapper;

import com.yidu.order.entity.YiduOrders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YiduOrdersMapper {
    int deleteByPrimaryKey(String ordersId);

    int insert(YiduOrders record);

    int insertSelective(YiduOrders record);

    YiduOrders selectByPrimaryKey(String ordersId);

    int updateByPrimaryKeySelective(YiduOrders record);

    int updateByPrimaryKey(YiduOrders record);
}