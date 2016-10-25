package com.timeface.model;

import com.timeface.model.constant.FinalCodeVal;

/**
 * Created by Administrator on 2016/10/19.
 */
public class OperResultDto {
    protected String status = FinalCodeVal.MODULE_COMMONOBJ_STATUS_OK;
    protected String info = FinalCodeVal.MODULE_COMMONOBJ_INFO_OK;
    protected int errorCode = FinalCodeVal.MODULE_COMMONOBJ_ERRORCODE;

    public OperResultDto() {

    }

    public OperResultDto(String status, String info) {
        super();
        this.status = status;
        this.info = info;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
