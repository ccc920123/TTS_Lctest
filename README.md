# TTS_Lctest 离线语音报读，语音叫号的开源框架
 <br/>欢迎大家标星
 <br/>
##使用方式：<br/>

1：下载TTS_Lctest的deno，将里面的ttsloc library 引入项目。<br/>
<br/>
<br/>
你也可以直接下载aar 包在Android studio 中使用：
<br/>

[ttsloc-v1.0.0.aar](https://github.com/ccc920123/TTS_Lctest/blob/master/downloads/ttsloc-v1.0.0.aar?raw=true)
<br/><br/>
2：由于library包含so 需要在 app 的build.gradle中添加<br/>
ndk的支持

     defaultConfig {
       .....
        ndk {
            //设置支持的SO库架构
            abiFilters 'armeabi'
        }
    }
 
3：a.如果你的程序没有使用 AppContext 请在manifest 的 application下面添加
```
     android:name="com.cdjysd.ttsloc.appcontext.TTSAppContext"
```
   b.如果你有自己的AppContext你可以在你的AppContext extends  TTSAppContext，也可以直接在你的AppContext 的onCreate中初始化语音引擎
```
     TTSUtils.getInstance().initTts(this);
```
4.通过：

```
     TTSUtils.getInstance().speak("这里读取哟");
```

5.最后界面程序退出时，记得

```
    TTSUtils.getInstance().release();
```


# 注意事项：
读数字时记得 加空格  例如
```
    TTSUtils.getInstance().speak("0 0 1");
```
最后读出001.
在比如
```
    TTSUtils.getInstance().speak("100");
```
不加空格就读一百，每个数字用空格相隔就读1 0 0；

