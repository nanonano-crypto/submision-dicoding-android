package com.juara.latihanrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rc;
    private String title = "Mode list";
    private ArrayList<Hero> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rc = findViewById(R.id.rc);
        rc.setHasFixedSize(true);

        list.addAll(HeroData.getListData());
        showRecycleView();
    }

    //untuk menampilkan list view
    private void showRecycleView() {
        rc.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rc.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.onItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    //method untuk grid view
    public void showRecyclerGrid(){
        rc.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rc.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new GridHeroAdapter.onItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    //method untuk cardView
    public void showRecycleCardView(){
        rc.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(list);
        rc.setAdapter(cardViewAdapter);
    }

    // fungdi menu app
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMMode) {
        switch (selectedMMode){
            case R.id.action_list:
                title = "Mode List";
                showRecycleView();
                break;
            case R.id.action_gride:
                title = "Mode Grid";
              showRecyclerGrid();
              break;
            case R.id.action_cardView:
                title = "Mode CardView";
                showRecycleCardView();
                break;
        }
        setActionBarTitle(title);
    }

    //merubah title aplikasi pada pilihna main app
    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    //menammpilkan informasi saat di clik
    private void showSelectedHero(Hero hero){
        Toast.makeText(this, "kamu memilih" + hero.getName(), Toast.LENGTH_LONG).show();
    }
}