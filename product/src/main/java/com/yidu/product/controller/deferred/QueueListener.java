package com.yidu.product.controller.deferred;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 队列的监听器
 * ContextRefreshedEvent这个事件就是整个spring初始化完毕的一个事件
 * 监听这个事件就相当于“当系统整个启动起来之后我要做什么事情（监听消息队列里面的completeOrder中的值）”
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private OrderQueue orderQueue;
    @Resource
    private DeferredResultHolder deferredResultHolder;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //因为是一个无限循环，所以需要单开一个线程
        new Thread(() -> {
            while (true){
                //当模拟的这个队列中订单完成的这个字段有值了，不为空
                if (!StringUtils.isEmpty(orderQueue.getCompleteOrder())){
                    String orderNum = orderQueue.getCompleteOrder();
                    logger.info("监听线程,返回订单处理结果："+orderNum);
                    //当调用setResult方法的时候就意味着整个订单处理的业务完成了，该去返回结果了
                    deferredResultHolder.getMap().get(orderNum).setResult("订单处理完成");
                    //处理完成之后,将队列中的complete清空
                    orderQueue.setCompleteOrder(null);
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
