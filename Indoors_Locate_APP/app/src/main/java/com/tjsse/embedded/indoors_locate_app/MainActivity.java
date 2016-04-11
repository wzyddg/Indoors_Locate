package com.tjsse.embedded.indoors_locate_app;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
   private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化Bmob功能
        Bmob.initialize(this,"81b6659004fd776087a92c7b2dfe30d9");
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
                    try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
                }
            }
        });
        t.start();
    }
    //获得wifi信息 设备名和信号强度 scanResult.SSID\level
    public  void scanWifiInfo(){
        WifiMsg wifiMsg = new WifiMsg();
     //   String wifi_ssid="null";
     //   String wifi_level="null";
        String wserviceName = Context.WIFI_SERVICE;
        WifiManager wm = (WifiManager) getSystemService(wserviceName);
        //startScan非常重要
        wm.startScan();
        List<ScanResult> results = wm.getScanResults();
        StringBuilder scanBuilder= new StringBuilder();
        wifiMsg.setLevel("123");
        wifiMsg.setSsid("12322");
        for (ScanResult scanResult : results) {
            //在这里改变要获得的SSID 的动态wifi强度
            if(scanResult.SSID.equals("door")||scanResult.SSID.equals("window")||scanResult.SSID.equals("left of desk")||scanResult.SSID.equals("right of desk")){
            wifiMsg.setSsid(scanResult.SSID);
            wifiMsg.setLevel(Integer.toString(WifiManager.calculateSignalLevel(scanResult.level, 1000)));
            wifiMsg.save(this, new SaveListener() {
                @Override
                public void onSuccess() {
                    // TODO Auto-generated method stub
                    //  toast("添加数据成功，返回objectId为："+p2.getObjectId());
                    System.out.println("添加数据成功！");
                }

                @Override


                public void onFailure(int code, String msg) {
                    // TODO Auto-generated method stub
                    //    toast("创建数据失败：" + msg)njm
                     System.out.println("添加数据失败！");
                }
            });}
            if(scanResult.SSID.equals("door")||scanResult.SSID.equals("window")||scanResult.SSID.equals("left of desk")||scanResult.SSID.equals("right of desk")){
            scanBuilder.append("\n设备名：" + scanResult.SSID
                    + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1000) + "\n");}

        }
        textView.setText(scanBuilder);
   //     return wifi_ssid;
    }
}