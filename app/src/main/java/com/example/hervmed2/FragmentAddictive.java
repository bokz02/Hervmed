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


public class FragmentAddictive extends Fragment implements HerbAdapter.OnNoteListenerHerb{

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
        herbItems.add(new HerbItems(R.drawable.ayahuasca, "Ayahuasca", "Banisteriopsis caapi", R.string.ayahuasca_content));
        herbItems.add(new HerbItems(R.drawable.betel_nut, "Betel nut", "Areca catechu", R.string.betel_nut_content));
        herbItems.add(new HerbItems(R.drawable.canabis, "Canabis", "Cannabis sativa",R.string.cannabis_content));
        herbItems.add(new HerbItems(R.drawable.coca, "Coca", "Erythroxylum coca", R.string.coca_content));
        herbItems.add(new HerbItems(R.drawable.jimsonweed, "Jimsonweed", "Datura stramonium", R.string.jimsonweed_content));
        herbItems.add(new HerbItems(R.drawable.oppium_poppy, "Oppium poppy", "Papaver somniferum", R.string.oppium_poppy_content));
        herbItems.add(new HerbItems(R.drawable.peyote, "Peyote", "Lophophora williamsii",R.string.peyote_content));
        herbItems.add(new HerbItems(R.drawable.salvia, "Sage of the diviners", "Salvia divinorum", R.string.salvia_content));
        herbItems.add(new HerbItems(R.drawable.tobacco, "Tobacco", "Nicotiana tabacum",R.string.tobaco_content));


        return herbItems;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));


        startActivity(intent);
    }
}