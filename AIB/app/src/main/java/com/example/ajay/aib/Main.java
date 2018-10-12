package com.example.ajay.aib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
    CustomerDbHelper myDb;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch(item.getItemId())
    {
        case R.id.i1:
            Toast.makeText(this,"Displaying records", Toast.LENGTH_SHORT).show();
            Cursor res=myDb.getAllData();
           StringBuffer buffer=new StringBuffer();
            while(res.moveToNext()){
                buffer.append("Id:"+res.getString(0)+"\n");
                buffer.append("Name:"+res.getString(1)+"\n");
                buffer.append("Address:"+res.getString(2)+"\n");
                buffer.append("Account type:"+res.getString(3)+"\n");
                buffer.append("Balance:"+res.getString(4)+"\n\n");


            }
            showMessage("Data",buffer);
            return true;
        case R.id.i21:

            String url = "https://source.android.com/setup/contribute/report-bugs"; // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
            return true;
        case R.id.i22:
            Toast.makeText(this,"Your application is Up to date",Toast.LENGTH_SHORT).show();
            return true;
        case R.id.i3: finish();
            return true;


    }

        return super.onOptionsItemSelected(item);
    }

    public void showMessage(String title,StringBuffer Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
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
