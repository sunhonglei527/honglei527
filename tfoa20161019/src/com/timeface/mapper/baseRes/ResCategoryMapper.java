package com.timeface.mapper.baseRes;

import com.timeface.model.baseRes.ResCategory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ResCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResCategory record);

    int insertSelective(ResCategory record);

    ResCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResCategory record);

    int updateByPrimaryKey(ResCategory record);

    /**
     * 物品分类列表
     * @return
     */
    List<ResCategory> categoryList();


    List<Map<String,Object>> leftJoinQuery();
}