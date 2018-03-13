package com.home.john.mybasket.util;

import android.os.AsyncTask;

/**
 * 用于异步请求网络
 * Created by John on 2016/3/15.
 */
public class AssistantTask extends AsyncTask<Void,Void,Object> {
//???这两个什么
    private  IRequest request;
    private  IRequestCallback callback;

    public AssistantTask(IRequest request, IRequestCallback callback) {
        if (request == null||callback ==null){
            throw  new NullPointerException("request or callback can not be null");
        }
        this.request = request;
        this.callback = callback;
    }

    public AssistantTask(IRequestCallback callback) {

    }



    @Override
    protected Object doInBackground(Void... params) {
        return request.doRequest();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        if (o==null){
            callback.onError("请求失败");
        }else {
            callback.onSuccess(o);
        }
    }
    //请求接口
    public interface  IRequest{
        //执行请求
        Object doRequest();
    }
//请求回调接口
    public  interface  IRequestCallback {
        //请求成功回调方法
        void  onSuccess(Object obj);
        //请求失败回调方法
        void  onError(String msg);
    }


    //进度条接口
    public  interface  IDownLoadProgress{
        void updataProgress(int progress);
    }
}
