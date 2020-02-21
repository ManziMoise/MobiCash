package com.example.mobicash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowUsersActivity extends AppCompatActivity {

    RecyclerView recyclerView ;

    ArrayList<UserModel> userModelsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        recyclerView = (RecyclerView) findViewById(R.id.dataRV);
        userModelsArrayList = new ArrayList<>();

    }

    public void showUsers(View view)
    {
        try {
            DatabaseHelper helper = new DatabaseHelper (this);
            SQLiteDatabase sqLiteDatabase= helper.getReadableDatabase();
            if (sqLiteDatabase!=null)
            {
                Cursor cursor = sqLiteDatabase.rawQuery("select *  from registeruser", null);

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
