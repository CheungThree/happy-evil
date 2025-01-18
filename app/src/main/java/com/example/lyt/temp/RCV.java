package com.example.lyt.temp;

import android.app.admin.*;
import android.content.*;
import android.widget.*;

import androidx.annotation.NonNull;

public class RCV extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Toast.makeText(context, "已啓動", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDisabled(@NonNull Context context, @NonNull Intent intent) {
        super.onDisabled(context, intent);
        Toast.makeText(context, "已關閉", Toast.LENGTH_LONG).show();
    }
}