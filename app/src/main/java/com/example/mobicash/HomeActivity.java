package com.example.mobicash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, getMyList());
        recyclerView.setAdapter(myAdapter);
        btn = (Button) findViewById(R.id.nextPage);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });

    }

    private ArrayList<Model> getMyList(){

        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();
        m.setNames("MMD");
        m.setPasswords("mmd");
        models.add(m);

        m = new Model();
        m.setNames("Moise");
        m.setPasswords("mmd");
        models.add(m);



        return models;
    }


    public void nextPage(){

        Intent intent = new Intent(HomeActivity.this,ShowUsersActivity.class);
        startActivity(intent);

    }


}
