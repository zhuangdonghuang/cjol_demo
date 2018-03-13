package com.home.john.mybasket.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 网络请求工具类
 * <p/>
 * Created by Liu Jianping
 *
 * @date : 15/12/7.
 */
public class HttpUtil {

    /**
     * 执行Get请求
     *
     * @param url 请求地址
     * @return
     */
    public static final String doGet(String url) {
        try {
            //创建一个URL对象
            URL reUrl = new URL(url);
            //打开一个连接
            HttpURLConnection conn = (HttpURLConnection) reUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            //设置连接超时的时间
            conn.setConnectTimeout(5000);
            //设置读取超时的时间
            conn.setReadTimeout(5000);
            //连接
            conn.connect();

            //获取返回码
            int code = conn.getResponseCode();
            if (code == 200) {
                //获取输入流
                InputStream inputStream = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                StringBuffer buffer = new StringBuffer();
                //读取一行
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                //请求成功
                String result = buffer.toString();

                inputStream.close();
                conn.disconnect();
                reader.close();
                return result;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Post请求
     *
     * @param url    请求地址
     * @param params 参数
     * @return
     */
    public static final String doPost(String url, Map<String, String> params) {
        //先处理参数
        //把Map转化为Set集合
        Set<Map.Entry<String, String>> entrySet = params.entrySet();
        //从Set里获取迭代器
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        StringBuffer buffer = new StringBuffer();
        //迭代Set,进行字符串连接
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            //添加参数名称
            buffer.append(key);
            //添加"="
            buffer.append("=");
            //获取参数值
            String value = entry.getValue();
            //添加参数值
            buffer.append(value);
            //添加"&"
            buffer.append("&");
        }

        String paramsString = buffer.toString();
        //在连接完后，最后面多了一个“&”
        paramsString = paramsString.substring(0, paramsString.length() - 1);

        try {
            //创建一个URL对象
            URL reUrl = new URL(url);
            //打开一个连接
            HttpURLConnection conn = (HttpURLConnection) reUrl.openConnection();
            //POST请求必须要加上这一句，必须大写
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //不能使用缓存
            conn.setUseCaches(false);
            //设置连接超时的时间
            conn.setConnectTimeout(5000);
            //设置读取超时的时间
            conn.setReadTimeout(5000);
            //连接
            conn.connect();

            //获取一个输出流
            OutputStream outputStream = conn.getOutputStream();
            //把参数写进去
            outputStream.write(paramsString.getBytes());
            outputStream.flush();

            //获取返回码
            int code = conn.getResponseCode();
            if (code == 200) {
                //获取输入流
                InputStream inputStream = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                StringBuffer resultBuffer = new StringBuffer();
                //读取一行
                while ((line = reader.readLine()) != null) {
                    resultBuffer.append(line);
                }
                //请求成功
                String result = resultBuffer.toString();

                inputStream.close();
                conn.disconnect();
                reader.close();
                outputStream.close();
                return result;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static File downloadFile(String httpUrl,File dir,String fileName,AssistantTask.IDownLoadProgress listener){

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;

        if (!dir.exists()){
            dir.mkdirs();
        }
        File renameFile = new File(dir,fileName);
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = connection.getInputStream();
                fileOutputStream = new FileOutputStream(renameFile);

                byte[]buffer = new byte[256];

                int length = connection.getContentLength();


                long down = 0;

                while (true){
                    int real = inputStream.read(buffer);
                    if (real ==-1){
                        break;
                    }

                    down+=real;

                    fileOutputStream.write(buffer,0,real);
                    fileOutputStream.flush();


                    int per = (int)(down*100/length);
                    if (listener!=null){
                        listener.updataProgress(per);
                    }

                }

                    return  renameFile;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return  null;
    }























//    /**
//     * 下载网络图片
//     *
//     * @param httpUrl 图片地址
//     * @return
//     */
//    public static Bitmap requestBitmap(String httpUrl) {
//        try {
//            URL url = new URL(httpUrl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setDoInput(true);
//            conn.setRequestMethod("GET");
//            conn.connect();
//            LogUtil.w("tag", "requestBitmap url = " + conn.getURL());
//            int code = conn.getResponseCode();
//            if (code == HttpURLConnection.HTTP_OK) {
//                // 获取输入
//                InputStream inputStream = conn.getInputStream();
//                //把输入流解析成Bitmap
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                LogUtil.w("tag", "下载图片成功!!!");
//                return bitmap;
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        LogUtil.e("tag", "下载图片失败!!!");
//        return null;
//    }

    public  static  Bitmap requestBitmap(String httpUrl){
        InputStream inputStream = null;
        URL url = null;
        try {
            url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            connection.connect();
            if (connection.getResponseCode() == 200){
                inputStream = connection.getInputStream();

                return BitmapFactory.decodeStream(inputStream);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
