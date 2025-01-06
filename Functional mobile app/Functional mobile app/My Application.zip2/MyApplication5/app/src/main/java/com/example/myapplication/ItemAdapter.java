// ItemAdapter.java
package com.example.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<com.example.myapplication.ItemAdapter.ViewHolder> {
    private List<com.example.myapplication.Item> itemList;
    private com.example.myapplication.ItemAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(com.example.myapplication.Item item);
    }

    public ItemAdapter(List<com.example.myapplication.Item> itemList, com.example.myapplication.ItemAdapter.OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public com.example.myapplication.ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new com.example.myapplication.ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.myapplication.ItemAdapter.ViewHolder holder, int position) {
        com.example.myapplication.Item item = itemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.usernameText);
        }
    }
}

