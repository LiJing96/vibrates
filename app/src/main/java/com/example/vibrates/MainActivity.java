package com.example.vibrates;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txv = findViewById(R.id.txv);
        txv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        Vibrator vb=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        if(e.getAction()==MotionEvent.ACTION_DOWN){
            vb.vibrate(5000);
            Toast.makeText(getApplicationContext(), "开始震动", Toast.LENGTH_SHORT).show();
        } else if(e.getAction()==MotionEvent.ACTION_UP){
            vb.cancel();
            Toast.makeText(getApplicationContext(), "停止震动", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
