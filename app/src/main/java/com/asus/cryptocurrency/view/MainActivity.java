package com.asus.cryptocurrency.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.asus.cryptocurrency.R;
import com.asus.cryptocurrency.adapter.CryptoAdapter;
import com.asus.cryptocurrency.model.CryptoModel;
import com.asus.cryptocurrency.service.abstractt.ICryptoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private String baseUrl = "https://raw.githubusercontent.com/";
    Retrofit retrofit;

    CompositeDisposable compositeDisposable;
    ArrayList<CryptoModel> cryptoModelArrayList;
    CryptoAdapter cryptoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.receylerView);

        // https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json



        // Retrofit and JSON

        // setLenient() ->  Gson is a Java library for converting JSON data to Java objects and Java objects to JSON data.
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())      // I say to Retrofit that I will use rxjava.
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        getDataFromAPI();

    }

    public void getDataFromAPI(){

        ICryptoAPI iCryptoAPI = retrofit.create(ICryptoAPI.class);

        compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(iCryptoAPI.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (this::handleResponse));


    }

    public  void handleResponse(List<CryptoModel> cryptoModelList){
        cryptoModelArrayList = new ArrayList<>(cryptoModelList);

        // recyclerView
        recyclerView.setLayoutManager( new LinearLayoutManager(MainActivity.this));
        cryptoAdapter = new CryptoAdapter(cryptoModelArrayList);
        recyclerView.setAdapter(cryptoAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        compositeDisposable.clear();
    }
}