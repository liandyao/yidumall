package com.yidu.product.mapper;

import com.yidu.product.entity.YiduProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface YiduProductMapper {

    List<YiduProduct> selectAll();

    int deleteByPrimaryKey(String proId);

    int insert(YiduProduct record);

    int insertSelective(YiduProduct record);

    YiduProduct selectByPrimaryKey(String proId);

    int updateByPrimaryKeySelective(YiduProduct record);

    int updateByPrimaryKey(YiduProduct record);
}