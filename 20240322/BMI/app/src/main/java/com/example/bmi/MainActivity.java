package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

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

        TextView txvShow = (TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    public void onClick(View v) {
        EditText editHeight = (EditText) findViewById(R.id.editHeight);
        EditText editWeight = (EditText) findViewById(R.id.editWeight);

        if (v.getId() == R.id.btnCalc) {
            double height = Double.parseDouble(editHeight.getText().toString());
            double Weight = Double.parseDouble(editHeight.getText().toString());
            double bmi = Weight / Math.pow(height / 100.0, 2);
            if (bmi >= 24)
                txvShow.setTextColor(color.RED);
            else if (bmi < 18.5)
                txvShow.setTextColor(color.BLUE);
            else
                txvShow.setTextColor(color.GREEN);
            txvShow.setText(String.format("%.2f", bmi));

        }
        else {
            editHeight.setText("0");
            editWeight.setText("0");
            txvShow.setText("");

        }

    }
}

