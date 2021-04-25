package com.example.listview;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    Button button;
    ListView listView;
    ArrayList<String> name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTextPersonName);
        button=findViewById(R.id.button9);
         name = new ArrayList<String>();
        name.add("Eman");
        name.add("Batool");
        name.add("Parrot");
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);

         listView= findViewById(R.id.nameList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
         {
            @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id)
               {
                   Log.d( "onItemClick: ", name.get(position));
               }
        }


        );
    }


    public void addName(View view) {
        name.add(editText.getText().toString());
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        Collections.sort(name);


    }
}