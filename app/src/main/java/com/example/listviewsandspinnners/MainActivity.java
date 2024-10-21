package com.example.listviewsandspinnners;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView countiesList = findViewById(R.id.lists);

        String[] county = {"Siaya","Machakos","Makueni","Kisumu","Nairobi","Migori","HomaBay","Turkana","Mombasa","Kericho","Malindi"};

        final ArrayList<String> counties = new ArrayList<>();

        ArrayAdapter<String> countiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arrays.asList(county));

        countiesList.setAdapter(countiesAdapter);

        countiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Among the Best Kenyan Counties " ,Toast.LENGTH_SHORT).show();
            }
        });

        Spinner mySpinner = findViewById(R.id.spin);

        ArrayList<String> spinners = new ArrayList<>();

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, counties);

        mySpinner.setAdapter(spinnerAdapter);


    }
}