package com.yidu.product.service.impl;

import com.yidu.product.entity.YiduProduct;
import com.yidu.product.mapper.YiduProductMapper;
import com.yidu.product.service.YiduProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YiduProductServiceImpl implements YiduProductService {

    @Resource
    YiduProductMapper mapper;

    /**
     * 查询所有的商品
     *
     * @return
     */
    @Override
    public List<YiduProduct> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 根据ID删除商品
     * @param proId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String proId) {
        return mapper.deleteByPrimaryKey(proId);
    }

    /**
     * 添加商品
     * @param record
     * @return
     */
    @Override
    public int insert(YiduProduct record) {
        return mapper.insert(record);
    }

    /**
     * 有选择的列添加商品
     * @param record
     * @return
     */
    @Override
    public int insertSelective(YiduProduct record) {
        return mapper.insertSelective(record);
    }

    /**
     * 根据主键id查询商品
     * @param proId
     * @return
     */
    @Override
    public YiduProduct selectByPrimaryKey(String proId) {
        return mapper.selectByPrimaryKey(proId);
    }

    /**
     * 有选择的列修改商品
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(YiduProduct record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键修改商品
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(YiduProduct record) {
        return mapper.updateByPrimaryKey(record);
    }
}
