package com.example.lyt;

import android.app.Application;
import android.widget.Toast;

public class App extends Application {
    static {
        System.loadLibrary("native-lib");
    }

    public App() {
        com.example.lyt.GLB.setApp(this);
    }

    native public String hello();

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,/*"hello" */hello(), Toast.LENGTH_LONG).show();
    }

}
