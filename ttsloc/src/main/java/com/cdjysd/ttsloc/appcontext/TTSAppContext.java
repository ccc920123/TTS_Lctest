package com.cdjysd.ttsloc.appcontext;

import android.app.Application;
import android.content.Context;
import com.cdjysd.ttsloc.utils.TTSUtils;


/**
 * 描述：
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2020/1/15
 * 修改人：
 * 修改时间：
 */


public class TTSAppContext extends Application {

//    @Override
//    protected void attachBaseContext(Context base) {
//
//
//        TTSUtils.getInstance().initTts(base);
//        super.attachBaseContext(base);
//
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        TTSUtils.getInstance().initTts(this);
    }
}
