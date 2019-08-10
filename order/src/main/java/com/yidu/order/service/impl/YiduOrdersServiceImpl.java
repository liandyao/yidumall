package com.yidu.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yidu.order.entity.YiduOrders;
import com.yidu.order.entity.YiduProduct;
import com.yidu.order.mapper.YiduOrdersMapper;
import com.yidu.order.service.ProductService;
import com.yidu.order.service.YiduOrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务实现类
 */
@Service
public class YiduOrdersServiceImpl implements YiduOrdersService {
    public  Logger logger = LoggerFactory.getLogger(YiduOrdersServiceImpl.class);

    @Resource
    YiduOrdersMapper mapper ;

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Resource
    private RestTemplate restTemplate;

    //discoveryClient是SpringCloud提供的Eureka注册中心的核心对象,使用这个对象可以发现注册中心提供的微服务
    @Resource
    private DiscoveryClient discoveryClient;


    /**
     * 根据订单id查询订单
     *
     * @param ordersId
     * @return
     */
    /*
    @Override
    public YiduOrders findById(String ordersId) {
        YiduOrders yiduOrders = mapper.selectByPrimaryKey(ordersId);
        //这里得到的id是商品的id,而实际业务中,我们需要得到商品的相关信息
        String proId = yiduOrders.getProId();

        //这里开始使用SpringCloud提供的分布式微服务查询商品的信息
        String serviceId = "yidu_product_microService";
        List<ServiceInstance> serviceList = discoveryClient.getInstances(serviceId);
        if(serviceList.isEmpty()){
            logger.info("找不到微服务,请确认Eureka服务中心是否已经注册yidu_product_microService");
        }
        // 为了演示，在这里只获取一个实例
        ServiceInstance serviceInstance = serviceList.get(0);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        logger.info("得到的注册中心的地址是:"+url);
        String path = "http://"+url+"/yidu/product/"+proId;
        logger.info("得到的注册中心的地址是:"+url+"     "+path);
        YiduProduct yiduProduct = restTemplate.getForObject(path, YiduProduct.class);
        //将查询出来商品信息的结果设置到订单中
        yiduOrders.setProduct(yiduProduct);
        return yiduOrders;
    }
    */

    /*
    @Override
    public YiduOrders findById(String ordersId) {
        YiduOrders yiduOrders = mapper.selectByPrimaryKey(ordersId);
        //这里得到的id是商品的id,而实际业务中,我们需要得到商品的相关信息
        String proId = yiduOrders.getProId();

        //这里开始使用SpringCloud提供的分布式微服务查询商品的信息
        String serviceId = "yidu-product-microService";
        String path = "http://"+serviceId+"/yidu/product/"+proId;
        logger.info("得到的注册中心的地址是:     "+path);
        YiduProduct yiduProduct = restTemplate.getForObject(path, YiduProduct.class);
        //将查询出来商品信息的结果设置到订单中
        yiduOrders.setProduct(yiduProduct);
        return yiduOrders;
    }
    */

    /*
    @Override
    @HystrixCommand(fallbackMethod = "findProductByIdBak" )
    public YiduOrders findById(String ordersId) {
        YiduOrders yiduOrders = mapper.selectByPrimaryKey(ordersId);
        //这里得到的id是商品的id,而实际业务中,我们需要得到商品的相关信息
        String proId = yiduOrders.getProId();

        //这里开始使用SpringCloud提供的分布式微服务查询商品的信息
        String serviceId = "yidu-product-microService";
        String path = "http://"+serviceId+"/yidu/product/"+proId;
        logger.info("得到的注册中心的地址是:     "+path);
        YiduProduct yiduProduct = restTemplate.getForObject(path, YiduProduct.class);
        //将查询出来商品信息的结果设置到订单中
        yiduOrders.setProduct(yiduProduct);
        return yiduOrders;
    }

    */


    /**
     * 请求失败执行的方法
     * @param proId
     * @return
     */
     /*
    public YiduOrders findProductByIdBak(String proId){
        YiduOrders yiduOrders = new YiduOrders();
        yiduOrders.setOper("商品不存在!");
        return yiduOrders;
    }
    */


     @Resource
     ProductService productService; //调用使用了Feign客户端的服务类

    @Override
    public YiduOrders findById(String ordersId) {
        YiduOrders yiduOrders = mapper.selectByPrimaryKey(ordersId);
        //这里得到的id是商品的id,而实际业务中,我们需要得到商品的相关信息
        String proId = yiduOrders.getProId();
        //这里开始使用SpringCloud提供的分布式微服务查询商品的信息
        YiduProduct yiduProduct =  productService.findById(proId);
        //将查询出来商品信息的结果设置到订单中
        yiduOrders.setProduct(yiduProduct);
        return yiduOrders;
    }


    /**
     * 添加订单
     *
     * @param orders
     * @return
     */
    @Override
    public boolean addOrders(YiduOrders orders) {

        return mapper.insert(orders)>0;
    }
}
