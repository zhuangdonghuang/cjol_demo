package com.home.john.mybasket.modules.tool.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2016/3/18.
 */
public class sociality_bean {

    /**
     * id : 573
     * name : 运河电热毯 双档调温安全保护单人斑点花 150*70cm
     * consume : 80000
     * icon : http://i3.265g.com/images/201510/201510211650104413.jpg
     * remain : 3
     */

    private String id;
    private String name;
    private String consume;
    private String icon;
    private String remain;

    public static sociality_bean objectFromData(String str) {

        return new Gson().fromJson(str, sociality_bean.class);
    }

    public static List<sociality_bean> arrayExchangeListFromData(String str) {

        Type listType = new TypeToken<ArrayList<sociality_bean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }
}
