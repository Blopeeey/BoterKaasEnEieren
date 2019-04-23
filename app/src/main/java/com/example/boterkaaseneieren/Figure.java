package com.example.boterkaaseneieren;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Figure extends AppCompatActivity {

    public String val_speler1;
    public String val_speler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_figure);

        //Dropdown voor speler 1
        Spinner speler1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Figure.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.speler1));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speler1.setAdapter(myAdapter);

        //Dropdown voor speler 2
        Spinner speler2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Figure.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.speler2));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speler2.setAdapter(myAdapter2);

        val_speler1 = speler1.getSelectedItem().toString();
        val_speler2 = speler2.getSelectedItem().toString();
    }
    protected void toGameActivity(View view){
        Intent gameIntent = new Intent(this, Game.class);
        gameIntent.putExtra("speler1", val_speler1);
        gameIntent.putExtra("speler2", val_speler2);
        startActivity(gameIntent);
    }
}
