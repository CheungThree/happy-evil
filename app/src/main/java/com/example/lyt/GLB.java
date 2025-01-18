package com.example.lyt;

import android.app.Application;
import android.content.*;

public class GLB {
    static Thread v;/* 控制音量 */
    private static Application application;

    static  public void setApp(Application c) {
        application = application==null?c:application;
    }

    static public Application app() {
        return application;
    }
}