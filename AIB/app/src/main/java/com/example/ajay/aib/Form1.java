package com.example.ajay.aib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class Form1 extends Activity {
    CustomerDbHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        Spinner spinner =  findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.accounts_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

        public void openForm2(View view) {

        Spinner spin=findViewById(R.id.spinner);
            String text = spin.getSelectedItem().toString();

        myDb=new CustomerDbHelper(this);


            EditText n = findViewById(R.id.name);
            EditText adres = findViewById(R.id.editText3);
            EditText Act = findViewById(R.id.editText3);
            myDb.addCustomer(n.getText().toString(), adres.getText().toString(), text);


        Intent intent = new Intent(this, Form2.class);
        EditText editText = findViewById(R.id.name);
        String message = editText.getText().toString();
        intent.putExtra("id ", message);
        intent.putExtra("Form","1");
        startActivity(intent);

    }

    }

