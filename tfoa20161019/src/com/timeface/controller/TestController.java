package com.timeface.controller;

import com.timeface.model.baseRes.FixedAssetInfo;
import com.timeface.service.baseRes.FixedAssetService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Administrator on 2016/9/29.
 */
@Controller
@RequestMapping("test")
public class TestController extends _BaseController{

    @Autowired
    private FixedAssetService mtService;

    private static final Logger logger = Logger.getRootLogger();

    @RequestMapping(value = "/login")//,produces = "text/plain;charset=UTF-8"
    @ResponseBody
    public String testLogin() throws Exception{

        FixedAssetInfo fixed = mtService.queryByKey(1L);
        logger.info("日志是这样的 ");
        return object2Json(fixed);
    }
}
