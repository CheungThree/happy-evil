package com.example.lyt;

import static com.example.lyt.SNDActivity.OVERLAY;

import android.app.*;
import android.content.*;
import android.net.Uri;
import android.os.*;
import android.provider.*;
import android.view.*;
import android.widget.Toast;

import com.example.lyt.temp.SVR;

public class MainActivity extends Activity implements View.OnClickListener {

	@Override
	public void onClick(View vi) {
		GLB.write("----onClick----\n");
		//Toast.makeText(this, "onClick", Toast.LENGTH_LONG).show();
		if (SVR.service == null)
			this.startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        /*
        if (getPermission() == 0) ;
        else startActivity(new Intent(this, SNDActivity.class));
        当前无需再设置悬浮窗权限
         */
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		GLB.write("----onCreate----\n");
		super.onCreate(savedInstanceState);
		/* startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)); */
		setContentView(R.layout.fst);
		//Toast.makeText(getApplicationContext(), "Hello world", Toast.LENGTH_SHORT).show();
		findViewById(R.id.ent).setOnClickListener(this);
	}
        /*
        遗物
	public int getPermission() {
		GLB.write("----getPermission----\n");
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
			//Toast.makeText(this, "请允许在应用上层显示", Toast.LENGTH_LONG).show();
			startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + this.getPackageName())));
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		GLB.write("----onActivityResult----\n");
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
			case OVERLAY:
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
					Toast.makeText(this, "悬浮窗未开启。请前往设置。", Toast.LENGTH_LONG).show();
					Runtime.getRuntime().halt(0);
				}
				startActivity(new Intent(this, SNDActivity.class));
		}
	}
*/
}