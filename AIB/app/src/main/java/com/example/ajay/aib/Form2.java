package com.example.ajay.aib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Form2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        Intent intent=getIntent();
        String message=intent.getStringExtra("Name");

        TextView textView=findViewById(R.id.name);
        textView.setText("This account belongs to "+message);


    }
}
