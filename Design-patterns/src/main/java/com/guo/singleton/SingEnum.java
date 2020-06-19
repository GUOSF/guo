package com.guo.singleton;

/**
 * @author gsf
 * @date 2020/6/14 11:50
 */
public enum SingEnum  implements Cloneable{
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static SingEnum getInstance() {
        return INSTANCE;
    }
}
