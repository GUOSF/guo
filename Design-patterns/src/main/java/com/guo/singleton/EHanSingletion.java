package com.guo.singleton;

import java.io.Serializable;

/**
 * @author gsf
 * @date 2020/6/13 00:52
 */
public class EHanSingletion implements Serializable {
    public final static  EHanSingletion sing = new EHanSingletion();

    private EHanSingletion() {
    }

    public static EHanSingletion getInstance() {
        return sing;
    }
    private Object readResolve(){ return sing;}

}
