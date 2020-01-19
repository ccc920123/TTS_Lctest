package com.cdjysd.ttsloc.utils;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.yunzhisheng.tts.offline.TTSPlayerListener;
import cn.yunzhisheng.tts.offline.basic.ITTSControl;
import cn.yunzhisheng.tts.offline.basic.TTSFactory;
import cn.yunzhisheng.tts.offline.common.USCError;

/**
 * TTS NOT NET.
 * zuozhe: chenyujin
 */
public class TTSUtils {

    private static final String TAG = "TTSUtils";
    private static volatile TTSUtils instance = null;
    private boolean isInitSuccess = false;
    private ITTSControl mTTSPlayer;
//    private String FRONTEND_MODEL = Common.PHONE_PATH + "/tts/frontend_model";
//    private String BACKEND_MODEL = Common.PHONE_PATH + "/tts/backend_lzl";
    private Context mContext;

    public static final String appKey = "wio74rij224vpdb3te2usb5b2tmxgujj6ahr2bqb";

    private TTSUtils() {
    }

    public static TTSUtils getInstance() {
        if (instance == null) {
            synchronized (TTSUtils.class) {
                if (instance == null) {
                    instance = new TTSUtils();
                }
            }
        }
        return instance;
    }


    public void initTts(Context context) {
        this.mContext=context;
        //
        //Initialize speech synthesis object
        mTTSPlayer = TTSFactory.createTTSControl(mContext, appKey);
        // Set local synthesis
//        mTTSPlayer.setOption(SpeechConstants.TTS_SERVICE_MODE, SpeechConstants.TTS_SERVICE_MODE_LOCAL);
//        File _FrontendModelFile = new File(FRONTEND_MODEL);
//        if (!_FrontendModelFile.exists()) {
//            copyAssetFile(FRONTEND_MODEL, "OfflineTTSModels/frontend_model");
//        }
//        File _BackendModelFile = new File(BACKEND_MODEL);
//        if (!_BackendModelFile.exists()) {
//            copyAssetFile(BACKEND_MODEL, "OfflineTTSModels/backend_lzl");
//        }
//        // Set up front end model
//        mTTSPlayer.setOption(SpeechConstants.TTS_KEY_FRONTEND_MODEL_PATH, FRONTEND_MODEL);
//        // Set up backend model
//        mTTSPlayer.setOption(SpeechConstants.TTS_KEY_BACKEND_MODEL_PATH, BACKEND_MODEL);
        //
        //Set callback listening
        mTTSPlayer.setTTSListener(new TTSPlayerListener() {

            @Override
            public void onBuffer() {
                
            }

            @Override
            public void onPlayBegin() {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(USCError uscError) {

                Log.i("demo", "onError");
            }

            @Override
            public void onPlayEnd() {

            }

            @Override
            public void onInitFinish() {
                isInitSuccess = true;
            }

        });
        mTTSPlayer.setVoiceSpeed(2.5f);
        mTTSPlayer.setStreamType(AudioManager.STREAM_RING);
        mTTSPlayer.setVoicePitch(1.1f);
        mTTSPlayer.setPlayStartBufferTime(3000);
        // Initialize the synthesis engine
        mTTSPlayer.init();
    }

    public void speak(String msg) {
        if (isInitSuccess) {
            mTTSPlayer.play(msg);
        }else {
            initTts(mContext);
        }
    }

    public void stop() {
        if (null != mTTSPlayer) {
            mTTSPlayer.stop();
        }
    }

    public void pause() {
        if (null != mTTSPlayer) {
            mTTSPlayer.pause();
        }
    }

//    public void resume() {
//        if (null != mTTSPlayer) {
//            mTTSPlayer.resume();
//        }
//    }

    public void release() {
        if (null != mTTSPlayer) {
            // Release offline engine
            mTTSPlayer.release();
        }
    }

    private void copyAssetFile(String path, String pathName){
        try {
            InputStream is = mContext.getAssets().open(pathName);
            FileOutputStream fos = new FileOutputStream(new File(path));
            byte[] buffer = new byte[1024];
            int byteCount = 0;
            while ((byteCount = is.read(buffer)) != -1) {// Loop reads buffer bytes from input stream
                fos.write(buffer, 0, byteCount);// Write the read input stream to the output stream
            }
            fos.flush();
            is.close();
            fos.close();
        } catch (IOException e) {
            Log.e(TAG, "copyAssetsFile2SDCard: " + e.toString());
        }
    }
}
