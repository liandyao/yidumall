package com.yidu.product.controller;

import com.yidu.product.controller.deferred.DeferredResultHolder;
import com.yidu.product.controller.deferred.OrderQueue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * 订单处理
 */
@Api(description = "Restful风格的订单接口")
@RestController
public class YiduOrderController {

    public  Logger logger = LoggerFactory.getLogger(YiduOrderController.class);

    /**
     * 普通的下单方法
     * @param id
     * @return
     * @throws InterruptedException
     */
    @ApiOperation("普通的订单处理方式")
    @PostMapping("order/{id}")
    public String order(@PathVariable String id) throws InterruptedException {
        logger.info(id+"开始下单,主线程开始");
        Thread.sleep(1000);
        logger.info(id+"订单处理完毕,主线程返回");
        return "success";
    }

    /**
     * 使用多线程处理,增加了主线程的业务处理能力
     * @param id
     * @return
     */
    @ApiOperation("Callable多线程的订单处理方式")
    @PostMapping("callable/{id}")
    public Callable<String> orderCallable(@PathVariable String id){
        logger.info("主线程开始");
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info(id+"开始下单,子线程开始!");
                Thread.sleep(1000);
                logger.info(id+"订单处理完毕,子线程返回");
                return "success";
            }
        };
        logger.info("主线程结束");
        return callable;
    }

    @Resource
    private OrderQueue orderQueue;
    @Resource
    private DeferredResultHolder deferredResultHolder;
    /**
     * 使用DeferredResult异步处理订单,可分布式部署和开发
     * @param id
     * @return
     */
    @ApiOperation("DeferredResult异步处理订单处理方式")
    @PostMapping("deferred/{id}")
    public DeferredResult<String> deferred(@PathVariable String id) throws InterruptedException {
        logger.info("主线程开始了");
        String orderId = UUID.randomUUID().toString();//随机生成一个订单号
        //模拟加入了一个订单,加入到消息队列里面去
        orderQueue.setPlaceOrder(orderId);

        DeferredResult<String> result = new DeferredResult<String>();

        deferredResultHolder.getMap().put(orderId,result);

        logger.info("主线程结束了");
        return result ;
    }
}
