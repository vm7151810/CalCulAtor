package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView results, calculations;
    MaterialButton button_m, button_d, button_p, button_a, button_mi, button_e, button_c, button_com, button_arr, button_h ;
    MaterialButton button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        results=findViewById(R.id.result);
        calculations=findViewById(R.id.calc);

        createNotificationChannel();

        assignId(button_c, R.id.button_c);
        assignId(button_h, R.id.button_h);
        assignId(button_m, R.id.button_m);
        assignId(button_a, R.id.button_a);
        assignId(button_mi, R.id.button_mi);
        assignId(button_e, R.id.button_e);
        assignId(button_p, R.id.button_p);
        assignId(button_d, R.id.button_d);
        assignId(button_com, R.id.button_com);
        assignId(button_arr, R.id.button_arr);
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
    boolean array = false ; boolean second = false ;
    int lengthOne = 0 ; int lengthTwo = 0 ;

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view ;
        String buttonText = button.getText().toString();

        if (buttonText.equals("H")) {
            startActivity(new Intent(MainActivity.this, History.class));
        }
        else if (buttonText.equals("C")){
            calculations.setText("");
            results.setText("");
            prevNumber = 0; nextNumber = 0 ; calculation = "" ; result = 0 ; prevNumberString = "" ; nextNumberString = "" ; resultString = "" ;
            array = false ; lengthTwo = 0 ; lengthOne = 0 ; second = false ;
            lengthOne = 0 ; lengthTwo = 0 ;
        }
        else if (buttonText.equals("=")){
            if (array) {
                calculation += "]" ;
                calculations.setText(calculation);
                try {
                    if (lengthTwo != lengthOne) {
                        calculations.setText("");
                        results.setText("Unequal arrays");
                        return ;
                    }
                    else {
                        int firstIndex = 1 ; int secondIndex = lengthOne + lengthOne + 3 ;
                        resultString = "[" ;
                        if (calculation.charAt(lengthOne + lengthOne + 1) == '^') {
                            while(firstIndex < lengthOne + lengthOne) {
                                prevNumberString = "" ; nextNumberString = "" ;
                                for (int j = firstIndex ; j < lengthOne + lengthOne ;j++) {
                                    if (calculation.charAt(firstIndex) == ',' || calculation.charAt(firstIndex) == ']') {
                                        firstIndex += 1 ;
                                        break ;
                                    }
                                    prevNumberString += calculation.charAt(firstIndex);
                                    firstIndex += 1 ;
                                }
                                for (int j = secondIndex ; j < 4*lengthOne + 3 ;j++) {
                                    if (calculation.charAt(secondIndex) == ',' || calculation.charAt(secondIndex) == ']') {
                                        secondIndex += 1 ;
                                        break ;
                                    }
                                    nextNumberString += calculation.charAt(secondIndex);
                                    secondIndex += 1 ;
                                }
                                prevNumber = Integer.parseInt(prevNumberString); nextNumber = Integer.parseInt(nextNumberString);
                                result = (int) Math.pow(prevNumber, nextNumber);
                                resultString += Integer.toString(result); if(calculation.charAt(firstIndex) != ']') { resultString += "," ; }
                            }
                        }
                        else if (calculation.charAt(lengthOne + lengthOne + 1) == '/') {
                            while(firstIndex < lengthOne + lengthOne) {
                                prevNumberString = "" ; nextNumberString = "" ;
                                for (int j = firstIndex ; j < lengthOne + lengthOne ;j++) {
                                    if (calculation.charAt(firstIndex) == ',' || calculation.charAt(firstIndex) == ']') {
                                        firstIndex += 1 ;
                                        break ;
                                    }
                                    prevNumberString += calculation.charAt(firstIndex);
                                    firstIndex += 1 ;
                                }
                                for (int j = secondIndex ; j < 4*lengthOne + 3 ;j++) {
                                    if (calculation.charAt(secondIndex) == ',' || calculation.charAt(secondIndex) == ']') {
                                        secondIndex += 1 ;
                                        break ;
                                    }
                                    nextNumberString += calculation.charAt(secondIndex);
                                    secondIndex += 1 ;
                                }
                                prevNumber = Integer.parseInt(prevNumberString); nextNumber = Integer.parseInt(nextNumberString);
                                result = prevNumber / nextNumber;
                                resultString += Integer.toString(result); if(calculation.charAt(firstIndex) != ']') { resultString += "," ; }
                            }
                        }
                        else if (calculation.charAt(lengthOne + lengthOne + 1) == '*') {
                            while(firstIndex < lengthOne + lengthOne) {
                                prevNumberString = "" ; nextNumberString = "" ;
                                for (int j = firstIndex ; j < lengthOne + lengthOne ;j++) {
                                    if (calculation.charAt(firstIndex) == ',' || calculation.charAt(firstIndex) == ']') {
                                        firstIndex += 1 ;
                                        break ;
                                    }
                                    prevNumberString += calculation.charAt(firstIndex);
                                    firstIndex += 1 ;
                                }
                                for (int j = secondIndex ; j < 4*lengthOne + 3 ;j++) {
                                    if (calculation.charAt(secondIndex) == ',' || calculation.charAt(secondIndex) == ']') {
                                        secondIndex += 1 ;
                                        break ;
                                    }
                                    nextNumberString += calculation.charAt(secondIndex);
                                    secondIndex += 1 ;
                                }
                                prevNumber = Integer.parseInt(prevNumberString); nextNumber = Integer.parseInt(nextNumberString);
                                result = prevNumber * nextNumber;
                                resultString += Integer.toString(result); if(calculation.charAt(firstIndex) != ']') { resultString += "," ; }
                            }
                        }
                        else if (calculation.charAt(lengthOne + lengthOne + 1) == '+') {
                            while(firstIndex < lengthOne + lengthOne) {
                                prevNumberString = "" ; nextNumberString = "" ;
                                for (int j = firstIndex ; j < lengthOne + lengthOne ;j++) {
                                    if (calculation.charAt(firstIndex) == ',' || calculation.charAt(firstIndex) == ']') {
                                        firstIndex += 1 ;
                                        break ;
                                    }
                                    prevNumberString += calculation.charAt(firstIndex);
                                    firstIndex += 1 ;
                                }
                                for (int j = secondIndex ; j < 4*lengthOne + 3 ;j++) {
                                    if (calculation.charAt(secondIndex) == ',' || calculation.charAt(secondIndex) == ']') {
                                        secondIndex += 1 ;
                                        break ;
                                    }
                                    nextNumberString += calculation.charAt(secondIndex);
                                    secondIndex += 1 ;
                                }
                                prevNumber = Integer.parseInt(prevNumberString); nextNumber = Integer.parseInt(nextNumberString);
                                result = prevNumber + nextNumber;
                                resultString += Integer.toString(result); if(calculation.charAt(firstIndex) != ']') { resultString += "," ; }
                            }
                        }
                        else if (calculation.charAt(lengthOne + lengthOne + 1) == '-') {
                            while(firstIndex < lengthOne + lengthOne) {
                                prevNumberString = "" ; nextNumberString = "" ;
                                for (int j = firstIndex ; j < lengthOne + lengthOne ;j++) {
                                    if (calculation.charAt(firstIndex) == ',' || calculation.charAt(firstIndex) == ']') {
                                        firstIndex += 1 ;
                                        break ;
                                    }
                                    prevNumberString += calculation.charAt(firstIndex);
                                    firstIndex += 1 ;
                                }
                                for (int j = secondIndex ; j < 4*lengthOne + 3 ;j++) {
                                    if (calculation.charAt(secondIndex) == ',' || calculation.charAt(secondIndex) == ']') {
                                        secondIndex += 1 ;
                                        break ;
                                    }
                                    nextNumberString += calculation.charAt(secondIndex);
                                    secondIndex += 1 ;
                                }
                                prevNumber = Integer.parseInt(prevNumberString); nextNumber = Integer.parseInt(nextNumberString);
                                result = prevNumber - nextNumber;
                                resultString += Integer.toString(result); if(calculation.charAt(firstIndex) != ']') { resultString += "," ; }
                            }
                        }
                        resultString += "]" ;
                        results.setText(resultString);
                        historyView history = new historyView(calculation.toString(), resultString.toString());
                        prevNumber = 0; nextNumber = 0 ; calculation = "" ; result = 0 ; prevNumberString = "" ; nextNumberString = "" ; resultString = "" ;
                        array = false ; lengthTwo = 0 ; lengthOne = 0 ; second = false ;
                        lengthOne = 0 ; lengthTwo = 0 ;
                    }
                }
                catch (Exception e) {
                    calculations.setText("");
                    resultString = "Error" ;
                    results.setText(resultString);
                    return ;
                }
            }
            else {
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
                    if (calculation.charAt(0) == '-') {
                        result *= -1;
                        resultString = Integer.toString(result);
                    }
                }
                catch (Exception e){
                    prevNumber = 0; nextNumber = 0 ; calculation = "" ; result = 0 ; prevNumberString = "" ; nextNumberString = "" ; resultString = "" ;
                    calculations.setText("");
                    resultString = "Error" ;
                    results.setText(resultString);
                    return ;
                }
                calculations.setText(""); calculation = "" ;
                results.setText(resultString);
                createNotificationChannel();
                scheduleNotification(result) ;
            }
        }
        else if (buttonText.equals("arr")) {
            array = true;
            calculation = "[" ;
            calculations.setText(calculation);
        }
        else if (array) {
            if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("/") || buttonText.equals("^") || buttonText.equals("*")) {
                second = true ; calculation += "]" ; calculation += buttonText ; calculation += "[" ;
            }
            else if (buttonText.equals(",")) {
                calculation += buttonText ;
                calculations.setText(calculation);
            }
            else if (second) {
                lengthTwo += 1 ;
                calculation += buttonText ;
                calculations.setText(calculation);
            }
            else {
                lengthOne += 1 ;
                if (calculation.length() > 15){
                    resultString = "Too big" ;
                    results.setText(resultString);
                    calculations.setText(""); calculation = "" ;
                    return ;
                }
                calculation += buttonText ;
                calculations.setText(calculation);
            }
        }
        else {
            calculation += buttonText;
            if (calculation.length() > 8){
                resultString = "Too big" ;
                results.setText(resultString);
                calculations.setText(""); calculation = "" ;
            }
            else {
                calculations.setText(calculation);
            }
        }
    }

    public void createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel("Id","NAME",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void scheduleNotification (int delay) {
        Intent notificationIntent = new Intent( this, MyNotificationPublisher. class ) ;
        PendingIntent pendingIntent = PendingIntent.getBroadcast ( this, 1 , notificationIntent , PendingIntent.FLAG_MUTABLE ) ;
        long futureInMillis = System.currentTimeMillis() + delay*1000 ;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE ) ;
        assert alarmManager != null;
        alarmManager.set(AlarmManager.RTC_WAKEUP , futureInMillis , pendingIntent) ;
    }

}