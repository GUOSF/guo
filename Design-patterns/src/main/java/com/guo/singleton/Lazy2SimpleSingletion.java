package com.guo.singleton;

/**
 * @author gsf
 * @date 2020/6/13 00:53
 */
public class Lazy2SimpleSingletion {

    private Lazy2SimpleSingletion() {
        // 会出现反射破坏
    }

    private static class LazeSingleton {
        private static final Lazy2SimpleSingletion instance = new Lazy2SimpleSingletion();
    }

    public synchronized static Lazy2SimpleSingletion getInstance() {
        return LazeSingleton.instance;
    }
}
