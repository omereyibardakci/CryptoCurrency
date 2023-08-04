package com.asus.cryptocurrency.service.abstractt;

import com.asus.cryptocurrency.model.CryptoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ICryptoAPI {

    // https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    //Call<List<CryptoModel>> getData();      // retrofit is used

    Observable<List<CryptoModel>> getData();    // RxJava is used  for this is  complex API


}
