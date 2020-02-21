package com.example.mobicash;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DBRecycleviewAdapter extends RecyclerView.Adapter<DBRecycleviewAdapter.DatabaseViewHolder> {

    ArrayList<UserModel> userModelArrayList;

    public DBRecycleviewAdapter(ArrayList<UserModel> userModelArrayList) {
        this.userModelArrayList = userModelArrayList;
    }

    @NonNull
    @Override
    public DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View SingleRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.row2, null);
        return new DatabaseViewHolder(SingleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseViewHolder holder, int position) {

        UserModel userModel= userModelArrayList.get(position);
        holder.namestv.setText(userModel.getNames());
        holder.pwdtv.setText(userModel.getPasswords());


    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }

    public static class DatabaseViewHolder extends RecyclerView.ViewHolder
    {
        TextView namestv, pwdtv;
        public DatabaseViewHolder(@NonNull View itemView) {
            super(itemView);

            namestv = itemView.findViewById(R.id.namess);
            pwdtv = itemView.findViewById(R.id.passwordss);
        }
    }
}
