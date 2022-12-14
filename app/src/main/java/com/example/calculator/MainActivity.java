package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView results, calculations;
    MaterialButton button_c;
    MaterialButton button_m, button_d, button_p, button_a, button_mi, button_e ;
    MaterialButton button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        results=findViewById(R.id.result);
        calculations=findViewById(R.id.calc);

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

    int prevNumber = 0 ; String prevNumberString = "" ;
    int nextNumber = 0 ; String nextNumberString = "" ;
    String calculation = "";
    String resultString = "" ;
    int result = 0 ;

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view ;
        String buttonText = button.getText().toString();

        if (buttonText.equals("C")){
            calculations.setText("");
            results.setText("");
            prevNumber = 0; nextNumber = 0 ; calculation = "" ; result = 0 ; prevNumberString = "" ; nextNumberString = "" ; resultString = "" ;
            return;
        }
        else if (buttonText.equals("=")){
            calculations.setText(""); result = 0 ;
            try {
                for (int i = 0; i < calculation.length(); i++) {
                    if (calculation.charAt(i) == '^') {
                        int j = i - 1;
                        String reversedNumber = "";
                        while (j >= 0) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/') {
                                break;
                            }
                            reversedNumber += calculation.charAt(j);
                            j--;
                        }
                        prevNumberString = "";
                        for (int k = reversedNumber.length() - 1; k >= 0; k--) {
                            prevNumberString += reversedNumber.charAt(k);
                        }
                        j = i + 1;
                        nextNumberString = "";
                        while (j < calculation.length()) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/' || calculation.charAt(j) == '^') {
                                break;
                            }
                            nextNumberString += calculation.charAt(j);
                            j++;
                        }
                        prevNumber = Integer.parseInt(prevNumberString);
                        nextNumber = Integer.parseInt(nextNumberString);
                        result = (int) Math.pow(prevNumber, nextNumber);
                        resultString = Integer.toString(result);
                        calculation = calculation.replace(prevNumberString + "^" + nextNumberString, resultString);
                    }
                }
                for (int i = 0; i < calculation.length(); i++) {
                    if (calculation.charAt(i) == '/') {
                        int j = i - 1;
                        String reversedNumber = "";
                        while (j >= 0) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/') {
                                break;
                            }
                            reversedNumber += calculation.charAt(j);
                            j--;
                        }
                        prevNumberString = "";
                        for (int k = reversedNumber.length() - 1; k >= 0; k--) {
                            prevNumberString += reversedNumber.charAt(k);
                        }
                        j = i + 1;
                        nextNumberString = "";
                        while (j < calculation.length()) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/' || calculation.charAt(j) == '^') {
                                break;
                            }
                            nextNumberString += calculation.charAt(j);
                            j++;
                        }
                        prevNumber = Integer.parseInt(prevNumberString);
                        nextNumber = Integer.parseInt(nextNumberString);
                        result = prevNumber / nextNumber;
                        resultString = Integer.toString(result);
                        calculation = calculation.replace(prevNumberString + "/" + nextNumberString, resultString);
                    }
                }
                for (int i = 0; i < calculation.length(); i++) {
                    if (calculation.charAt(i) == '*') {
                        int j = i - 1;
                        String reversedNumber = "";
                        while (j >= 0) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/') {
                                break;
                            }
                            reversedNumber += calculation.charAt(j);
                            j--;
                        }
                        prevNumberString = "";
                        for (int k = reversedNumber.length() - 1; k >= 0; k--) {
                            prevNumberString += reversedNumber.charAt(k);
                        }
                        j = i + 1;
                        nextNumberString = "";
                        while (j < calculation.length()) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/' || calculation.charAt(j) == '^') {
                                break;
                            }
                            nextNumberString += calculation.charAt(j);
                            j++;
                        }
                        prevNumber = Integer.parseInt(prevNumberString);
                        nextNumber = Integer.parseInt(nextNumberString);
                        result = prevNumber * nextNumber;
                        resultString = Integer.toString(result);
                        calculation = calculation.replace(prevNumberString + "*" + nextNumberString, resultString);
                    }
                }
                for (int i = 0; i < calculation.length(); i++) {
                    if (calculation.charAt(i) == '+') {
                        int j = i - 1;
                        String reversedNumber = "";
                        while (j >= 0) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/') {
                                break;
                            }
                            reversedNumber += calculation.charAt(j);
                            j--;
                        }
                        prevNumberString = "";
                        for (int k = reversedNumber.length() - 1; k >= 0; k--) {
                            prevNumberString += reversedNumber.charAt(k);
                        }
                        j = i + 1;
                        nextNumberString = "";
                        while (j < calculation.length()) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/' || calculation.charAt(j) == '^') {
                                break;
                            }
                            nextNumberString += calculation.charAt(j);
                            j++;
                        }
                        prevNumber = Integer.parseInt(prevNumberString);
                        nextNumber = Integer.parseInt(nextNumberString);
                        result = prevNumber + nextNumber;
                        resultString = Integer.toString(result);
                        calculation = calculation.replace(prevNumberString + "+" + nextNumberString, resultString);
                    }
                }
                for (int i = 0; i < calculation.length(); i++) {
                    if (calculation.charAt(i) == '-') {
                        int j = i - 1;
                        String reversedNumber = "";
                        while (j >= 0) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/') {
                                break;
                            }
                            reversedNumber += calculation.charAt(j);
                            j--;
                        }
                        prevNumberString = "";
                        for (int k = reversedNumber.length() - 1; k >= 0; k--) {
                            prevNumberString += reversedNumber.charAt(k);
                        }
                        j = i + 1;
                        nextNumberString = "";
                        while (j < calculation.length()) {
                            if (calculation.charAt(j) == '+' || calculation.charAt(j) == '*' || calculation.charAt(j) == '-' || calculation.charAt(j) == '/' || calculation.charAt(j) == '^' || calculation.charAt(j) == '=') {
                                break;
                            }
                            nextNumberString += calculation.charAt(j);
                            j++;
                        }
                        prevNumber = Integer.parseInt(prevNumberString);
                        nextNumber = Integer.parseInt(nextNumberString);
                        result = prevNumber - nextNumber;
                        resultString = Integer.toString(result);
                        calculation = calculation.replace(prevNumberString + "-" + nextNumberString, resultString);
                    }
                }
            }
            catch (Exception e){
                prevNumber = 0; nextNumber = 0 ; calculation = "" ; result = 0 ; prevNumberString = "" ; nextNumberString = "" ; resultString = "" ;
                calculations.setText("");
                results.setText("Error");
                return ;
            }
            calculations.setText(""); calculation = "" ;
            results.setText(resultString);
            return ;
        }
        else {
            calculation += buttonText;
        }
        calculations.setText(calculation);
    }
}