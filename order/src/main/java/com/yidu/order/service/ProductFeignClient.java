package com.yidu.order.service;

import com.yidu.order.entity.YiduProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("yidu-product-microService")
public interface ProductFeignClient {

    /**
     * 得到商品
     * @param proId
     * @return
     */
    @RequestMapping(value = "yidu/product/{proId}",method = RequestMethod.GET)
    public YiduProduct findById(@PathVariable("proId") String proId) ;
}
