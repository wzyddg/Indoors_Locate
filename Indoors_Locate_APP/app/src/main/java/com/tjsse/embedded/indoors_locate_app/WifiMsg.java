package com.tjsse.embedded.indoors_locate_app;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/3/31.
 */
//要传递的wifi信息
public class WifiMsg extends BmobObject {
    private String ssid;
    private String level;
        public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
