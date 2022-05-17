package com.example.webaplivcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserResultTableActivity extends AppCompatActivity {
    UserResult pushInfo;
    ArrayList<UserResult> userResults = new ArrayList<UserResult>();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
//        Button button = (Button)findViewById(R.id.personalAccauntButton);

//        button.
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = findViewById(R.id.countriesList);
        // создаем адаптер
        ResultAdapter resultAdapter = new ResultAdapter(this, R.layout.list_item, userResults);
        // устанавливаем адаптер
        countriesList.setAdapter(resultAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                UserResult selectedUserResult = (UserResult)parent.getItemAtPosition(position);
                pushInfo = (UserResult) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedUserResult.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }

    public void goPersonalAccaunt(View v) {
        if (pushInfo != null) {
            Intent intent = new Intent(this, PersonalAccount.class);
            intent.putExtra("userName", pushInfo.getName());
            intent.putExtra("userImage", pushInfo.getFlagResource());
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Выберите пользователя!!!",
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void setInitialData(){

        userResults.add(new UserResult("Симен", "Результат: 36", R.drawable.img_1));
        userResults.add(new UserResult("Сергей", "Результат: 24", R.drawable.img_2));
//        states.add(new State ("Колумбия", "Богота", R.drawable.columbia));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uruguai));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.chile));
    }
}