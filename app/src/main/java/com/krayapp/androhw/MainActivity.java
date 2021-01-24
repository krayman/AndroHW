package com.krayapp.androhw;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultView;
    private TextView historyView;
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
    private Button buttonSettings;

    int resetCount = 0;
    int eqCounter = 0;
    private CalcLogic calcLogic = new CalcLogic();
    private final static String keyHistory = "history";
    private final static int THEME_KEY = 777;


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
        buttonSettings = findViewById(R.id.setting_button);
        setClickButtons();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case (R.id.button1):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 1));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 1));
                }
                resetCount = 0;
                break;
            case (R.id.button2):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 2));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 2));
                }
                resetCount = 0;
                break;
            case (R.id.button3):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 3));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 3));
                }
                resetCount = 0;
                break;
            case (R.id.button4):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 4));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 4));
                }
                resetCount = 0;
                break;
            case (R.id.button5):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 5));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 5));
                }
                resetCount = 0;
                break;
            case (R.id.button6):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 6));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 6));
                }
                resetCount = 0;
                break;
            case (R.id.button7):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 7));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 7));
                }
                resetCount = 0;
                break;
            case (R.id.button8):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 8));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 8));
                }
                resetCount = 0;
                break;
            case (R.id.button9):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 9));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 9));
                }
                resetCount = 0;
                break;
            case (R.id.button0):
                if (resultView.getText().toString().equals("0") || eqCounter > 0) {
                    resultView.setText(String.format("%d", 0));
                    eqCounter = 0;
                } else {
                    resultView.append(String.format("%d", 0));
                }
                resetCount = 0;
                break;
            case (R.id.multibtn):
                eqCounter = 0;
                resultView.append(String.format("%c", '*'));
                break;
            case (R.id.splitbtn):
                eqCounter = 0;
                resultView.append(String.format("%c", '÷'));
                break;
            case (R.id.plus_btn):
                eqCounter = 0;
                resultView.append(String.format("%c", '+'));
                break;
            case (R.id.minusbtn):
                eqCounter = 0;
                resultView.append(String.format("%c", '-'));
                break;
            case (R.id.resetbtn):
                resetCount++;
                eqCounter = 0;
                if (resetCount == 2) {
                    historyView.setText(" ");
                    calcLogic.setHistoryView(" ");
                    resetCount = 0;
                }
                resultView.setText("0");
                calcLogic.setRes(0);
                calcLogic.setResultView(" ");
                break;
            case (R.id.equ_button):
                eqCounter++;
                calcLogic.equalsMethod(resultView.getText().toString());
                resultView.setText(calcLogic.getResultView());
                historyView.setText(calcLogic.getHistoryView());
                break;
            case (R.id.setting_button):
                Intent settingsActivity = new Intent(this, ThemeChangerActivity.class);
                startActivityForResult(settingsActivity, THEME_KEY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != THEME_KEY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (requestCode == RESULT_OK) {

        }
    }

    private void setClickButtons() {
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
        buttonSettings.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (calcLogic.getResultView() == null) {
            calcLogic.setResultView("0");
        }
        outState.putParcelable(keyHistory, calcLogic);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calcLogic = savedInstanceState.getParcelable(keyHistory);
        assert calcLogic != null;
        setResnHistory(calcLogic.getResultView(), calcLogic.getHistoryView());
    }

    private void setResnHistory(String result, String history) {
        resultView.setText(String.format("%s", result));
        historyView.setText(String.format("%s", history));
    }
}