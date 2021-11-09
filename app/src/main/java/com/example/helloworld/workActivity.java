package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class workActivity extends AppCompatActivity {
    ArrayList<String> exe ;
    ArrayAdapter adapter;
    EditText input ;
    ListView listView ;
    ImageView enter ;
    int counter=0;
    boolean isResume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        input = findViewById(R.id.input);
        enter = findViewById(R.id.add);
        listView = findViewById(R.id.listview);

        exe.add("aps exercise");
        exe.add("legs exersise");
         adapter =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1 ,exe);
        listView.setAdapter(adapter);
        enter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                if(text==null || text.length()==0){
                    Toast toast =Toast.makeText(getApplicationContext(),"Enter An Exercise.",Toast.LENGTH_SHORT);
                    toast.setMargin(50, 50 );
                    toast.show();
                }
                else {
                    addItem(text);
                    input.setText("");
                    Toast toast =Toast.makeText(getApplicationContext(),"Added." +text,Toast.LENGTH_SHORT);
                    toast.setMargin(50, 50 );
                    toast.show();
                }
            }

            class backgroundProcess extends Thread {

                @Override
                public void run() {

                    while(isResume == false ) {
                        counter++;
                        System.out.println(counter);
                    }

                    System.out.println("LAST COUNT:" + counter);

                }
            }




        });

    }

    private void addItem(String exercise) {
        exe.add(exercise);
        listView.setAdapter(adapter);
    }

}