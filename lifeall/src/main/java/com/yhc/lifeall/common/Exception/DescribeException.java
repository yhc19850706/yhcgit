package com.yhc.lifeall.common.Exception;

import com.yhc.lifeall.common.enums.ExceptionEnum;

/**
 * 一般系统抛出的错误是不含错误代码的，除去部分的404，400，500错误之外，
 * 我们如果想把错误代码定义的更细致，就需要自己继承RuntimeException这个
 * 类后重新定义一个构造方法来定义我们自己的错误信息
 */
public class DescribeException extends RuntimeException{

    private Integer code;

    /**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public DescribeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}