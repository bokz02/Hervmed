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


public class FragmentToxic extends Fragment implements HerbAdapter.OnNoteListenerHerb{

    ArrayList<HerbItems> herbItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_recyclerview_container, container, false);

        RecyclerView popularRecView = view.findViewById(R.id.reyclerViewContainer);
        popularRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        HerbAdapter hAdapter = new HerbAdapter(initHerb(), this);
        popularRecView.setAdapter(hAdapter);

        return view;
    }

    private ArrayList<HerbItems> initHerb(){
        herbItems.add(new HerbItems(R.drawable.borage, "Borage", "Borago officinalis", R.string.borage_content));
        herbItems.add(new HerbItems(R.drawable.chaparral, "Chaparral", "Larrea tridentata", R.string.chaparral_content));
        herbItems.add(new HerbItems(R.drawable.comfrey, "Comfrey", "Symphytum",R.string.comfrey_content));
        herbItems.add(new HerbItems(R.drawable.ephedra, "Ephedra", "Ephedra equisetina Bge.", R.string.ephedra_content));
        herbItems.add(new HerbItems(R.drawable.germander, "Germander", "Teucrium", R.string.germander_content));
        herbItems.add(new HerbItems(R.drawable.golden_ragwort, "Golden ragwort", "Packera aurea", R.string.golden_ragwort_content));
        herbItems.add(new HerbItems(R.drawable.pennyroyal, "Pennyroyal", "Mentha pulegium",R.string.pennyroyal_content));
        herbItems.add(new HerbItems(R.drawable.sassafras, "Sassafras", "Sassafras albidum", R.string.sassafras_content));
        herbItems.add(new HerbItems(R.drawable.sweet_flag, "Sweet flag", "Nicotiana tabacum",R.string.sweet_flag_content));
        return herbItems;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));


        startActivity(intent);
    }
}