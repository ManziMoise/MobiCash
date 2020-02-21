package com.example.mobicash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowUsersActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    Button showbtn;


    ArrayList<UserModel> userModelsArrayList;

    DBRecycleviewAdapter dbRecycleviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        recyclerView = (RecyclerView) findViewById(R.id.dataRV);
        userModelsArrayList = new ArrayList<>();
        showbtn = (Button) findViewById(R.id.showUsersbtn);

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUsers();
            }
        });

    }

    public void showUsers()
    {
        try {
            DatabaseHelper helper = new DatabaseHelper (this);
            SQLiteDatabase sqLiteDatabase= helper.getReadableDatabase();
            if (sqLiteDatabase!=null)
            {
                Cursor cursor = sqLiteDatabase.rawQuery("select * from registeruser", null);

                if (cursor.getCount()==0)
                {
                    Toast.makeText(this, "no data returned", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while(cursor.moveToNext())
                    {
                        userModelsArrayList.add(new UserModel(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2)
                                ));
                    }

                    dbRecycleviewAdapter = new DBRecycleviewAdapter(userModelsArrayList);
                    recyclerView.hasFixedSize();
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    recyclerView.setAdapter(dbRecycleviewAdapter);

                }
            }
            else
            {
                Toast.makeText(this, "Database is full", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "show message from db"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
