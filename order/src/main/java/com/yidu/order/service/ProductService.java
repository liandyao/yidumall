package com.yidu.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yidu.order.entity.YiduProduct;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品服务类
 */
@Service
public class ProductService {

    @Resource
    private ProductFeignClient productFeignClient; //注解得到FeignClient

    /**
     * 得到商品对象.并且加入容错机制
     * @param proId
     * @return
     */
    @HystrixCommand(fallbackMethod = "findByIdBak")
    public YiduProduct findById(String proId){
        return productFeignClient.findById(proId);
    }


    /**
     * 容错处理
     * @param proId
     * @return
     */
    public YiduProduct findByIdBak(String proId){
        YiduProduct product = new YiduProduct();
        product.setProName("商品微服务出错");
        return product;
    }


}
