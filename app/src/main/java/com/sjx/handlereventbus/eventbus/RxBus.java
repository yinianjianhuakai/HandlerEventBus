package com.sjx.handlereventbus.eventbus;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * RxBus.getInstance().send(new RxData(RxCode.code), MainActivity.class.getName());
 */
public class RxBus implements IDataBus {
    private static final int                            ACTION_QUEUE_MESSAGE = 0x1001;
    private static       RxBus                          instance;
    private              Map<String, OnRxEventListener> subscribers;
    private              Context                        mContext;

    private Handler mHandler;

    private RxBus() {
        subscribers = new HashMap<>();
    }

    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    public void init(Context mContext) {
        this.mContext = mContext;
        mHandler = new Handler(mContext.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case ACTION_QUEUE_MESSAGE:
                        handlerMessage((RxData) msg.obj);
                        break;
                }
            }
        };
    }

    @Override
    public void register(OnRxEventListener subscriber) {
        subscribers.put(subscriber.getClass().getName(), subscriber);
    }

    @Override
    public void unRegister(OnRxEventListener subscriber) {
        subscribers.remove(subscriber.getClass().getName());
    }

    @Override
    public void send(RxData data) {
        Message msg = Message.obtain();
        msg.obj = data;
        msg.what = ACTION_QUEUE_MESSAGE;
        mHandler.sendMessage(msg);
    }

    @Override
    public void send(final RxData data, final String targetName) {
        data.setTargetName(targetName);
        send(data);
    }

    private void handlerMessage(RxData data) {
        if (data == null)
            return;
        String targetName = data.getTargetName();
        if (targetName != null) {
            if (subscribers.containsKey(targetName)) {
                Log.d("=T=RxBus", "send: " + targetName);
                callMethodByAnnotation(subscribers.get(targetName), data);
            }
        } else {
            for (Map.Entry<String, OnRxEventListener> entry : subscribers.entrySet()) {
                callMethodByAnnotation(entry.getValue(), data);
            }
        }
    }

    private void callMethodByAnnotation(OnRxEventListener target, RxData data) {
        target.onRxEvent(data);
    }

}

