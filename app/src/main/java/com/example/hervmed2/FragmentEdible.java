package com.example.hervmed2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentEdible extends Fragment implements HerbAdapter.OnNoteListenerHerb{

    ArrayList<HerbItems> herbItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_recyclerview_container, container, false);

        RecyclerView popularRecView = view.findViewById(R.id.reyclerViewContainer);
        popularRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        HerbAdapter hAdapter = new HerbAdapter(initHerb(), this);
        popularRecView.setAdapter(hAdapter);

        return view;
    }

    private ArrayList<HerbItems> initHerb(){
        herbItems.add(new HerbItems(R.drawable.blackberry, "Blackberry", "Rubus", R.string.blackberry_content));
        herbItems.add(new HerbItems(R.drawable.chamomile2, "Chamomile", "Matricaria chamomilla", R.string.chamomile_content));
        herbItems.add(new HerbItems(R.drawable.chives, "Chives", "Allium schoenoprasum", R.string.chives_content));
        herbItems.add(new HerbItems(R.drawable.elderberry, "Elderberry", "Sambucus", R.string.elderberry_content));
        herbItems.add(new HerbItems(R.drawable.goji_berry, "Goji berry", "Lycium barbarum",R.string.goji_berry_content));
        herbItems.add(new HerbItems(R.drawable.gooseberry, "Gooseberry", "Ribes uva-crispa", R.string.gooseberry_content));
        herbItems.add(new HerbItems(R.drawable.juniper, "Juniper berry", "Juniperus communis berries", R.string.juniper_content));
        herbItems.add(new HerbItems(R.drawable.lilac, "Lilac", "genus Syringa", R.string.lilac_content));
        herbItems.add(new HerbItems(R.drawable.lovage, "Lovage", "Levisticum officinale", R.string.lovage_content));
        herbItems.add(new HerbItems(R.drawable.peppermint, "Mint", "Mentha", R.string.mint_content));
        herbItems.add(new HerbItems(R.drawable.mulberry, "Mulberry", "Mentha pulegium",R.string.mulberry_content));
        herbItems.add(new HerbItems(R.drawable.raspberry, "Raspberry", "Rubus idaeus", R.string.raspberry_content));
        herbItems.add(new HerbItems(R.drawable.red_currant, "Red currant", "Ribes rubrum",R.string.redcurrant_content));
        herbItems.add(new HerbItems(R.drawable.rhubarb, "Rhubarb", "Rheum rhabarbarum",R.string.rhubarb_content));
        herbItems.add(new HerbItems(R.drawable.rose_hips, "Rose hips", "Rosa canina L.",R.string.rosehip_content));
        herbItems.add(new HerbItems(R.drawable.white_clover, "White clover", "Trifolium repens",R.string.white_clover_content));
        return herbItems;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));


        startActivity(intent);
    }
}