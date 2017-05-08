package com.example.hady.intouch;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class setting_activity extends AppCompatActivity {

    EditText first_name,first_phone,second_name,second_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_activity);
        first_name = (EditText)findViewById(R.id.first_name);
        first_phone = (EditText)findViewById(R.id.first_phone);
        second_name = (EditText)findViewById(R.id.second_name);
        second_phone=(EditText)findViewById(R.id.phone);
    }


    public void save_btn(View view)
    {
        SharedPreferences sp =getSharedPreferences("contacts", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("first_name",first_name.getText().toString());
        editor.putString("first_phone", first_phone.getText().toString());
        editor.putString("second_name",second_name.getText().toString());
        editor.putString("second_phone", second_phone.getText().toString());
        editor.commit();
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();


    }


}
