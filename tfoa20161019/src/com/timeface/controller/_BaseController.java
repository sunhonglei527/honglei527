package com.timeface.controller;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2016/10/18.
 */
public class _BaseController {

    public String object2Json(Object object) {
        return JSON.toJSONString(object);
    }
}
