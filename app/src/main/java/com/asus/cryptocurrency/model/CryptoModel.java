package com.asus.cryptocurrency.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CryptoModel {

    @SerializedName("currency")
    public String currency;

    @SerializedName("price")
    public String price;

}
