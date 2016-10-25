package com.timeface.controller.baseRes;

import com.timeface.controller._BaseController;
import com.timeface.model.OperResultDto;
import com.timeface.model.baseRes.ResCategory;
import com.timeface.service.baseRes.FixedAssetService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timeface on 2016/10/19.
 * 固定资产Controller
 */
@Controller
@RequestMapping("/fixed")
public class FixedAssetsController extends _BaseController {

    @Autowired
    private FixedAssetService  fixedAssetService;

    private static final Logger logger = Logger.getRootLogger();
    /**
     * 新增固定资产类别
     * @return
     */
    @RequestMapping("/saveFixedType")
    @ResponseBody
    public String saveFixedAssetsType(HttpServletRequest request,ResCategory category){

        OperResultDto res = new OperResultDto();
        try {
            fixedAssetService.saveResCategory(category);
        }catch (Exception e){
            logger.debug(e);
            res.setStatus("0");
            res.setInfo("操作失败");
        }
        return object2Json(res);
    }

    @RequestMapping("/fixedTypeList")
    @ResponseBody
    public String fixedTypeList(){
        OperResultDto resultDto = new OperResultDto();
        List<ResCategory> listType = new ArrayList<>();
        try {
            listType = fixedAssetService.fixedTypeList();
        }catch (Exception e){
            logger.debug(e);
            resultDto.setInfo("操作失败");
            resultDto.setStatus("0");
        }
        return object2Json(listType);
    }

}
