package com.example.hervmed2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hervmed2.tabs.HistoryFragment;

import java.util.ArrayList;

public class FragmentPopular extends Fragment implements HerbAdapter.OnNoteListenerHerb{

    ArrayList<HerbItems> herbItems = new ArrayList<>();

    private static final String TAG = "Main Activity";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_recyclerview_container, container, false);


        RecyclerView popularRecView = view.findViewById(R.id.reyclerViewContainer);
        popularRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        HerbAdapter hAdapter = new HerbAdapter(initHerb(), this);
        popularRecView.setAdapter(hAdapter);



        return view;
    }

    private ArrayList<HerbItems> initHerb(){
        herbItems.add(new HerbItems(R.drawable.chamomile2, "Chamomile", "Matricaria chamomilla", R.string.chamomile_content));
//        herbItems.add(new HerbItems(R.drawable.echinacea, "Echinacea", "Echinacea purpurea"));
//        herbItems.add(new HerbItems(R.drawable.elderberry, "Elderberry", "Sambucus"));
//        herbItems.add(new HerbItems(R.drawable.ginger, "Ginger", "Zingiber officinale"));
//        herbItems.add(new HerbItems(R.drawable.ginkgo_biloba, "Ginkgo", "Ginkgo biloba"));
//        herbItems.add(new HerbItems(R.drawable.ginseng, "Ginseng", "Panax ginseng"));
//        herbItems.add(new HerbItems(R.drawable.st_johns_wort, "St. John's Wort", "Hypericum perforatum"));
//        herbItems.add(new HerbItems(R.drawable.turmeric, "Turmeric", "Curcuma longa"));
//        herbItems.add(new HerbItems(R.drawable.valerian, "Valerian", "Valeriana officinalis"));
        return herbItems;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));

        HistoryFragment historyFragment = new HistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("History",herbItems.get(position));
        historyFragment.setArguments(bundle);



        startActivity(intent);
    }
}