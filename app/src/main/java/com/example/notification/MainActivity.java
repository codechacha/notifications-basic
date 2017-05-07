package com.example.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowNoti = (Button) findViewById(R.id.btn_basic_noti);
        btnShowNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNormalNotification();
            }
        });

        Button btnBigtextStyle = (Button) findViewById(R.id.btn_bigtext_style);
        btnBigtextStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBigtextStyleNotification();
            }
        });

        Button btnInboxStyle = (Button) findViewById(R.id.btn_inbox_style);
        btnInboxStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInboxStyleNotification();
            }
        });

        Button btnBigpictureStyle = (Button) findViewById(R.id.btn_bigpicture_style);
        btnBigpictureStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBigpictureStyleNotification();
            }
        });

        Button btnMessagingStyle = (Button) findViewById(R.id.btn_messaging_style);
        btnMessagingStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessagingStyleNotification();
            }
        });


    }

    public void sendNormalNotification() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_info_outline_black_24dp);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        builder.setContentTitle("Information for notifications");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications."); // Android prior to 4.2 will ignore this field
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void sendBigtextStyleNotification() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_info_outline_black_24dp);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        builder.setContentTitle("Information for notifications");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications."); // Android prior to 4.2 will ignore this field
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.bigText("A class that represents how a persistent notification is to be presented"
                + " to the user using the NotificationManager."
                + " The Notification.Builder has been added to make it easier to construct Notifications."
                + " builder.setStyle(style);");
        builder.setStyle(style);

        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void sendInboxStyleNotification() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_info_outline_black_24dp);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        builder.setContentTitle("Thre're many notification styles");
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        style.addLine("1. Inbox Style");
        style.addLine("2. Bixtext Style");
        style.addLine("3. Messaging Style");
        style.setSummaryText("+2 more");
        builder.setStyle(style);

        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void sendBigpictureStyleNotification() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_info_outline_black_24dp);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        builder.setContentTitle("Information for notifications");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications.");
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.setSummaryText("Visit and learn");
        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.sample2);
        style.bigPicture(picture);
        builder.setStyle(style);

        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }


    public void sendMessagingStyleNotification() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_info_outline_black_24dp);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        builder.setContentTitle("Information for notifications");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications.");
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationCompat.MessagingStyle style = new NotificationCompat.MessagingStyle("Me");
        style.setConversationTitle("Talk about notifications");
        style.addMessage("Have you heard about Notifications ", 1, "MJ");
        style.addMessage("No", 2, "Farfs");
        style.addMessage("Oh my got!", 3, null);
        style.addMessage("Visit AndroidExamples", 4, "Poll");
        builder.setStyle(style);

        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}
