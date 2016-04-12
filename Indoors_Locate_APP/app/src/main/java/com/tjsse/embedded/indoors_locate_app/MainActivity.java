package com.tjsse.embedded.indoors_locate_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button start;
    private EditText placeIdText;
    private EditText ipText;
    private EditText userText;
    private EditText passwordText;
    private EditText portText;
    private List<WifiMsg> resultList;
    private Thread t;
    private Integer i = 0;
    private Integer placeId = 0;
    private AlertDialog ad;
    Connection connection;
    Statement statement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化Bmob功能
//        Bmob.initialize(this,"81b6659004fd776087a92c7b2dfe30d9");
//        注册textViw并实现滚动
        textView = (TextView) findViewById(R.id.textView);
        placeIdText = (EditText) findViewById(R.id.place_id_text);
        ipText = (EditText) findViewById(R.id.ip_text);
        userText = (EditText) findViewById(R.id.user_text);
        passwordText = (EditText) findViewById(R.id.password_text);
        portText = (EditText) findViewById(R.id.port_text);
        start = (Button) findViewById(R.id.start_button);
        assert textView != null;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

//        //启动线程，实时获取wifi信息
//        scanWifiInfo();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            scanWifiInfo();
                        }
                    });
                    if (i == 550) {
//                        ad.show();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ad = new AlertDialog.Builder(MainActivity.this).setTitle("记录成功！").setMessage("对区块" + placeId + "的数据收集已经完成了！")
                                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                start.setEnabled(true);
                                            }
                                        }).show();
                            }
                        });
                        break;
                    }
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultList = new ArrayList<WifiMsg>();
                placeId = 0;
                i = 0;
                try {
                    placeId = Integer.parseInt(placeIdText.getText().toString());
                } catch (Exception e) {
                    ad = new AlertDialog.Builder(MainActivity.this).setTitle("信息有误！").setMessage("请输入合法的区块ID和IP地址！")
                            .setPositiveButton("确定", null).show();
                    return;
                }
                //add MySQL Connecting here

                String user = userText.getText().toString();
                String password = passwordText.getText().toString();
                String ipAddress = ipText.getText().toString();
                String port = portText.getText().toString();
                String url = "jdbc:mysql://" + ipAddress + ":" + port + "/embedded?user=" + user + "&password=" + password + "&useUnicode=true&characterEncoding=UTF8";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (Exception e) {
                    ad = new AlertDialog.Builder(MainActivity.this).setTitle("连接有误！").setMessage("无法加载驱动！")
                            .setPositiveButton("确定", null).show();
                    return;
                }
                try {
                    connection = DriverManager.getConnection(url);
                } catch (Exception e) {
                    
                    //// TODO: 2016/4/13 修改为非主线程即可 
                    ad = new AlertDialog.Builder(MainActivity.this).setTitle("连接有误！").setMessage("无法连接到数据库！")
                            .setPositiveButton("确定", null).show();
                    return;
                }
                try {
                    statement = connection.createStatement();
                } catch (Exception e) {
                    ad = new AlertDialog.Builder(MainActivity.this).setTitle("连接有误！").setMessage("无法创建statement！")
                            .setPositiveButton("确定", null).show();
                    return;
                }

                t.start();
                ((Button) v).setEnabled(false);
            }
        });
    }

    //获得wifi信息 设备名和信号强度 scanResult.SSID\level
    public void scanWifiInfo() {
        WifiMsg wifiMsg = new WifiMsg();
        String wserviceName = Context.WIFI_SERVICE;
        WifiManager wm = (WifiManager) getSystemService(wserviceName);
        //startScan非常重要
        wm.startScan();
        List<ScanResult> results = wm.getScanResults();
        StringBuilder scanBuilder = new StringBuilder();

        i++;
        if (i < 50)
            return;

        for (ScanResult scanResult : results) {
            //在这里改变要获得的SSID 的动态wifi强度
//            if (scanResult.SSID.equals("door") || scanResult.SSID.equals("window") || scanResult.SSID.equals("left of desk") || scanResult.SSID.equals("right of desk")) {
            //1 2 3 4
//                wifiMsg.setSsid(scanResult.SSID);
//                wifiMsg.setLevel(WifiManager.calculateSignalLevel(scanResult.level, 1000));
            scanBuilder.append("\n设备名：" + scanResult.SSID
                    + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1000) + "\n");

//            wifiMsg.save(this, new SaveListener() {
//                @Override
//                public void onSuccess() {
//                    // TODO Auto-generated method stub
//                    //  toast("添加数据成功，返回objectId为："+p2.getObjectId());
//                    System.out.println("添加数据成功！");
//                }
//
//                @Override
//
//
//                public void onFailure(int code, String msg) {
//                    // TODO Auto-generated method stub
//                    //    toast("创建数据失败：" + msg)njm
//                     System.out.println("添加数据失败！");
//                }
//            });
//            }
            if (scanResult.SSID.equals("door")) {
                scanBuilder.append("\n设备名：" + scanResult.SSID + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1000) + "\n");
                wifiMsg.setLevel1(WifiManager.calculateSignalLevel(scanResult.level, 1000));
            }
            if (scanResult.SSID.equals("window")) {
                scanBuilder.append("\n设备名：" + scanResult.SSID + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1000) + "\n");
                wifiMsg.setLevel2(WifiManager.calculateSignalLevel(scanResult.level, 1000));
            }
            if (scanResult.SSID.equals("left of desk")) {
                scanBuilder.append("\n设备名：" + scanResult.SSID + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1000) + "\n");
                wifiMsg.setLevel3(WifiManager.calculateSignalLevel(scanResult.level, 1000));
            }
            if (scanResult.SSID.equals("right of desk")) {
                scanBuilder.append("\n设备名：" + scanResult.SSID + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1000) + "\n");
                wifiMsg.setLevel4(WifiManager.calculateSignalLevel(scanResult.level, 1000));
            }

            if (scanResult.SSID.equals("gh123")) {
                scanBuilder.append("\n设备名：" + scanResult.SSID + "\n信号强度：" + WifiManager.calculateSignalLevel(scanResult.level, 1000) + "\n");
                wifiMsg.setLevel1(123 + i);
                wifiMsg.setLevel2(123 + i);
                wifiMsg.setLevel3(123 + i);
                wifiMsg.setLevel4(123 + i);
            }

            try {
                statement.executeQuery("INSERT INTO `embedded`.`strength` (`record_id`, `strength_1`, `strength_2`, `strength_3`, `strength_4`, `point_id`) VALUES (NULL, '" +
                        "', '" + wifiMsg.getLevel1() +
                        "', '" + wifiMsg.getLevel2() +
                        "', '" + wifiMsg.getLevel3() +
                        "', '" + wifiMsg.getLevel4() +
                        "');");
            } catch (Exception e) {

            }

//            resultList.add(wifiMsg);
        }
        textView.setText(scanBuilder);
    }
}