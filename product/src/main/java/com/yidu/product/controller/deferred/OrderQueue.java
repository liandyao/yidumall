package com.yidu.product.controller.deferred;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 消息队列模拟类
 */
@Component
public class OrderQueue {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 下单的消息
     * 当这个字符串有值的时候就认为接到了一个下单的消息
     */
    private String placeOrder;
    /**
     * 订单完成的消息
     * 当这个字符串有值的时候就认为订单处理完成
     */
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    /**
     * 在收到下单请求之后休息一秒，然后相当于处理完成
     * @param placeOrder
     * @throws InterruptedException
     */
    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() -> {
            logger.info("队列,接到下单请求，"+placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //订单处理完成
            this.completeOrder = placeOrder;
            logger.info("队列,下单请求处理完成，"+placeOrder);
        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
