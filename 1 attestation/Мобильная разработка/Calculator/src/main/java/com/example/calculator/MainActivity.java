package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
// подключаем модуль для вычислений
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // наш основной экран для ввода и вывода результатов
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {

            // как только мы "тапнем" на экран, то подпись "enter in a value" исчезнет
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }

    // метод для обновления содержимого дисплея
    // как для последовательного ввода, так и для непоследовательного
    // (если пользователь хочет добавить пропущенные символы в середине выражения)
    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void oneBTN(View view) {
        updateText("1");
    }

    public void twoBTN(View view) {
        updateText("2");
    }

    public void threeBTN(View view) {
        updateText("3");
    }

    public void fourBTN(View view) {
        updateText("4");
    }

    public void fiveBTN(View view) {
        updateText("5");
    }

    public void sixBTN(View view) {
        updateText("6");
    }

    public void sevenBTN(View view) {
        updateText("7");
    }

    public void eightBTN(View view) {
        updateText("8");
    }

    public void nineBTN(View view) {
        updateText("9");
    }

    public void zeroBTN(View view) {
        updateText("0");
    }

    // так как это кнопка очистки, то она просто обнуляет выражение на экране
    public void clearBTN(View view) {
        display.setText("");
    }

    // метод для вставки скобок
    public void parenthesesBTN(View view) {

        int cursorPos = display.getSelectionStart(); // позиция курсора на экране
        int openPar = 0; // счетчик открытых скобок "("
        int closedPar = 0; //счетчик для закрытых скобок ")"
        int textLen = display.getText().length();
        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i + 1).equals(")")) {
                closedPar += 1;
            }
        }
        // если кол-во открывающих и закрывающих скобок равно или последний символ на экране == "("
        // то вставляем открвающую скобку
        if (openPar == closedPar || display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
            updateText("(");
        }

        // а если кол-во закрывающих ск. меньше и последний символ не "("
        // то вставляем ")"
        else if (closedPar < openPar && !display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
            updateText(")");
        }
        // обновляем позицию курсора
        display.setSelection(cursorPos + 1);
    }

    public void exponentBTN(View view) {
        updateText("^");
    }

    public void divisionBTN(View view) {
        updateText("÷");
    }

    public void multiplicationBTN(View view) {
        updateText("×");
    }

    public void minusBTN(View view) {
        updateText("-");
    }

    public void plusBTN(View view) {
        updateText("+");
    }

    // кнопка вывода результата
    public void equalsBTN(View view) {
        String userExp = display.getText().toString();
        // мы заменяем все "красивые" знаки деления и умножения на стандратные
        // для понимания библиотеки
        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        // производим вычисления при помощи скачанной и подключенной библиотеки
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }

    public void pointBTN(View view) {
        updateText(".");
    }

    public void plusMinusBTN(View view) {
        updateText("-");
    }

    public void backspaceBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
}