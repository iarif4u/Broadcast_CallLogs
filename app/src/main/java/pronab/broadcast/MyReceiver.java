package pronab.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class MyReceiver extends BroadcastReceiver {
    Preference preference;
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        preference = new Preference(context);
        if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)){
            String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            preference.saveUserData(phoneNumber,1);
            Notification notification = new Notification.Builder(context)
                    .setContentTitle("Incoming Call")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText(phoneNumber)
                    .setAutoCancel(true)
                    .build();
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify((int) System.currentTimeMillis(),notification);
        }else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)){
            String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            preference.saveUserData(phoneNumber,1);
            Notification notification = new Notification.Builder(context)
                    .setContentTitle("Idel")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText(phoneNumber)
                    .setAutoCancel(true)
                    .build();
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify((int) System.currentTimeMillis(),notification);
        }
    }
}
