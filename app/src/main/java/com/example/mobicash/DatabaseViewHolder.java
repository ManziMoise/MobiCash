package com.example.mobicash;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DatabaseViewHolder extends RecyclerView.ViewHolder {
    TextView nnamess,ppasswordss;
    public DatabaseViewHolder(@NonNull View itemView) {
        super(itemView);

       this.nnamess = itemView.findViewById(R.id.namess);
       this.ppasswordss = itemView.findViewById(R.id.passwordss);


    }
}
