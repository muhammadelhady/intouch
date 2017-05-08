package com.example.hady.intouch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Touchpanel_Activity extends AppCompatActivity {
    boolean test_sos = false;
    boolean test_first = false;
    boolean test_second = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchpanel_);
    }



    public void sos_btn(View vie)
    {

        if (test_sos)
        {
            Intent callIntent =new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:01000331469"));
            startActivity(callIntent);
        }
        else{
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1000);
            test_sos=true;
            test_first=false;
            test_second=false;
        }

    }

    public void first_btn(View vie)
    {

        SharedPreferences sp =getSharedPreferences("contacts", Context.MODE_PRIVATE);
        String first_phone = sp.getString("first_phone",null);
        if (test_first)
        {
            Intent callIntent =new Intent(Intent.ACTION_CALL);

            callIntent.setData(Uri.parse("tel:"+first_phone));
            startActivity(callIntent);
        }
        else{
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test_first=true;
            test_second=false;
            test_sos=false;
            v.vibrate(400);

        }

    }

    public void second_btn(View vie)
    {
        SharedPreferences sp =getSharedPreferences("contacts", Context.MODE_PRIVATE);

        String second_phone = sp.getString("second_phone", null);
        if (test_second)
        {
            Intent callIntent =new Intent(Intent.ACTION_CALL);

            callIntent.setData(Uri.parse("tel:"+second_phone));
            startActivity(callIntent);
        }
        else{
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test_second=true;
            test_first=false;
            test_sos=false;
            v.vibrate(400);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.vibrate(400);
        }

    }
}
