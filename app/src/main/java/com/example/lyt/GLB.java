package com.example.lyt;

import android.app.Application;
import android.content.*;

public class GLB {
    static Thread v;/* 控制音量 */
    private static Application application;
    static private int flag;

    static public void setFlag(int i) {
        flag = i;
        return;
    }

    static public boolean getFLag() {
        return flag != 0;
    }

    static public void setApp(Application c) {
        application = application == null ? c : application;
    }

    static public Application app() {
        return application;
    }
}