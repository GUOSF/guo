package com.guo.singleton;

/**
 * @author gsf
 * @date 2020/6/14 12:00
 */
public class ThreadLocalSing {
    private static final ThreadLocal<ThreadLocalSing> loc = new ThreadLocal<ThreadLocalSing>() {
        @Override
        protected ThreadLocalSing initialValue() {
            return new ThreadLocalSing();
        }
    };

    private ThreadLocalSing() {
    }

    public static ThreadLocalSing getInstance() {
        return loc.get();
    }

}
