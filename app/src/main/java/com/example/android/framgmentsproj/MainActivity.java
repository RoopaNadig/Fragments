package com.example.android.framgmentsproj;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter filter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
    private IntentFilter filter1 = new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle savedInstance = savedInstanceState;
        Button btn = (Button)findViewById(R.id.btn_id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Bomb Alert");
                builder.show();
            }
        });
       // onCreateDialog(savedInstanceState ).show();
        Log.d("MyLogs","In Create");
    }

    private BroadcastReceiver receiver1 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getApplicationContext(),"Phone is disconnected",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MyLogs","In Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MyLogs","In Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MyLogs","In destroy");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("MyLogs","In window focus changed");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MyLogs","In onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MyLogs","In onRestoreInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MyLogs","In Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
       // unregisterReceiver(receiver);
        unregisterReceiver(receiver1);

        Log.d("MyLogs","In pause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(receiver1,filter1);
       // registerReceiver(receiver,filter);
        Log.d("MyLogs","In resume");
    }


}
