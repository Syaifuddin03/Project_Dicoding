package com.example.projectdicoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.projectdicoding.Adapter.List_Wisata;
import com.example.projectdicoding.Adapter.Wisata_Adapter;
import com.example.projectdicoding.Adapter.Wisata_Data;
import com.example.projectdicoding.Profil.Profile_Activity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvWisata;
    private ArrayList<List_Wisata> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWisata = findViewById(R.id.recycler_view);
        rvWisata.setHasFixedSize(true);

        list.addAll(Wisata_Data.getListData());
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        Wisata_Adapter wisata_adapter = new Wisata_Adapter(this, list);
        rvWisata.setAdapter(wisata_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId) {
            case R.id.menu_profile:
                Intent intent = new Intent(MainActivity.this, Profile_Activity.class);
                startActivity(intent);
                break;
        }
    }
}
