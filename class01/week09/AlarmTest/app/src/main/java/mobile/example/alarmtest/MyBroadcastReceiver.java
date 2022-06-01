package mobile.example.alarmtest;

import android.app.Activity;
import android.content.*;
import android.widget.*;

public class MyBroadcastReceiver extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "one time!", Toast.LENGTH_LONG).show();
		// Notification 출력
	}
}

//public class MyBroadcastReceiver extends BroadcastReceiver {
//	public void onReceive(Context context, Intent intent) {
//		String data = intent.getStringExtra("data");
//		Toast.makeText(context, "Value: " + data, Toast.LENGTH_LONG).show();
//	}
//}