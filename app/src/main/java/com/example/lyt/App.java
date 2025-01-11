package com.example.lyt;

import android.app.Application;
import android.widget.Toast;

public class App extends Application {
    static {
        System.loadLibrary("native-lib");
    }

    public App() {
        //com.example.lyt.GLB.app = this;
        //Toast.makeText(this,hello(),Toast.LENGTH_LONG).show();
        //Runtime.getRuntime().halt(0);
    }

    native public String hello();

    @Override
    public void onCreate() {
        super.onCreate();
        com.example.lyt.GLB.app = this;
        Toast.makeText(this,/*"hello" */hello(), Toast.LENGTH_LONG).show();
    }

}
