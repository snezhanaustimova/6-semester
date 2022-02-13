package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText operator;
    EditText n1;
    EditText n2;
    Button calc;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        operator = findViewById(R.id.operator);
        result = findViewById(R.id.result);
        calc = findViewById(R.id.calculate);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double number1 = new Double(n1.getText().toString());
                    Double number2 = new Double(n2.getText().toString());
                    String op = operator.getText().toString();
                    if (op.equals("+")) {
                        result.setText(Double.toString(number1 + number2));
                    } else if (op.equals("-")) {
                        result.setText(Double.toString(number1 - number2));
                    } else if (op.equals("*")) {
                        result.setText(Double.toString(number1 * number2));
                    } else if (op.equals("/")) {
                        result.setText(Double.toString(number1 / number2));
                    } else {
                        result.setText("Нет такого знака!");
                    }
                } catch (Exception e) {
                    result.setText("Ошибка ввода!");
                }
            }
        });
    }



}