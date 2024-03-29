package com.example.bmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        Button btnCalc = findViewById(R.id.btnCalc);
        Button btnClear = findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    public void onClick(View v) {
        EditText editHeight = findViewById(R.id.editHeight);
        EditText editWeight = findViewById(R.id.editWeight);

        if (v.getId() == R.id.btnCalc) {
            double height = Double.parseDouble(editHeight.getText().toString());
            double weight = Double.parseDouble(editWeight.getText().toString());
            double bmi = weight / Math.pow(height / 100.0, 2);
            if (bmi >= 24)
                txvShow.setTextColor(Color.RED);
            else if (bmi < 18.5)
                txvShow.setTextColor(Color.BLUE);
            else
                txvShow.setTextColor(Color.GREEN);
            txvShow.setText(String.format("%.2f", bmi));

        } else {
            editHeight.setText("0");
            editWeight.setText("0");
            txvShow.setText("");

        }

    }
}
