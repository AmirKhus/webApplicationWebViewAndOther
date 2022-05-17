//package com.example.webaplivcation;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//
//import lombok.Getter;
//import lombok.Setter;
//
//public class MainActivity extends Activity {
//    @Getter
//    @Setter
//    public static boolean active = false;
//    private String login;
//    private String password;
//    private String unconfLogin;
//    private String unconfPasword;
//    private EditText lgn;
//    private EditText pwd;
////    private EditText TextView = ((EditText)findViewById(R.id.loginEditText));
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Button loginAccaunt = (Button) findViewById(R.id.loginButton);
//        lgn = findViewById(R.id.loginEditText);
//        pwd = findViewById(R.id.passwordTextText);
//        if (savedInstanceState != null) {
//            unconfLogin = savedInstanceState.getString("unconfLogin");
//            unconfPasword = savedInstanceState.getString("unconfPasword");
//            System.out.println(unconfPasword);
//
//            lgn.setText(unconfLogin);
//            pwd.setText(unconfPasword);
//        }
////        Button exinAplication = (Button) findViewById(R.id.exitButton);
//
////        EditText login = findViewById(R.id.loginEditText);
////        EditText pasword = findViewById(R.id.passwordTextText);
//
////        loginAccaunt.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                try {
////                    saveDateAccaunt(login,pasword);
//////                    String loginString = login.getText().
////                    Intent intent = new Intent();
////                    Data data = new Data(login.getText().toString());
////                    intent.setClass(MainActivity.this,Activity2.class);
////                    intent.putExtra(Data.class.getSimpleName(), data);
////                    startActivity(intent);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
//
////        exinAplication.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                finish();
////            }
////        });
//    }
//
//    // сохранение файла
//    public void onClick(View v) {
//
////        EditText login = findViewById(R.id.loginEditText);
////        EditText pasword = findViewById(R.id.passwordTextText);
//
//        login = ((EditText) findViewById(R.id.loginEditText)).getText().toString();
//        password = ((EditText) findViewById(R.id.passwordTextText)).getText().toString();
//
//        saveDateAccaunt(login, password);
//
//        Intent intent = new Intent(this, Activity2.class);
//        intent.putExtra("login", login);
//        intent.putExtra("pasword", password);
//        startActivity(intent);
//    }
//
//    @Override
//    protected void onStart() {
//        active = true;
//        super.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        active = false;
//        super.onStop();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
////        if (lgn.getText()!= null)
//        unconfLogin = lgn.getText().toString();
//        unconfPasword = pwd.getText().toString();
//        savedInstanceState.putString("unconfLogin", unconfLogin);
//        savedInstanceState.putString("unconfPasword", unconfPasword);
//    }
//
//    @Override
//    protected void onDestroy() {
//        login = ((EditText) findViewById(R.id.loginEditText)).getText().toString();
//        password = ((EditText) findViewById(R.id.passwordTextText)).getText().toString();
//        super.onDestroy();
//    }
//
//    private final String FILE_NAME = "AndroidTest.txt";
//
//    private void saveDateAccaunt(String login, String password) {
////        File file = new File("LoginPassword.txt");
////        FileWriter fr = null;
////        BufferedWriter br = null;
//        System.out.println(login + ";" + password + "\n");
//
//        FileOutputStream fos = null;
//        try {
//            String text = login + password;
//            File file = new File("./data/data/com.example.webaplivcation/files/AndroidTest.txt");
//            if (file.getFreeSpace() >= text.getBytes().length) {
//                System.out.println("--------------------" + file.getFreeSpace());
//                System.out.println("====================" + text.getBytes().length);
//                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
//
//                fos.write(text.getBytes());
//                Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Не хватает памяти! Освободите память устройства", Toast.LENGTH_SHORT).show();
//            }
////            System.out.println("--------------------"+file.getFreeSpace());
////            System.out.println("===================="+text.getBytes().length);
////            fos = openFileOutput("AndroidTest.txt", MODE_PRIVATE);
////
////            fos.write(text.getBytes());
//            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
//        } catch (IOException ex) {
//
//            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//        } finally {
//            try {
//                if (fos != null)
//                    fos.close();
//            } catch (IOException ex) {
//
//                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private File getExternalPath() {
//        return new File(getExternalFilesDir(null), FILE_NAME);
//    }
//
//    // сохранение файла
//    public void saveText(String login, String password) {
//
//        try (FileOutputStream fos = new FileOutputStream(getExternalPath())) {
////            EditText textBox = findViewById(R.id.editor);
////            String text = textBox.getText().toString();
//            String text = login + ";" + password;
//            fos.write(text.getBytes());
//            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
//        } catch (IOException ex) {
//            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//}