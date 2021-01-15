package com.krayapp.androhw;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonMltpl;
    private Button buttonMinus;
    private Button buttonPlus;
    private Button buttonSplit;
    private Button buttonReset;
    private Button buttonEqu;
    private TextView resultView;
    private TextView historyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        resultView = findViewById(R.id.resultView);
        historyView = findViewById(R.id.historyView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonMltpl = findViewById(R.id.multibtn);
        buttonMinus = findViewById(R.id.minusbtn);
        buttonPlus = findViewById(R.id.plus_btn);
        buttonSplit = findViewById(R.id.splitbtn);
        buttonReset = findViewById(R.id.resetbtn);
        buttonEqu = findViewById(R.id.equ_button);
        initButton();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.button1):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 1));
                } else {
                    resultView.append(String.format("%d", 1));
                }
                break;
            case (R.id.button2):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 2));
                } else {
                    resultView.append(String.format("%d", 2));
                }
                break;
            case (R.id.button3):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 3));
                } else {
                    resultView.append(String.format("%d", 3));
                }
                break;
            case (R.id.button4):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 4));
                } else {
                    resultView.append(String.format("%d", 4));
                }
                break;
            case (R.id.button5):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 5));
                } else {
                    resultView.append(String.format("%d", 5));
                }
                break;
            case (R.id.button6):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 6));
                } else {
                    resultView.append(String.format("%d", 6));
                }
                break;
            case (R.id.button7):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 7));
                } else {
                    resultView.append(String.format("%d", 7));
                }
                break;
            case (R.id.button8):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 8));
                } else {
                    resultView.append(String.format("%d", 8));
                }
                break;
            case (R.id.button9):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 9));
                } else {
                    resultView.append(String.format("%d", 9));
                }
                break;
            case (R.id.button0):
                if (resultView.getText().toString().equals("0")) {
                    resultView.setText(String.format("%d", 0));
                } else {
                    resultView.append(String.format("%d", 0));
                }
                break;
            case (R.id.multibtn):
                resultView.append(String.format("%c", '*'));
                break;
            case (R.id.splitbtn):
                resultView.append(String.format("%c", '÷'));
                break;
            case (R.id.plus_btn):
                resultView.append(String.format("%c", '+'));
                break;
            case (R.id.minusbtn):
                resultView.append(String.format("%c", '-'));
                break;
            case (R.id.resetbtn):
                resultView.setText("0");
                break;
            case (R.id.equ_button):
                equalsMethod(resultView.getText().toString());
                break;
        }
    }


    private void initButton() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonMltpl.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonSplit.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        buttonEqu.setOnClickListener(this);
    }

    private void equalsMethod(String result) {
        if (result.indexOf('+') != -1) {
            String[] values = result.split("\\+");
            Integer value1 = Integer.valueOf(values[0]);
            Integer value2 = Integer.valueOf(values[1]);
            resultView.setText(String.format("%s", value1 + value2));
        }else if(result.indexOf('*') != -1){
            String[] values = result.split("\\*");
            Integer value1 = Integer.valueOf(values[0]);
            Integer value2 = Integer.valueOf(values[1]);
            resultView.setText(String.format("%s", value1 * value2));
        }else if(result.indexOf('÷') != -1){
            String[] values = result.split("÷");
            Integer value1 = Integer.valueOf(values[0]);
            Integer value2 = Integer.valueOf(values[1]);
            resultView.setText(String.format("%s", value1 / value2));
        }else if(result.indexOf('-') != -1){
            String[] values = result.split("-");
            Integer value1 = Integer.valueOf(values[0]);
            Integer value2 = Integer.valueOf(values[1]);
            resultView.setText(String.format("%s", value1 - value2));
        }
        historyView.append(String.format("%s \n", result));
    }
}