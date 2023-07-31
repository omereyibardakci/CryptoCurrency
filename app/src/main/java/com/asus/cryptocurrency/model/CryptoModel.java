package com.asus.cryptocurrency.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CryptoModel {

    @SerializedName("currency")
    String currency;

    @SerializedName("price")
    String price;

}
