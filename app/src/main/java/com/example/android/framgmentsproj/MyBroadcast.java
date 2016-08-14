package com.example.android.framgmentsproj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by nsethi on 13-Aug-16.
 */
public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Phone is connected",Toast.LENGTH_SHORT).show();
    }
};
