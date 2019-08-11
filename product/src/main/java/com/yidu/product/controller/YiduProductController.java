package com.yidu.product.controller;

import com.yidu.product.entity.YiduProduct;
import com.yidu.product.service.YiduProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.List;
@Api(description = "Restful风格的商品接口")
@RestController //springMVC提供的Rest注解
public class YiduProductController {

    public static Logger logger = LoggerFactory.getLogger(YiduProductController.class);

    @Resource
    YiduProductService yiduProductService;

    @Resource
    YmlConfigBean ymlConfigBean ;

    /**
     * 查询所有的商品信息
     * 依据Rest风格规则,路径中不要使用动词.例如/products,不要写成getProducts
     * @return
     */
    @ApiOperation(value = "查询所有的商品信息" ,  notes="所有的商品信息返回")
    @RequestMapping(method = RequestMethod.GET,value = "/products")
    //@GetMapping("/products") 此种方式也可以
    public List<YiduProduct> selectAll(){
        return yiduProductService.selectAll();
    }

    /**
     * 根据ID查询商品信息
     *这里用的是路径变量，就是{}括起来的，会当做变量读进来
     * @param id 根据路径传入的id
     */
    @ApiOperation("根据ID获取商品详情")
    @RequestMapping(method = RequestMethod.GET,value = "/product/{id}")
    public YiduProduct getYiduProduct(@PathVariable String id) {
        return yiduProductService.selectByPrimaryKey(id);
    }

    /**
     * 保存商品
     * @param yiduProduct RequestBody这个注解可以接收json数据
     * @return 是否保存成功
     */
    @ApiOperation("新增商品")
    @RequestMapping(method = RequestMethod.POST,value = "/product")
    //@PostMapping("/product") 此种方式也可以
    public boolean insert(@RequestBody YiduProduct yiduProduct){
        return yiduProductService.insert(yiduProduct)>0 ;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @ApiOperation("删除商品")
    @RequestMapping(method = RequestMethod.DELETE,value = "/product/{id}")
   //@DeleteMapping("/product/{id}") 此种方式也可以
    public boolean delete(@PathVariable String id){
        return yiduProductService.deleteByPrimaryKey(id)>0;
    }

    /**
     * 修改商品
     * @param yiduProduct RequestBody这个注解可以接收json数据
     * @return
     */
    @ApiOperation("修改商品")
    @RequestMapping(method = RequestMethod.PUT,value = "/product")
    //@PutMapping("/product") 此种方式也可以
    public boolean update(@RequestBody  YiduProduct yiduProduct){
        return yiduProductService.updateByPrimaryKey(yiduProduct)>0;
    }

    /**
     * 获取git的config信息
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getYml")
    public String getConifg(){
        return ymlConfigBean.toString();
    }

}
