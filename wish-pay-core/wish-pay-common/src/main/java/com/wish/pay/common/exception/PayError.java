package com.wish.pay.common.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 支付错误码说明
 *
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/2/27 14:49
 */

public class PayError implements Serializable {

    private int errorCode;

    private String errorMsg;

    private JSONObject json;

    private String responseContent;

    public PayError() {
    }

    public PayError(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public PayError(int errorCode, String errorMsg, String responseContent) {
        this(errorCode, errorMsg);
        this.responseContent = responseContent;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public static PayError fromJson(String json) {

        JSONObject jsonObject = JSON.parseObject(json);
        PayError error = jsonObject.toJavaObject(PayError.class);
        error.setJson(jsonObject);
        error.setResponseContent(json);
        return error;
    }

    @Override
    public String toString() {
        return "支付错误: errcode=" + errorCode + ", errmsg=" + errorMsg + "\njson:" + json;
    }

}
