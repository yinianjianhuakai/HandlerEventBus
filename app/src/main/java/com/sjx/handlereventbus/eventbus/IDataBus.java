package com.sjx.handlereventbus.eventbus;

/**
 * 数据事件总线抽象
 */
public interface IDataBus {
    void register(OnRxEventListener subscriber);

    void unRegister(OnRxEventListener subscriber);

    void send(RxData data);

    void send(RxData data, String targetName);
}
