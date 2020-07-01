package com.guo.bridge;

/**
 * @author gsf
 * @date 2020/6/26 13:14
 */
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}
