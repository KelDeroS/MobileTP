package com.example.mobiletp;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText angleInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angleInput = findViewById(R.id.angle_input);
        resultText = findViewById(R.id.result_text);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTangent();
            }
        });
    }

    private void calculateTangent() {
        String angleString = angleInput.getText().toString();
        if (!angleString.isEmpty()) {
            double angle = Double.parseDouble(angleString);
            double radians = Math.toRadians(angle);
            DecimalFormat decimalFormat = new DecimalFormat("#.#####");
            if ((angle - 90) % 180 == 0) {
                resultText.setText("Угол " + angleString + " градусов не имеет тангенса.");
            } else {
                double tangent = Math.tan(radians);
                resultText.setText("tan(" + angleString + ") = " + decimalFormat.format(tangent));
            }
        } else {
            resultText.setText("Введите угол в градусах.");
        }
    }
}