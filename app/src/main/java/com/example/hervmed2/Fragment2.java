package com.example.hervmed2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Fragment2 extends Fragment implements HerbAdapter.OnNoteListenerHerb{
    ArrayList<HerbItems> herbItems = new ArrayList<>();
    EditText editText;
    View view;
    HerbAdapter hAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);

        ((MainActivity) requireActivity()).hideActionBarInFragment(); // hide action bar in fragment

        initialize();

        RecyclerView recyclerView = view.findViewById(R.id.searchRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        hAdapter = new HerbAdapter(initHerb(), this);
        recyclerView.setAdapter(hAdapter);

        textListener(); // Filter list when searching
        sortArrayList();


        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void sortArrayList(){
        Collections.sort(herbItems, new Comparator<HerbItems>() {
            @Override
            public int compare(HerbItems herbItems, HerbItems t1) {
                return herbItems.getTitle().compareTo(t1.getTitle());
            }
        });

        hAdapter.notifyDataSetChanged();
    }

    private ArrayList<HerbItems> initHerb(){
        herbItems.add(new HerbItems(R.drawable.borage, "Borage", "Borago officinalis"));
        herbItems.add(new HerbItems(R.drawable.chamomile2, "Chamomile", "Matricaria chamomilla"));
        herbItems.add(new HerbItems(R.drawable.echinacea, "Echinacea", "Echinacea purpurea"));
        herbItems.add(new HerbItems(R.drawable.elderberry, "Elderberry", "Sambucus"));
        herbItems.add(new HerbItems(R.drawable.ginger, "Ginger", "Zingiber officinale"));
        herbItems.add(new HerbItems(R.drawable.ginkgo_biloba, "Ginkgo", "Ginkgo biloba"));
        herbItems.add(new HerbItems(R.drawable.ginseng, "Ginseng", "Panax ginseng"));
        herbItems.add(new HerbItems(R.drawable.st_johns_wort, "St. John's Wort", "Hypericum perforatum"));
        herbItems.add(new HerbItems(R.drawable.turmeric, "Turmeric", "Curcuma longa"));
        herbItems.add(new HerbItems(R.drawable.valerian, "Valerian", "Valeriana officinalis"));
        return herbItems;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));


        startActivity(intent);

    }

    public void initialize(){
        editText = view.findViewById(R.id.ediTextSearch);
    }

    public void textListener(){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                hAdapter.getFilter().filter(editable);
            }
        });
    }

}
