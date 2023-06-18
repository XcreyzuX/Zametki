package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] myArr = {"paint_1", "paint_2", "paint_3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> monthAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myArr);

        setListAdapter(monthAdapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String month = (String) getListAdapter().getItem(position);
//        Toast.makeText(this, month, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
//        String eText = "information to send";
        i.putExtra("block", month);
        startActivity(i);
        System.out.println();
    }
}
