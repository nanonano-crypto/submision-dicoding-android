package com.juara.submision_satu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.juara.submision_satu.Adapter.Adapter;
import com.juara.submision_satu.model.Pemain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //initialize
    private RecyclerView rc;
    private String title = "Mode List";
    private ArrayList<Pemain> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBar(title);
        rc = findViewById(R.id.rc);
        rc.setHasFixedSize(true);
        //mengambil data dari data pemain
        list.addAll(DataPemain.getListData());
        showRecycleView();
    }

    private void showRecycleView() {
        rc.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(list, MainActivity.this);
        rc.setAdapter(adapter);
    }


    //method untuk action bar
    private void setActionBar(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, AboutActivity.class));
        }

        return true;
    }
}