package com.sjx.handlereventbus.eventbus;

/**
 * Created by  sjx  on 2020/7/14
 */
public interface RxCode {

    interface OnWelcomeListener {
        int REQUEST_PERMISSION_SUCCESS = 0x1001;
    }

    interface OnLoginListener {
        int REQUEST_LOGIN_SUCCESS         = 0x1101;
        int REQUEST_LOGIN_ERROR           = 0x1102;
        int REQUEST_CHECK_STATION_SUCCESS = 0x1103;
        int REQUEST_CHECK_STATION_ERROR   = 0x1104;
    }

    interface OnOrderListener {
        int REQUEST_ORDER_SUCCESS = 0x1201;
        int REQUEST_ORDER_ERROR   = 0x1202;
    }

    interface OnAppListener {
        int API_INVALID_TOKEN = 0x1301;
    }
}
