package com.rizkysaraan.javaretrofitmvvm.view.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.rizkysaraan.javaretrofitmvvm.R;
import com.rizkysaraan.javaretrofitmvvm.databinding.ActivityAutocompleteBinding;
import com.rizkysaraan.javaretrofitmvvm.model.Pos;
import com.rizkysaraan.javaretrofitmvvm.viewmodel.MainViewModel;

import java.util.ArrayList;

public class AutoCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAutocompleteBinding activityAutocompleteBinding = ActivityAutocompleteBinding.inflate(getLayoutInflater());
        setContentView(activityAutocompleteBinding.getRoot());

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        String storeId = "29";
        mainViewModel.getAllPos(storeId).observe(this, dataPos -> {
            ArrayList<String> listPos = new ArrayList<>();
            for (Pos pos : dataPos) {
                listPos.add(pos.getStore_koordinat_name());
            }

            activityAutocompleteBinding.acPos.setAdapter(new ArrayAdapter<>(this, R.layout.item_autocomplete, listPos));
            activityAutocompleteBinding.acPos.setOnItemClickListener((parent, view, position, id) -> {
                Toast.makeText(this, "tes " + dataPos.get(position).getStore_koordinat_id(), Toast.LENGTH_SHORT).show();
            });

        });
    }
}