package com.example.spinnerhw;

import static android.R.layout.simple_list_item_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spinnerhw.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Person;

public class MainActivity extends AppCompatActivity {
    private Toolbar mainTB;
    private ActivityMainBinding binding;
    private List<Person> personList = new ArrayList<>();
    private List<String> postList = Arrays.asList(
            "Список должностей",
            "Инженер-конструктор",
            "Инженер-технолог",
            "Инженер ПТО",
            "Инженер КИПа",
            "Мастер",
            "Сварщик",
            "Слесарь"
    );
    private ListView listLV;
    private String bufferPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mainTB = findViewById(R.id.mainTB);
        setSupportActionBar(mainTB);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listLV = findViewById(R.id.listLV);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, postList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bufferPost = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.saveBTN.setOnClickListener(v -> {
            String name = binding.nameET.getText().toString();
            String lastName = binding.lastNameET.getText().toString();
            String post = bufferPost;
            Person person = new Person(name, lastName, post);
            personList.add(person);

            ArrayAdapter listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, personList);
            listLV.setAdapter(listAdapter);
            listAdapter.notifyDataSetChanged();

            binding.nameET.getText().clear();
            binding.lastNameET.getText().clear();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.exitMenuMain:
                finish();
                Toast.makeText(this, "Stop app", Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}