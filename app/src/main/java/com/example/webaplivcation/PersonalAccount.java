package com.example.webaplivcation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_account);
        TextView textViewName =  findViewById(R.id.name);
        ImageView imageView = findViewById(R.id.flag);
        Bundle arguments = getIntent().getExtras();

        String name;
        int image;
        if(arguments!=null){
            name = (String) arguments.getSerializable("userName");
            image =  (Integer) arguments.getSerializable("userImage");
            textViewName.setText(name);
            imageView.setImageResource(image);
        }
    }
}