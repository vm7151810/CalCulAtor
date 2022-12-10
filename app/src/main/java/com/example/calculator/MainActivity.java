package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView res, cal;
    MaterialButton button_c;
    MaterialButton button_m, button_d, button_p, button_a, button_mi, button_e ;
    MaterialButton button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res=findViewById(R.id.result);
        cal=findViewById(R.id.calc);

        assignId(button_c, R.id.button_c);
        assignId(button_m, R.id.button_m);
        assignId(button_a, R.id.button_a);
        assignId(button_mi, R.id.button_mi);
        assignId(button_e, R.id.button_e);
        assignId(button_p, R.id.button_p);
        assignId(button_d, R.id.button_d);
        assignId(button_0, R.id.button_0);
        assignId(button_1, R.id.button_1);
        assignId(button_2, R.id.button_2);
        assignId(button_3, R.id.button_3);
        assignId(button_4, R.id.button_4);
        assignId(button_5, R.id.button_5);
        assignId(button_6, R.id.button_6);
        assignId(button_7, R.id.button_7);
        assignId(button_8, R.id.button_8);
        assignId(button_9, R.id.button_9);
    }

    void assignId(MaterialButton btn, int id) {
        btn=findViewById(id) ;
        btn.setOnClickListener(this);
    }

    int prev = 0 ; String p = "" ;
    int next = 0 ; String n = "" ;
    String c = "";
    String r = "" ;
    int re = 0 ;

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view ;
        String buttonText = button.getText().toString();
        c += buttonText;

        if (buttonText.equals("C")){
            cal.setText("");
            res.setText("");
            prev = 0; next = 0 ; c = "" ; re = 0 ; p = "" ; n = "" ; r = "" ;
            return;
        }
        else if (buttonText.equals("=")){
            cal.setText(""); re = 0 ;
            for (int i = 0 ; i < c.length() ; i++) {
                if (c.charAt(i) == '^') {
                    int j = i - 1 ; String x = "" ;
                    while (j >= 0) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/') {
                            break ;
                        }
                        x += c.charAt(j) ; j-- ;
                    }
                    p = "" ;
                    for (int k = x.length() - 1 ; k >= 0 ; k--) { p += x.charAt(k) ; }
                    j = i + 1 ; n = "" ;
                    while (j < c.length()) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/' || c.charAt(j) == '^' || c.charAt(j) == '=') {
                            break ;
                        }
                        n += c.charAt(j) ; j++ ;
                    }
                    prev = Integer.parseInt(p) ; next = Integer.parseInt(n) ;
                    re = (int)Math.pow(prev, next) ; r = Integer.toString(re) ;
                    c = c.replace(p + "^" + n, r) ;
                }
            }
            cal.setText(c);
            for (int i = 0 ; i < c.length() ; i++) {
                if (c.charAt(i) == '/') {
                    int j = i - 1 ; String x = "" ;
                    while (j >= 0) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/') {
                            break ;
                        }
                        x += c.charAt(j) ; j-- ;
                    }
                    p = "" ;
                    for (int k = x.length() - 1 ; k >= 0 ; k--) { p += x.charAt(k) ; }
                    j = i + 1 ; n = "" ;
                    while (j < c.length()) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/' || c.charAt(j) == '^' || c.charAt(j) == '=') {
                            break ;
                        }
                        n += c.charAt(j) ; j++ ;
                    }
                    prev = Integer.parseInt(p) ; next = Integer.parseInt(n) ;
                    re = prev/next ; r = Integer.toString(re) ;
                    c = c.replace(p + "/" + n, r) ;
                }
            }
            cal.setText(c);
            for (int i = 0 ; i < c.length() ; i++) {
                if (c.charAt(i) == '*') {
                    int j = i - 1 ; String x = "" ;
                    while (j >= 0) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/') {
                            break ;
                        }
                        x += c.charAt(j) ; j-- ;
                    }
                    p = "" ;
                    for (int k = x.length() - 1 ; k >= 0 ; k--) { p += x.charAt(k) ; }
                    j = i + 1 ; n = "" ;
                    while (j < c.length()) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/' || c.charAt(j) == '^' || c.charAt(j) == '=') {
                            break ;
                        }
                        n += c.charAt(j) ; j++ ;
                    }
                    prev = Integer.parseInt(p) ; next = Integer.parseInt(n) ;
                    re = prev*next ; r = Integer.toString(re) ;
                    c = c.replace(p + "*" + n, r) ;
                }
            }
            cal.setText(c);
            for (int i = 0 ; i < c.length() ; i++) {
                if (c.charAt(i) == '+') {
                    int j = i - 1 ; String x = "" ;
                    while (j >= 0) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/') {
                            break ;
                        }
                        x += c.charAt(j) ; j-- ;
                    }
                    p = "" ;
                    for (int k = x.length() - 1 ; k >= 0 ; k--) { p += x.charAt(k) ; }
                    j = i + 1 ; n = "" ;
                    while (j < c.length()) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/' || c.charAt(j) == '^' || c.charAt(j) == '=') {
                            break ;
                        }
                        n += c.charAt(j) ; j++ ;
                    }
                    prev = Integer.parseInt(p) ; next = Integer.parseInt(n) ;
                    re = prev + next ; r = Integer.toString(re) ;
                    c = c.replace(p + "+" + n, r) ;
                }
            }
            cal.setText(c);
            for (int i = 0 ; i < c.length() ; i++) {
                if (c.charAt(i) == '-') {
                    int j = i - 1 ; String x = "" ;
                    while (j >= 0) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/') {
                            break ;
                        }
                        x += c.charAt(j) ; j-- ;
                    }
                    p = "" ;
                    for (int k = x.length() - 1 ; k >= 0 ; k--) { p += x.charAt(k) ; }
                    j = i + 1 ; n = "" ;
                    while (j < c.length()) {
                        if (c.charAt(j) == '+' || c.charAt(j) == '*' || c.charAt(j) == '-' || c.charAt(j) == '/' || c.charAt(j) == '^' || c.charAt(j) == '=') {
                            break ;
                        }
                        n += c.charAt(j) ; j++ ;
                    }
                    prev = Integer.parseInt(p) ; next = Integer.parseInt(n) ;
                    re = prev - next ; r = Integer.toString(re) ;
                    c = c.replace(p + "-" + n, r) ;
                }
            }
            cal.setText(c);

            r = Integer.toString(re) ;
            res.setText(r);
        }
        cal.setText(c);
    }
}