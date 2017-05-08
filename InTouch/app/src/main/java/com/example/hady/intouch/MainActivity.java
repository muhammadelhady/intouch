package com.example.hady.intouch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go_btn(View view)
    {

        Intent activ = new Intent(MainActivity.this,Touchpanel_Activity.class);
        startActivity(activ);
    }
    public void setting_btn(View view)
    {
        Intent activ = new Intent(MainActivity.this,setting_activity.class);
        startActivity(activ);
    }
}
