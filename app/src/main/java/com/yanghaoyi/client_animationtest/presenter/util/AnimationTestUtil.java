package com.yanghaoyi.client_animationtest.presenter.util;

import android.util.Log;

/**
 * @author : YangHaoYi on 2020/7/1.
 * Email  :  yang.haoyi@qq.com
 * Description : 驾驶行为分析工具类
 * Change : YangHaoYi on 2020/7/1.
 * Version : V 1.0
 */
public class AnimationTestUtil {

    private static final String TAG = "AnimationTest";

    /** 日志输出开关 */
    private static boolean openLogMessage = true;

    /**
     * 日志输出
     * @param message 日志信息
     * **/
    public static void logMessage(String message){
        if(openLogMessage){
            Log.d(TAG, message);
        }
    }
}
