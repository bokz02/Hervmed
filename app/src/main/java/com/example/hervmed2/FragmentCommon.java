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


public class FragmentCommon extends Fragment implements HerbAdapter.OnNoteListenerHerb{

    ArrayList<HerbItems> herbItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recyclerview_container, container, false);

        RecyclerView popularRecView = view.findViewById(R.id.reyclerViewContainer);
        popularRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        HerbAdapter hAdapter = new HerbAdapter(initHerb(), this);
        popularRecView.setAdapter(hAdapter);

        return view;
    }

    private ArrayList<HerbItems> initHerb(){
        herbItems.add(new HerbItems(R.drawable.anise_hyssop, "Anise hyssop", "Agastache foeniculum`", R.string.anise_content));
        herbItems.add(new HerbItems(R.drawable.borage, "Borage", "Borago officinalis", R.string.borage_content));
        herbItems.add(new HerbItems(R.drawable.epazote, "Epazote", "Dysphania ambrosioides",R.string.epazote_content));
        herbItems.add(new HerbItems(R.drawable.feverfew, "Feverfew", "Tanacetum parthenium", R.string.feverfew_content));
        herbItems.add(new HerbItems(R.drawable.french_sorrel, "French sorrel", "Rumex scutatus", R.string.french_sorrel_content));
        herbItems.add(new HerbItems(R.drawable.lettuce_leaf_basil, "Lettuce-leaf basil", "Perilla frutescens var. crispa", R.string.lettuce_leaf_basil_content));
        herbItems.add(new HerbItems(R.drawable.lovage, "Lovage", "Levisticum officinale",R.string.lovage_content));
        herbItems.add(new HerbItems(R.drawable.marsh_mallow, "Marsh mallow", "Althaea officinalis", R.string.marsh_mallow_content));
        herbItems.add(new HerbItems(R.drawable.saffron, "Saffron", "Crocus sativus",R.string.saffron_content));
        herbItems.add(new HerbItems(R.drawable.stevia, "Stevia", "Stevia rebaudiana",R.string.stevia_content));
        herbItems.add(new HerbItems(R.drawable.sweet_cicely, "Sweet cicely", "Myrrhis odorata",R.string.sweet_cicely_content));
        herbItems.add(new HerbItems(R.drawable.tulsi, "Tulsi", "Ocimum tenuiflorum",R.string.tulsi_content));

        return herbItems;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));


        startActivity(intent);
    }
}