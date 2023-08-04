package com.asus.cryptocurrency.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asus.cryptocurrency.R;
import com.asus.cryptocurrency.model.CryptoModel;

import java.util.ArrayList;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoHolder> {

    public ArrayList<CryptoModel> cryptoModelArrayList;

    public CryptoAdapter(ArrayList<CryptoModel> cryptoModelArrayList) {
        this.cryptoModelArrayList = cryptoModelArrayList;
    }

    public String[] colors = {"#5dd969","#6abfc6","#fb7b50","#fdd969","#dd001c","#ffa500","#006841"};

    @NonNull
    @Override
    public CryptoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyler_row,parent,false);
        return new CryptoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoHolder holder, int position) {

        holder.bind(cryptoModelArrayList.get(position),colors,position);
    }

    @Override
    public int getItemCount() {
        return cryptoModelArrayList.size();
    }

    public class CryptoHolder extends RecyclerView.ViewHolder{

        TextView textCurrency;
        TextView textPirece;

        public CryptoHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(CryptoModel cryptoModel, String[] colors, Integer position){

            itemView.setBackgroundColor(Color.parseColor(colors[position % 7]));

            textCurrency = itemView.findViewById(R.id.textViewCurrency);
            textPirece = itemView.findViewById(R.id.textViewPrice);
            textCurrency.setText(cryptoModel.currency);
            textPirece.setText(cryptoModel.price);



        }

    }



}
