package com.example.hervmed2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HerbAdapter extends RecyclerView.Adapter<HerbAdapter.HerbViewHolder> implements Filterable{
    ArrayList<HerbItems> herbList;
    List<HerbItems> herbItemsFull;
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
        this.herbList = herbItems;
        this.onNoteListenerHerb = onNoteListenerHerb;
        herbItemsFull = new ArrayList<>(herbItems);

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

    @Override
    public Filter getFilter() {
        return herbFilter;
    }

    private final Filter herbFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<HerbItems> filteredHerbs = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filteredHerbs.addAll(herbItemsFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (HerbItems items : herbItemsFull){
                    if (items.getTitle().toLowerCase().contains(filterPattern)){
                        filteredHerbs.add(items);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredHerbs;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            herbList.clear();
            herbList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

}
