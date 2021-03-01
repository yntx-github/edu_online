package com.yntx.handler;

import com.yntx.common.base.result.ResultCodeEnum;
import lombok.Data;

@Data
public class CustomException extends RuntimeException {

    private Integer code;

    //接收状态码和信息
    public CustomException(Integer code,String message){
        super(message);
        this.code = code;
    }

    //接收枚举类型
    public CustomException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
