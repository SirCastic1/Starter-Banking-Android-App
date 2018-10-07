package com.example.ajay.aib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
    CustomerDbHelper myDb;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    myDb=new CustomerDbHelper(this);
    }

    public void openForm1(View view)
    {
        Intent intent=new Intent(this,Form1.class);
        startActivity(intent);
    }

    public void Frm2(View view)
    {
        Intent intent=new Intent(this,Form2.class);
        startActivity(intent);
    }
}
