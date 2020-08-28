package com.sjx.handlereventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.sjx.handlereventbus.eventbus.OnRxEventListener;
import com.sjx.handlereventbus.eventbus.RxBus;
import com.sjx.handlereventbus.eventbus.RxCode;
import com.sjx.handlereventbus.eventbus.RxData;

public class MainActivity extends AppCompatActivity implements OnRxEventListener,
                                                               View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxBus.getInstance().init(this);
        RxBus.getInstance().register(this);

        findViewById(R.id.tv_click).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.tv_click:
//                RxBus.getInstance().send(new RxData(RxCode.OnWelcomeListener.REQUEST_PERMISSION_SUCCESS));
//                break;
//        }
    }

    @Override
    public void onRxEvent(RxData event) {
        switch (event.getEventCode()){
            case RxCode.OnWelcomeListener.REQUEST_PERMISSION_SUCCESS:
                Toast.makeText(this, "receive data...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    protected void onDestroy() {
        RxBus.getInstance().unRegister(this);
        super.onDestroy();
    }
}
