package com.mvgv70.navitel_safe_close;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class ReceiverNavitelClose extends BroadcastReceiver {
	
	private static final String NAVITEL_RESTART_ACTION = "com.device.poweroff";
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		String action = intent.getAction();
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = prefs.edit();
		editor.putString(action, System.currentTimeMillis()+"");
		editor.commit();
		//
		Intent ni = new Intent(NAVITEL_RESTART_ACTION);
        context.sendBroadcast(ni);
	}   

}
