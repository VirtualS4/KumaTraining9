package com.example.rona.kumatraining9;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager; import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater; import android.view.MenuItem; import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Beartivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Kuuuun> songList;
    private BearSongAdapter songAdapter;

    String[] names = {
            "I Took A Pill In Ibiza",
            "7 Years", "Pillow Talk",
            "Work From Home",
            "Never Forget You",
            "Don't Let Me Down",
            "Love Yourself",
            "Me, Myself & I",
            "Cake By The Ocean",
            "Dangerous Woman",
            "My House",
            "Stressed Out",
            "One Dance",
            "Middle",
            "No"};

    String[] singers = {"Mike Posner", "Lukas Graham", "Zayn", "Fifth Harmony", "Zara Larsson & MNEK", "The Chainsmokers",
            "Justin Bieber", "G-Eazy x Bebe Rexha", "DNCE", "Ariana Grande", "Flo Rida",
            "Twenty one Pilots", "Drake", "DJ Snake", "Meghan Trainer"};

    int[] pics = {
            R.drawable.took_a_pill,
            R.drawable.seven_years,
            R.drawable.pillow_talk,
            R.drawable.work,
            R.drawable.never_forget_you,
            R.drawable.dont_let_me_down,
            R.drawable.love_yourself,
            R.drawable.me_myself_and_i,
            R.drawable.cake_by_the_ocean,
            R.drawable.dangerous_woman,
            R.drawable.my_house_florida,
            R.drawable.stressed_out,
            R.drawable.one_dance,
            R.drawable.middle,
            R.drawable.no};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beartivity);
        mRecyclerView = (RecyclerView) findViewById(R.id.bearview);

//setting untuk improve perfomance
//content tdk dapat mengubah size layout recyclerview
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }

//	//using a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        songList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Kuuuun song = new Kuuuun(names[i], singers[i], i + 1, pics[i]);
            songList.add(song);
        }

        songAdapter = new BearSongAdapter(songList);

        mRecyclerView.setAdapter(songAdapter);
        songAdapter.notifyDataSetChanged();
        mRecyclerView.addOnItemTouchListener(
                new BearRecycleClick(this,
                new BearRecycleClick.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(Beartivity.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_grid:
//	use this in case of gridlayoutmanager
            mLayoutManager = new GridLayoutManager(this, 2);
            mRecyclerView.setLayoutManager(mLayoutManager);
            break;
            case R.id.item_staggered_grid:
//	use this in case of Staggered GridLayoutManager
                mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_horizontal:
//horizontal linear layout
                mLayoutManager = new LinearLayoutManager(Beartivity.this,LinearLayoutManager.HORIZONTAL,false);
                mRecyclerView.setLayoutManager(mLayoutManager); break;
        }
        return super.onOptionsItemSelected(item);
    }
}

