package com.yakun.util;

import com.yakun.util.MessageUtil.CommonMessageCode;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
public class JsonResult<T> implements Serializable {
    private T data;
    private List<T> dataList;
    //token
    private String token;
    //响应信息
    private String message;
    //相应状态码
    private String code;

    public JsonResult() {
    }

    public JsonResult(String code) {
        this.setCode(code);
    }

    public JsonResult(String code, String message) {
        this(code);
        this.setMessage(message);
    }

    public JsonResult(String code, String message, T data) {
        this(code, message);
        this.setData(data);
    }

    /**
     * 封装国际化message和code
     * @param message 提示信息
     */
    public void setMessageCode (CommonMessageCode message) {
        this.setMessage(message.getMessage());
        this.setCode(message.getCode());
    }
}
