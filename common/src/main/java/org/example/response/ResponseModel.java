package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.error.ErrorCode;

import java.io.Serializable;

/**
 * 返回结果模型
 * @author LXZ 2024/11/19 16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel<T> implements Serializable {

    /**
     * 错误标识码
     */
    private Integer code;

    /**
     * 子错误编码
     */
    private String errorCode;

    /**
     * 结果
     */
    private T result;


    public static <T> ResponseModel<T> success(T data){
        return new ResponseModel<T>(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getValue(),data);
    }

    public boolean isSuccess(){
        return ErrorCode.SUCCESS.getCode() == this.code ;
    }


}
