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
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,View.OnDragListener{

    private IntentFilter filter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
    private IntentFilter filter1 = new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textView1).setOnTouchListener(this);
        findViewById(R.id.pinkLayout).setOnDragListener(this);
        findViewById(R.id.yellowLayout).setOnDragListener(this);
        Log.d("MyLogs","In Create");
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    public boolean onDrag(View layoutview, DragEvent dragevent) {
        int action = dragevent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d("MyLogs", "Drag event started");
                return true;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d("MyLogs", "Drag event entered into "+layoutview.toString());
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d("MyLogs", "Drag event exited from "+layoutview.toString());
                return true;
            case DragEvent.ACTION_DROP:
                Log.d("MyLogs", "Dropped");
                View view = (View) dragevent.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) layoutview;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d("MyLogs", "Drag ended");
                break;
            default:
                break;
        }
        return true;
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
        Toast.makeText(this,"Im in stop",Toast.LENGTH_SHORT).show();
        Log.d("MyLogs","In Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
       // unregisterReceiver(receiver);
        unregisterReceiver(receiver1);
        Toast.makeText(this,"Im in pause",Toast.LENGTH_SHORT).show();
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
