package com.example.datepickerapp;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    Button button;
    Integer diff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        editText=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        Calendar c=Calendar.getInstance();
        int cyear=c.get(Calendar.YEAR);
        int cMonth=c.get(Calendar.MONTH);
        int cDate=c.get(Calendar.DATE);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, android.R.style.Widget_Material, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editText.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        diff=cyear-year;
                    }
                },cyear,cMonth,cDate);
                datePickerDialog.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Your age is:"+diff,Toast.LENGTH_LONG).show();
            }
        });
    }
}