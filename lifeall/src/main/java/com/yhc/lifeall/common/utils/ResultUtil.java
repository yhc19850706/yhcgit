package com.yhc.lifeall.common.utils;

import com.yhc.lifeall.common.enums.ExceptionEnum;

import java.io.Serializable;

public class ResultUtil implements Serializable{



    /**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
    public static ResultInfo success(Object object){
        ResultInfo result = new ResultInfo();
        result.setStatus(200);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static ResultInfo success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static ResultInfo error(Integer code,String msg){
        ResultInfo result = new ResultInfo();
        result.setStatus(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    public static ResultInfo error(ExceptionEnum exceptionEnum){
        ResultInfo result = new ResultInfo();
        result.setStatus(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
}
