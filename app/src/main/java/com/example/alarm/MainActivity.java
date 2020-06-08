package com.example.alarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TimePicker timePicker;
    private EditText event;
//    Calendar calendar = Calendar.getInstance();


    public static final int ALARM_PERMISSION_CODE = 101;

//    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//            calendar.set(Calendar.YEAR,year);
//            calendar.set(Calendar.MONTH,month);
//            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
//            event.setText(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DatePickerDialog datePickerDialog = new DatePickerDialog(
//                this,
//                listener,
//                calendar.get(Calendar.YEAR),
//                calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.show();


        button = findViewById(R.id.btn);
        timePicker = findViewById(R.id.timePicker);
        event = findViewById(R.id.eventET);
//
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SET_ALARM) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SET_ALARM},ALARM_PERMISSION_CODE);
        }
//
//
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });


//        Date date = calendar.getTime();
//        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
//        Toast.makeText(this, "Date: "+currentTime, Toast.LENGTH_LONG).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setAlarm() {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR,timePicker.getHour());
        intent.putExtra(AlarmClock.EXTRA_MINUTES,timePicker.getMinute());
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,event.getText().toString());
//        ArrayList<Integer> days = new ArrayList<>();

//        days.add(Calendar.FRIDAY);
//        days.add(Calendar.SUNDAY);
//        days.add(Calendar.TUESDAY);

//        intent.putExtra(AlarmClock.EXTRA_DAYS,days);
        startActivity(intent);
    }
}