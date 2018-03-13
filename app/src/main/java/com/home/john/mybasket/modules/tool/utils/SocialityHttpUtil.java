package com.home.john.mybasket.modules.tool.utils;


import com.home.john.mybasket.util.AssistantTask;
import com.home.john.mybasket.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 网络请求
 * Created by John on 2016/3/16.
 */
public class SocialityHttpUtil {
    //积分商城
    public static  final  String URL_GAME_EXCHANGE_LIST = "http://www.yuu1.com/app_api/prize_list/";
    //详情页
    public static final String URL_GAME_DETAILS_LIST = "http://www.yuu1.com/app_api/prize_info/";




    //请求请求积分商城列表
    public  static void requestExchangeList(final int page,AssistantTask.IRequestCallback callback){
        AssistantTask.IRequest request = new AssistantTask.IRequest() {
            @Override
            public Object doRequest() {
                Map<String,String>params = new HashMap<>();
                params.put("type","1");
                params.put("page", "" + page);
                return HttpUtil.doPost(URL_GAME_EXCHANGE_LIST,params);
            }
        };
        AssistantTask task = new AssistantTask(request,callback);
        task.execute();
    }


    //请求请求积分商城列表
    public  static void requestExchangeListt(final int page,AssistantTask.IRequestCallback callback){
        AssistantTask.IRequest request = new AssistantTask.IRequest() {
            @Override
            public Object doRequest() {
                Map<String,String>params = new HashMap<>();
                params.put("type","2");
                params.put("page", "" + page);
                return HttpUtil.doPost(URL_GAME_EXCHANGE_LIST, params);
            }
        };
        AssistantTask task = new AssistantTask(request,callback);
        task.execute();
    }

    //奖品获取详情
    public  static void requestExchangeInfo(final String id,AssistantTask.IRequestCallback callback){
        AssistantTask.IRequest request = new AssistantTask.IRequest() {
            @Override
            public Object doRequest() {
                Map<String,String>params = new HashMap<>();
                params.put("id",id);
                return HttpUtil.doPost(URL_GAME_DETAILS_LIST,params);
            }
        };
        AssistantTask task = new AssistantTask(request,callback);
        task.execute();
    }

}
