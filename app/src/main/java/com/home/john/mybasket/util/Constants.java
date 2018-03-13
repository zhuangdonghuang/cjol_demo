package com.home.john.mybasket.util;

/**用于存放应用所有公用常量
 * Created by John on 2016/3/14.
 */
public class Constants {
    //用来记录是否第一次登录的文件名
    public static  final  String PREFERENCES_FIRST_USED = "preferences_first_used";
    //用来记录是否第一次登录的key
    public static final String PREFERENCES_FIRST_USED_KEY = "preferences_first_used_key";
    //返回是否注册标记
    public static boolean FLAG = false;

    //返回的状态表示值
    public  static  final  String RESPONSE_RESULT_STATE = "state";
    //返回的状态标识值
    public  static  final  String RESPONSE_RESULT_STATE_SUCCESS = "success";
    //返回info
    public  static  final  String RESPONSE_RESULT_INFO = "info";
    //
    public static final String APP_ID_QQ = "1105206331";
//新浪微博相关
    public static final String APP_KEY = "3596353577"; // 应用的APP_KEY
    public static final String REDIRECT_URL = "http://www.sina.com";// 应用的回调页
    public static final String SCOPE = // 应用申请的高级权限
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";

}
