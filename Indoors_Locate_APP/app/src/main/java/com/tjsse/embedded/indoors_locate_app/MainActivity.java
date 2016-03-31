package com.tjsse.embedded.indoors_locate_app;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册textViw并实现滚动
        textView=(TextView)findViewById(R.id.textView);
        assert textView != null;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        //启动线程，实时获取wifi信息
        scanWifiInfo();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            scanWifiInfo();
                        }
                    });
                    try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
                }
            }
        });
        t.start();
    }
    //获得wifi信息 设备名和信号强度 scanResult.SSID\level
    public void scanWifiInfo(){
        String wserviceName = Context.WIFI_SERVICE;
        WifiManager wm = (WifiManager) getSystemService(wserviceName);
        //startScan非常重要
        wm.startScan();
        List<ScanResult> results = wm.getScanResults();
        StringBuilder scanBuilder= new StringBuilder();
        for (ScanResult scanResult : results) {
            scanBuilder.append("\n设备名：" + scanResult.SSID
                    + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1001) + "\n");
        }
        textView.setText(scanBuilder);
    }
}