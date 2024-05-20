package com.example.wagecalc;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHours;
    private EditText editTextRate;
    private Button buttonCalculate;
    private Button buttonCalculateWeekly;
    private Button buttonClear;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHours = findViewById(R.id.editTextHours);
        editTextRate = findViewById(R.id.editTextRate);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculateWeekly = findViewById(R.id.buttonCalculateWeekly);
        buttonClear = findViewById(R.id.buttonClear);
        textViewResult = findViewById(R.id.textViewResult);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateWage(false);
            }
        });

        buttonCalculateWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateWage(true);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void calculateWage(boolean isWeekly) {
        String hoursStr = editTextHours.getText().toString();
        String rateStr = editTextRate.getText().toString();

        if (hoursStr.isEmpty() || rateStr.isEmpty()) {
            Toast.makeText(this, "Please enter both hours and rate", Toast.LENGTH_SHORT).show();
            return;
        }

        double hours = Double.parseDouble(hoursStr);
        double rate = Double.parseDouble(rateStr);

        double totalWage = hours * rate;

        if (isWeekly) {
            totalWage *= 7;



        }

        textViewResult.setText("Total Wage: PHP " + totalWage);
    }

    private void clearFields() {
        editTextHours.setText("");
        editTextRate.setText("");
        textViewResult.setText("Total Wage: ");
    }
}