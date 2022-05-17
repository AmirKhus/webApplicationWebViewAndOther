package com.example.webaplivcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.webaplivcation.database.MainActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {

    public static boolean active;
    public static Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        Button buttonAct2Go1 = findViewById(R.id.buttonAct2Go1);
        Button buttonAct2Go3 = findViewById(R.id.buttonAct2Go3);
        Button tableResultUser = findViewById(R.id.tableUserResurse);
        Button datanaseButton = findViewById(R.id.databaseButton);
        TextView textLogin = findViewById(R.id.textViewAct2);

//        inputEditLoginText(textLogin,buttonAct2Go1,buttonAct2Go3);
        inputEditLoginText(textLogin);

        buttonAct2Go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonAct2Go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });

        tableResultUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity2.this, UserResultTableActivity.class);
                startActivity(intent);
            }
        });

//        datanaseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(Activity2.this, MainActivityDataBase.class);
//                startActivity(intent);
//            }
//        });
    }


    private void inputEditLoginText(TextView textLogin) {
//        TextView textView = new TextView(this);
//        textView.setTextSize(26);
//        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();

        if (arguments != null && arguments.get("login")!= null) {
            String login = arguments.get("login").toString();
            String pasword = arguments.getString("pasword");
            textLogin.setText("Login: " + login + "\nPasword: " + pasword);
        }


        FileInputStream fin = null;
        try {
            fin = openFileInput("AndroidTest");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            textLogin.setText(text);
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    private final String FILE_NAME = "AndroidTest.txt";
    private File getExternalPath() {
        return new File(getExternalFilesDir(null), FILE_NAME);
    }
    // открытие файла
    public void openText(TextView textLogin) {

//        TextView textView = findViewById(R.id.text);
        File file = getExternalPath();
        // если файл не существует, выход из метода
        if (!file.exists()) return;
        try (FileInputStream fin = new FileInputStream(file)) {
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            textLogin.setText(text);
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStart() {
        active = true;
        super.onStart();
    }

    @Override
    protected void onStop() {
        active = false;
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
//        if (perviiRaz < 1) {
            TextView result = findViewById(R.id.textViewResult);
            Bundle arguments = getIntent().getExtras();

            if (arguments != null && arguments.get("result") != null) {
                String getResult = arguments.get("result").toString();
                result.setText("Результат: " + getResult);

            }
//        System.out.println("++++++++++++++++++++++"+ arguments.get("result"));
//            perviiRaz++;
//        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}