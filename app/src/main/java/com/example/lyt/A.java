package com.example.lyt;

import android.app.*;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class A extends Service {
    private static Object windowManager, floatingView;

    /*
        private static void showFloatingWindow() {
            windowManager =GLB.app.getSystemService(WINDOW_SERVICE);
            WindowManager.LayoutParams l = new WindowManager.LayoutParams();
            l.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
            l.format = PixelFormat.TRANSPARENT;
            l.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
            l.height = l.width = WindowManager.LayoutParams.MATCH_PARENT;
            l.gravity = Gravity.CENTER;
            floatingView = LayoutInflater.from(this).inflate(R.layout.content_sndactivity, null);
            ((WindowManager) windowManager).addView((View) floatingView, l);
        }
    */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (floatingView != null) ((WindowManager) windowManager).removeView((View) floatingView);
    }

    @Override
    public IBinder onBind(Intent i) {
        return null;
    }
}
