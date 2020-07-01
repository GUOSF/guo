package com.guo.bridge;

/**
 * @author gsf
 * @date 2020/6/26 14:06
 */

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
