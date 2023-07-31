package com.asus.cryptocurrency.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.asus.cryptocurrency.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.receylerView);

        // https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

    }



}