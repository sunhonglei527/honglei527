package com.timeface.service.baseRes;

import com.timeface.model.baseRes.FixedAssetInfo;
import com.timeface.model.baseRes.ResCategory;

import java.util.List;

/**
 * Created by timeface on 2016/9/30.
 */
public interface FixedAssetService {

    /**
     * 新增物品信息
     * @param info
     */
    void insertFixtInfo(FixedAssetInfo info);

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    FixedAssetInfo queryByKey(Long id);


    /**
     * 新增物品分类
     * @param res
     * @return
     */
    int saveResCategory(ResCategory res);

    /**
     * 固定资产分类列表
     * @return
     */
    List<ResCategory> fixedTypeList();
}
