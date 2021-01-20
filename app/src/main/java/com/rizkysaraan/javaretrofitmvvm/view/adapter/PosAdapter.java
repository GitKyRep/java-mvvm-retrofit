package com.rizkysaraan.javaretrofitmvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizkysaraan.javaretrofitmvvm.R;
import com.rizkysaraan.javaretrofitmvvm.model.Pos;

import java.util.List;

public class PosAdapter extends RecyclerView.Adapter<PosAdapter.PosHolder> {
    private final List<Pos> listPos;
    private OnItemClickCallback onItemClickCallback;

    public PosAdapter(List<Pos> listPos) {
        this.listPos = listPos;
    }

    public void setOnItemClickListner(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public PosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pos_rv, parent, false);
        return new PosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosHolder holder, int position) {
        Pos pos = listPos.get(position);
        holder.tvPosName.setText(pos.getStore_koordinat_name());
        holder.tvPosKoordniat.setText(pos.getStore_koordinat_latitude() + " , " + pos.getStore_koordinat_longitude());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(pos));
    }

    @Override
    public int getItemCount() {
        return listPos.size();
    }

    public class PosHolder extends RecyclerView.ViewHolder {
        TextView tvPosName;
        TextView tvPosKoordniat;

        public PosHolder(@NonNull View itemView) {
            super(itemView);
            tvPosName = itemView.findViewById(R.id.tvPosName);
            tvPosKoordniat = itemView.findViewById(R.id.tvPosKoordniat);
        }
    }

}
