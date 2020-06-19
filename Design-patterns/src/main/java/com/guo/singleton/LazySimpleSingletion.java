package com.guo.singleton;

/**
 * @author gsf
 * @date 2020/6/13 00:53
 */
public class LazySimpleSingletion {
    private static LazySimpleSingletion instance;
    private LazySimpleSingletion(){}

    public synchronized static LazySimpleSingletion getInstance(){
        if(instance == null){
            instance = new LazySimpleSingletion();
        }
        return instance;
    }
}
