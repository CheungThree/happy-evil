package com.example.lyt;

import android.app.*;
import android.content.*;
import android.widget.Toast;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class GLB {
	static Thread v;/* 控制音量 */
	final static private Map<Number, RandomAccessFile> s = new HashMap<>();
	private static Application application;
	static private int flag;

	static public void setFlag(int i) {
		flag = i;
		return;
	}

	static public boolean getFLag() {
		return flag != 0;
	}

	static public void writeStack() {
		Map<Thread, StackTraceElement[]> stacktraces = Thread.getAllStackTraces();
		for (Thread k : stacktraces.keySet()) {
			synchronized (s) {/*需要修改 s 的元素，同步*/
				long id = k.getId();
				try {
					if (!s.containsKey(id))/*不包含则添加*/
						s.put(id, new RandomAccessFile(new File(application.getExternalFilesDir(null), "" + id + " log.txt"), "rw"));
					RandomAccessFile output = s.get(id);
					StringBuilder sb = new StringBuilder();
					/*访问 stacktraces 无需锁 */
					for (StackTraceElement element : stacktraces.get(k)) {
						sb.append(element.toString());
						sb.append('\n');
					}
					synchronized (output)/*写文件，锁*/ {
						output.write(sb.toString().getBytes(StandardCharsets.UTF_8));
					}
				} catch (IOException e) {
					Toast.makeText(application, e.toString(), Toast.LENGTH_LONG).show();
				}
			}
		}
	}

	static
	public void write(String x) {
		final long id = Thread.currentThread().getId();
		RandomAccessFile f;
		try {
			try {
				synchronized (s) {
					if (!s.containsKey(id))
						s.put(id, new RandomAccessFile(new File(application.getExternalFilesDir(null), "" + id + " log.txt"), "rw"));
				}
			} catch (IOException e) {
				Toast.makeText(application, e.toString(), Toast.LENGTH_LONG).show();
			}
			synchronized (f = s.get(id)) {
				StringBuilder stringbd = new StringBuilder(x);
				for (Object element : Thread.currentThread().getStackTrace())
					stringbd.append(element.toString() + "\n");
				f.write(stringbd.
						toString().getBytes(StandardCharsets.UTF_8));
				f.getFD().sync();
			}
		} catch (IOException e) {
			Toast.makeText(application, e.toString(), Toast.LENGTH_LONG).show();
		}
	}

	static public void setApp(Application c) {
		application = application == null ? c : application;
	}

	static public Application app() {
		return application;
	}
}