package com.krayapp.androhw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeChangerActivity extends AppCompatActivity {
   private Button returnButton;
   private RadioButton darkButton;
   private RadioButton lightButton;
   private TextView switchCheck; //проверка свича
   private static int theme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (theme == 0) {
            setTheme(R.style.MyCalcStyleLight);
        } else {
            setTheme(R.style.MyCalcStyleDark);
        }
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
                Intent intentTheme = new Intent();
                intentTheme.putExtra(MainActivity.THEME, theme);
                setResult(RESULT_OK, intentTheme);
                finish();
            }
        });

        darkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = 1;
                recreate();
            }
        });
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = 0;
                recreate();
            }
        });
    }

}
