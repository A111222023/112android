package com.example.datetimepickerdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView txvOutput;
    private Calendar dt = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvOutput = findViewById(R.id.txvoutput);

        Button btnDate = findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = dt.get(Calendar.YEAR);
                int month = dt.get(Calendar.MONTH);
                int dayOfMonth = dt.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dlg = new DatePickerDialog(MainActivity.this, MainActivity.this, year, month, dayOfMonth);
                dlg.show();
            }
        });

        Button btnTime = findViewById(R.id.btnTime);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hourOfDay = dt.get(Calendar.HOUR_OF_DAY);
                int minute = dt.get(Calendar.MINUTE);
                TimePickerDialog dlg = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Display the selected time in the TextView
                        txvOutput.setText("Time Selected: " + hourOfDay + ":" + minute);
                    }
                }, hourOfDay, minute, true);
                dlg.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // Display the selected date in the TextView
        txvOutput.setText("Date Selected: " + year + "-" + (month + 1) + "-" + dayOfMonth);
    }
}
