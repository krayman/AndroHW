package com.krayapp.androhw;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class ThemeChangerActivity extends AppCompatActivity {
    Button returnButton;
    RadioButton darkButton;
    RadioButton lightButton;
    TextView switchCheck; //проверка свича

    private static final String NameSharedPreference = "LOGIN";
    private static final String appTheme = "APP_THEME";

    private final static int lightTheme = 0;
    private final static int darkTheme = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyCalcStyleLight));
        setContentView(R.layout.activity_theme_changer);
        initThemeRadio();
    }


    private void initThemeRadio() {
        returnButton = findViewById(R.id.returnButton);
        darkButton = findViewById(R.id.darkButton);
        lightButton = findViewById(R.id.lightButton);
        switchCheck = findViewById(R.id.switchCheck);
        clickListener();
    }

    private void clickListener() {
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        darkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(darkTheme);
                recreate();
            }
        });
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(lightTheme);
                recreate();
            }
        });
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case lightTheme:
                return R.style.MyCalcStyleLight;
            case darkTheme:
                return R.style.MyCalcStyleDark;
            default:
                return R.style.MyCalcStyleLight;
        }
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(appTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme, codeStyle);
        editor.apply();
    }
}