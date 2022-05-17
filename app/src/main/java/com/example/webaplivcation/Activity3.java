package com.example.webaplivcation;

import static java.time.LocalTime.now;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Activity3 extends AppCompatActivity {
    static String cheсkNumber;
    static int rightNumber= 0;
    static int countNumber= 1;
    final double howShowNumber = 0.7;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Button buttonAct3Go2 = findViewById(R.id.buttonAct3Go2);
        Button checkButton = findViewById(R.id.checkButton);
        EditText inputNumber = findViewById(R.id.inputNumber);
        TextView showNumber = findViewById(R.id.numberShow);
        rightNumber = 0;
        countNumber = 1;
        cheсkNumber = showNumber();

        checkButton.setOnClickListener(v -> {
            if (countNumber < 2) {
                if (inputNumber.getText() != null || inputNumber.getText().toString().equals("")) {
                    if (cheсkNumber.equals(inputNumber.getText().toString())) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Верно", Toast.LENGTH_SHORT);
                        toast.show();
                        rightNumber++;
                        cheсkNumber = showNumber();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Попробуйте еще) У Вас обязательно получится!", Toast.LENGTH_SHORT);
                        toast.show();
                        cheсkNumber = showNumber();
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Пожалуйства, введите число.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                countNumber++;
            } else {
                finish();
//                Intent intent = new Intent();
//                intent.setClass(Activity3.this, Activity2.class);
//                startActivity(intent);
            }
        });

        buttonAct3Go2.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(Activity3.this, Activity2.class);
            startActivity(intent);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String showNumber() {
        TextView showNumber = findViewById(R.id.numberShow);
        String number = String.valueOf(((int) (Math.random() * 100)));
        showNumber.setText(number);
        showNumber.postDelayed(new Runnable() {
            @Override
            public void run() {
                double nowSecond = now().getSecond() + howShowNumber;
                while (now().getSecond() < nowSecond) {
                    System.out.println("Ждем-с 3 секунды");
                }
                showNumber.setText("");
            }
        }, 100);
        return number;
    }

    private void saveData() {
        System.out.println(rightNumber + "-----------------------------------------");
//        try {
//            // отрываем поток для записи
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
//                    openFileOutput("mnt/sdcard/Download/LoginPassword.txt", MODE_PRIVATE)));
//            // пишем данные
//            bw.write(rightNumber);
//            // закрываем поток
//            bw.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onPause() {
//        Intent intent = new Intent();
//        intent.setClass(Activity3.this, Activity2.class);
//        startActivity(intent);
        super.onPause();
    }

    @Override
    protected void onStop() {
        saveData();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("result", rightNumber + "/" + countNumber);
        startActivity(intent);
        super.onDestroy();
    }
}