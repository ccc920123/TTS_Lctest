package com.cdjysd.ttsloc.appcontext;

import android.app.Application;
import android.content.Context;
import com.cdjysd.ttsloc.utils.TTSUtils;


/**
 * chenyujin
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
