package com.example.mobicash;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nnames, ppasswords;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nnames = itemView.findViewById(R.id.names);
        this.ppasswords = itemView.findViewById(R.id.passwords);
    }
}
