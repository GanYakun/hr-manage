package com.yakun.util;

import org.springframework.stereotype.Component;

@Component
public class Result {
    private Boolean flag;
    private Object data;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", data=" + data +
                '}';
    }
}
