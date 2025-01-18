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
        GLB.write("----onStart----\n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLB.write("----onCreate----\n");
        //Toast.makeText(this, "" + (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)), Toast.LENGTH_LONG).show();
    }
}
