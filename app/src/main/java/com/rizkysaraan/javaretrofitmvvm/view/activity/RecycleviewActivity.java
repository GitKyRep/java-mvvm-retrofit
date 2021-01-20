package com.rizkysaraan.javaretrofitmvvm.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rizkysaraan.javaretrofitmvvm.databinding.ActivityRecycleviewBinding;
import com.rizkysaraan.javaretrofitmvvm.model.Pos;
import com.rizkysaraan.javaretrofitmvvm.view.adapter.PosAdapter;
import com.rizkysaraan.javaretrofitmvvm.viewmodel.MainViewModel;

import java.util.List;

public class RecycleviewActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private ActivityRecycleviewBinding recycleviewBinding;

    @Override
    public void onPause() {
        recycleviewBinding.shimmerPos.stopShimmer();
        super.onPause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recycleviewBinding = ActivityRecycleviewBinding.inflate(getLayoutInflater());
        setContentView(recycleviewBinding.getRoot());

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        recycleviewBinding.shimmerPos.setVisibility(View.GONE);
        recycleviewBinding.tvNoData.setVisibility(View.GONE);

        getPos();
    }


    private void getPos() {
        String storeId = "29";
        recycleviewBinding.shimmerPos.startShimmer();
        recycleviewBinding.shimmerPos.setVisibility(View.VISIBLE);
        mainViewModel.getAllPos(storeId).observe(this, this::setRecyclerView);
    }

    private void setRecyclerView(List<Pos> dataPos) {
        PosAdapter posAdapter = new PosAdapter(dataPos);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recycleviewBinding.rvPos.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recycleviewBinding.rvPos.setLayoutManager(new GridLayoutManager(this, 4));
        }
        recycleviewBinding.rvPos.setItemAnimator(new DefaultItemAnimator());
        recycleviewBinding.rvPos.setAdapter(posAdapter);
        posAdapter.notifyDataSetChanged();

        recycleviewBinding.shimmerPos.stopShimmer();
        recycleviewBinding.shimmerPos.setVisibility(View.GONE);

        posAdapter.setOnItemClickListner(data -> {
            Toast.makeText(this, "anda telah memilih pos " + data.getStore_koordinat_name(), Toast.LENGTH_SHORT).show();
        });

        if (dataPos.isEmpty()) {
            recycleviewBinding.tvNoData.setVisibility(View.VISIBLE);
        }
    }
}