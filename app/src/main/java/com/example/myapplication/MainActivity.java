package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText name,bloknot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editText_name);
        bloknot=findViewById(R.id.editText_bloknot);
    }
    public void savedData(View view){
        String user_name=name.getText().toString();
        String user_bloknot=bloknot.getText().toString();

        try {
            FileOutputStream file=openFileOutput("data_o1.txt",MODE_PRIVATE);
            file.write((user_bloknot).getBytes());
            file.close();
            name.setText("");
            bloknot.setText("");
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getData(View view){
        try {
            FileInputStream file_input =openFileInput("data_o1.txt");
            InputStreamReader reader=new InputStreamReader(file_input);
            BufferedReader bufferedReader=new BufferedReader(reader);

            StringBuilder stringBuilder=new StringBuilder();
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line).append("\n");
            }

            bloknot.setText(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }


}