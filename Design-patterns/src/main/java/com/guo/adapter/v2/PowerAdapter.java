package com.guo.adapter.v2;

/**
 * @author gsf
 * @date 2020/6/26 10:23
 */
public class PowerAdapter implements DC {
    private DC dc;

    public PowerAdapter(DC dc) {
        this.dc = dc;
    }

    public int outPut5v() {
        return dc.outPut5v() / 44;
    }

    public int outPut10v() {
        return 0;
    }

    public int outPut20v() {
        return 0;
    }
}
