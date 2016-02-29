package com.farazfazli.notificationslab;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View view) {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        Intent intent;
        if (manager.getActiveNetworkInfo() != null) {
            builder.setSmallIcon(R.drawable.icon);
            intent = new Intent(MainActivity.this, MainActivity.class);
        } else {
            builder.setSmallIcon(android.R.drawable.ic_menu_close_clear_cancel);
            intent = new Intent(MainActivity.this, SecondActivity.class);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 12, intent, 0);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
