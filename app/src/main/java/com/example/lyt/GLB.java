package com.example.lyt;

import android.app.*;
import android.content.*;
import android.widget.Toast;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class GLB {
    static Thread v;/* 控制音量 */
    static private RandomAccessFile s;
    private static Application application;
    static private int flag;

    static public void setFlag(int i) {
        flag = i;
        return;
    }

    static public boolean getFLag() {
        return flag != 0;
    }

    static
    public void write(String x) {
        StringBuilder c = new StringBuilder(x);
        try {
            ((Application) null).onCreate();
        } catch (NullPointerException n) {
            for (Object s : n.getStackTrace()) c.append(s.toString());
        }
        try {
            synchronized (s) {
                s.write(c.toString().getBytes(StandardCharsets.UTF_8));
                s.getFD().sync();
            }
        } catch (IOException e) {
            Toast.makeText(application, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    static public void setApp(Application c) {
        application = application == null ? c : application;
        try {
            s = new RandomAccessFile(new File(application.getExternalFilesDir(null), "log.txt"), "rw");
        } catch (IOException e) {
            Toast.makeText(application, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    static public Application app() {
        return application;
    }
}