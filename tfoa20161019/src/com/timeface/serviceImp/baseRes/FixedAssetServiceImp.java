package com.timeface.serviceImp.baseRes;

import com.timeface.mapper.baseRes.FixedAssetInfoMapper;
import com.timeface.mapper.baseRes.ResCategoryMapper;
import com.timeface.model.baseRes.FixedAssetInfo;
import com.timeface.model.baseRes.ResCategory;
import com.timeface.service.baseRes.FixedAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by timeface on 2016/9/30.
 */
@Service
public class FixedAssetServiceImp implements FixedAssetService {

    @Autowired
    private FixedAssetInfoMapper fixedMapper;

    @Autowired
    private ResCategoryMapper categoryMapper;

    @Override
    public void insertFixtInfo(FixedAssetInfo info) {
        try {
            fixedMapper.insertSelective(info);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取固定资产数据
     * @param id
     * @return
     */
    @Override
    public FixedAssetInfo queryByKey(Long id) {
       return fixedMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增物品类别
     * @param res
     * @return
     */
    @Override
    public int saveResCategory(ResCategory res) {
        if (res!=null){
            return categoryMapper.insertSelective(res);
        }else {
            return 0;
        }
    }

    @Override
    public List<ResCategory> fixedTypeList() {
        return categoryMapper.categoryList();
    }
}
