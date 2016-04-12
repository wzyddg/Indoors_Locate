package com.tjsse.embedded.indoors_locate_app;

/**
 * Created by Administrator on 2016/3/31.
 */
//要传递的wifi信息
public class WifiMsg {
    private Integer placeId;
    private Integer level1;
    private Integer level2;
    private Integer level3;
    private Integer level4;

    public WifiMsg(){
        placeId=0;
        level1=0;
        level2=0;
        level3=0;
        level4=0;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public void setInformation(Integer level1,Integer level2,Integer level3,Integer level4) {
        this.level1=level1;
        this.level2=level2;
        this.level3=level3;
        this.level4=level4;
    }

    public Integer getLevel1() {
        return level1;
    }

    public void setLevel1(Integer level1) {
        this.level1 = level1;
    }

    public Integer getLevel2() {
        return level2;
    }

    public void setLevel2(Integer level2) {
        this.level2 = level2;
    }

    public Integer getLevel3() {
        return level3;
    }

    public void setLevel3(Integer level3) {
        this.level3 = level3;
    }

    public Integer getLevel4() {
        return level4;
    }

    public void setLevel4(Integer level4) {
        this.level4 = level4;
    }
}