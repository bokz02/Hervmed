package com.example.hervmed2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HerbAdapter extends RecyclerView.Adapter<HerbAdapter.HerbViewHolder> {
    ArrayList<HerbItems> herbList;
    private final OnNoteListenerHerb onNoteListenerHerb;

    public static class HerbViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView1, textView2;
        ImageView imageView;
        OnNoteListenerHerb onNoteListenerHerb;


        public HerbViewHolder(@NonNull View itemView, OnNoteListenerHerb onNoteListenerHerb) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.title);
            textView2 = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);

            this.onNoteListenerHerb = onNoteListenerHerb;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListenerHerb.onNoteClick(getAdapterPosition());
        }
    }

    public HerbAdapter (ArrayList<HerbItems> herbItems, OnNoteListenerHerb onNoteListenerHerb){
        herbList = herbItems;
        this.onNoteListenerHerb = onNoteListenerHerb;

    }

    @NonNull
    @Override
    public HerbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row, parent,false);

        return new HerbViewHolder(view, onNoteListenerHerb);
    }

    @Override
    public void onBindViewHolder(@NonNull HerbViewHolder holder, int position) {


        holder.textView1.setText(herbList.get(position).getTitle());
        holder.textView2.setText(herbList.get(position).getDescription());
        holder.imageView.setImageResource(herbList.get(position).getImgResource());

    }

    @Override
    public int getItemCount() {
        return herbList.size();
    }

    public interface OnNoteListenerHerb{
        void onNoteClick(int position);
    }


}
