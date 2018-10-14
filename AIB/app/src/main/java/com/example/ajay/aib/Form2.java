package com.example.ajay.aib;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Form2 extends Activity {
CustomerDbHelper myDb,Db;
    int balance,ido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);


        Spinner spinner =  findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        myDb=new CustomerDbHelper(this);
        Intent intent=getIntent();
        String message=intent.getStringExtra("id");
        String form=intent.getStringExtra("Form");
        TextView textView=findViewById(R.id.name);



        if(form.matches("0")) {

            ido=Integer.parseInt(message);

            Cursor res=myDb.getBalance(ido);
            int bal=0;
            if(res.moveToNext())

            {

                bal=res.getInt(0);
            }

            res.close();
            balance=bal;

            textView.setText("This account id is:"+ido+"and it has INR"+bal);


        }
        else
        {   Cursor res=myDb.getLast();
            int nid=0;
        if(res.moveToNext())

            {
               nid=(res.getInt(0));

            }

            res.close();

        res=myDb.getBalance(nid);
            int bal=0;
            if(res.moveToNext())

            {

                bal=res.getInt(0);
            }

            res.close();



            textView.setText("This new accounts id is:" +nid+"and it has currently INR 0");

            balance=bal;
            ido=nid;
        }

    }
    public void Dpst(View view)
    {   Db=new CustomerDbHelper(this);
        EditText e=findViewById(R.id.Deposit);
        String e1=e.getText().toString();
        if(!e1.isEmpty()) {
            int value = Integer.parseInt(e1);
            Db.update(ido, value, balance);

        }
        else
            e.setError("Enter value");
    }

}
