package com.sjx.handlereventbus.eventbus;

/**
 * Created by  sjx  on 2020/7/14
 */
public class RxData {
    /**
     * {@link RxCode}
     */
    private int    eventCode = -1;
    private String targetName;
    private Object obj1;
    private Object obj2;
    private Object obj3;

    public RxData() {

    }

    public RxData(int eventCode) {
        this.eventCode = eventCode;
    }

    public RxData(int eventCode, String targetName) {
        this.eventCode = eventCode;
        this.targetName = targetName;
    }

    public RxData(int eventCode, String targetName, Object obj1) {
        this.eventCode = eventCode;
        this.targetName = targetName;
        this.obj1 = obj1;
    }

    public RxData(int eventCode, String targetName, Object obj1, Object obj2) {
        this.eventCode = eventCode;
        this.targetName = targetName;
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public RxData(int eventCode, String targetName, Object obj1, Object obj2, Object obj3) {
        this.eventCode = eventCode;
        this.targetName = targetName;
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    public RxData(int eventCode, Object obj1) {
        this.eventCode = eventCode;
        this.obj1 = obj1;
    }

    public RxData(int eventCode, Object obj1, Object obj2) {
        this.eventCode = eventCode;
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public RxData(int eventCode, Object obj1, Object obj2, Object obj3) {
        this.eventCode = eventCode;
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    public RxData setEventCode(int eventCode) {
        this.eventCode = eventCode;
        return this;
    }

    public RxData setObj1(Object obj1) {
        this.obj1 = obj1;
        return this;
    }

    public RxData setObj2(Object obj2) {
        this.obj2 = obj2;
        return this;
    }

    public RxData setObj3(Object obj3) {
        this.obj3 = obj3;
        return this;
    }

    public int getEventCode() {
        return eventCode;
    }

    public String getTargetName() {
        return targetName;
    }

    public RxData setTargetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public Object getObj1() {
        return obj1;
    }

    public Object getObj2() {
        return obj2;
    }

    public Object getObj3() {
        return obj3;
    }

}
