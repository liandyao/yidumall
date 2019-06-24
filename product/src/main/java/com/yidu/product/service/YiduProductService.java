package com.yidu.product.service;

import com.yidu.product.entity.YiduProduct;

import java.util.List;

public interface YiduProductService {

    /**
     * 查询所有的商品
     * @return
     */
    List<YiduProduct> selectAll();

    /**
     * 根据ID删除商品
     * @param proId
     * @return
     */
    int deleteByPrimaryKey(String proId);

    /**
     * 添加商品
     * @param record
     * @return
     */
    int insert(YiduProduct record);

    /**
     * 有选择的列添加商品
     * @param record
     * @return
     */
    int insertSelective(YiduProduct record);

    /**
     * 根据主键id查询商品
     * @param proId
     * @return
     */
    YiduProduct selectByPrimaryKey(String proId);

    /**
     * 有选择的列修改商品
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(YiduProduct record);

    /**
     * 根据主键修改商品
     * @param record
     * @return
     */
    int updateByPrimaryKey(YiduProduct record);
}
