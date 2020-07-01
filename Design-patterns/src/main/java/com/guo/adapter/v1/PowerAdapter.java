package com.guo.adapter.v1;

/**
 * @author gsf
 * @date 2020/6/26 10:13
 */
public class PowerAdapter extends AC220 implements DC5 {
    public int outPut5() {
        int adapterInput = outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }
}
