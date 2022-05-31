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
        herbItems.add(new HerbItems(R.drawable.acapulco, "Acapulco", "Senna Alata",R.string.acapulco_content));
        herbItems.add(new HerbItems(R.drawable.anise_hyssop, "Anise hyssop", "Agastache foeniculum`", R.string.anise_content));
        herbItems.add(new HerbItems(R.drawable.ayahuasca, "Ayahuasca", "Banisteriopsis caapi", R.string.ayahuasca_content));
        herbItems.add(new HerbItems(R.drawable.bael, "Bael", "Aegle marmelos", R.string.bael_content));
        herbItems.add(new HerbItems(R.drawable.betel_nut, "Betel nut", "Areca catechu", R.string.betel_nut_content));
        herbItems.add(new HerbItems(R.drawable.bitter_melon, "Bitter melon", "Momordica charantia", R.string.bitter_melon_content));
        herbItems.add(new HerbItems(R.drawable.blackberry, "Blackberry", "Rubus", R.string.blackberry_content));
        herbItems.add(new HerbItems(R.drawable.borage, "Borage", "Borago officinalis",R.string.chamomile_content));
        herbItems.add(new HerbItems(R.drawable.canabis, "Canabis", "Cannabis sativa",R.string.cannabis_content));
        herbItems.add(new HerbItems(R.drawable.catnip, "Catnip", "Nepeta cataria", R.string.catnip_content));
        herbItems.add(new HerbItems(R.drawable.chamomile2, "Chamomile", "Matricaria chamomilla", R.string.chamomile_content));
        herbItems.add(new HerbItems(R.drawable.chaparral, "Chaparral", "Larrea tridentata", R.string.chaparral_content));
        herbItems.add(new HerbItems(R.drawable.chaste_tree, "Chaste tree", "Vitex agnus-castus", R.string.chaste_tree_content));
        herbItems.add(new HerbItems(R.drawable.chives, "Chives", "Allium schoenoprasum", R.string.chives_content));
        herbItems.add(new HerbItems(R.drawable.cinnamon, "Cinnamon", "Cinnamomum verum",R.string.cinnamon_content));
        herbItems.add(new HerbItems(R.drawable.coca, "Coca", "Erythroxylum coca", R.string.coca_content));
        herbItems.add(new HerbItems(R.drawable.comfrey, "Comfrey", "Symphytum",R.string.comfrey_content));
        herbItems.add(new HerbItems(R.drawable.echinacea, "Echinacea", "Echinacea purpurea", R.string.echinacea_content));
        herbItems.add(new HerbItems(R.drawable.elderberry, "Elderberry", "Sambucus",R.string.elderberry_content));
        herbItems.add(new HerbItems(R.drawable.epazote, "Epazote", "Dysphania ambrosioides",R.string.epazote_content));
        herbItems.add(new HerbItems(R.drawable.ephedra, "Ephedra", "Ephedra equisetina Bge.", R.string.ephedra_content));
        herbItems.add(new HerbItems(R.drawable.feverfew, "Feverfew", "Tanacetum parthenium", R.string.feverfew_content));
        herbItems.add(new HerbItems(R.drawable.fukien_tea_tree, "Fukien tea tree", "Ehretia microphylla", R.string.fukien_tea_tree_content));
        herbItems.add(new HerbItems(R.drawable.french_sorrel, "French sorrel", "Rumex scutatus", R.string.french_sorrel_content));
        herbItems.add(new HerbItems(R.drawable.garlic, "Garlic", "Allium sativum", R.string.garlic_content));
        herbItems.add(new HerbItems(R.drawable.germander, "Germander", "Teucrium", R.string.germander_content));
        herbItems.add(new HerbItems(R.drawable.ginger, "Ginger", "Zingiber officinale",R.string.ginger_content));
        herbItems.add(new HerbItems(R.drawable.ginkgo_biloba, "Ginkgo", "Ginkgo biloba",R.string.ginkgo_content));
        herbItems.add(new HerbItems(R.drawable.ginseng, "Ginseng", "Panax ginseng",R.string.ginseng_content));
        herbItems.add(new HerbItems(R.drawable.goji_berry, "Goji berry", "Lycium barbarum",R.string.goji_berry_content));
        herbItems.add(new HerbItems(R.drawable.gooseberry, "Gooseberry", "Ribes uva-crispa", R.string.gooseberry_content));
        herbItems.add(new HerbItems(R.drawable.golden_ragwort, "Golden ragwort", "Packera aurea", R.string.golden_ragwort_content));
        herbItems.add(new HerbItems(R.drawable.guava, "Guava", "Psidium guajava", R.string.guava_content));
        herbItems.add(new HerbItems(R.drawable.henna, "Henna", "Lawsonia inermis", R.string.henna_content));
        herbItems.add(new HerbItems(R.drawable.jimsonweed, "Jimsonweed", "Datura stramonium", R.string.jimsonweed_content));
        herbItems.add(new HerbItems(R.drawable.juniper, "Juniper berry", "Juniperus communis berries", R.string.juniper_content));
        herbItems.add(new HerbItems(R.drawable.lavender, "Lavender", "Tagetes", R.string.lavender_content));
        herbItems.add(new HerbItems(R.drawable.lettuce_leaf_basil, "Lettuce-leaf basil", "Perilla frutescens var. crispa", R.string.lettuce_leaf_basil_content));
        herbItems.add(new HerbItems(R.drawable.lilac, "Lilac", "genus Syringa", R.string.lilac_content));
        herbItems.add(new HerbItems(R.drawable.lovage, "Lovage", "Levisticum officinale", R.string.lovage_content));
        herbItems.add(new HerbItems(R.drawable.marigold, "Marigold", "Perilla frutescens var. crispa", R.string.marigold_content));
        herbItems.add(new HerbItems(R.drawable.marsh_mallow, "Marsh mallow", "Althaea officinalis", R.string.marsh_mallow_content));
        herbItems.add(new HerbItems(R.drawable.mulberry, "Mulberry", "Mentha pulegium",R.string.mulberry_content));
        herbItems.add(new HerbItems(R.drawable.neem, "Neem", "Azadirachta indica",R.string.neem_content));
        herbItems.add(new HerbItems(R.drawable.oppium_poppy, "Oppium poppy", "Papaver somniferum", R.string.oppium_poppy_content));
        herbItems.add(new HerbItems(R.drawable.pennyroyal, "Pennyroyal", "Mentha pulegium",R.string.pennyroyal_content));
        herbItems.add(new HerbItems(R.drawable.peppermint, "Peppermint", "Mentha × piperita", R.string.peppermint_content));
        herbItems.add(new HerbItems(R.drawable.pepper_elder, "Pepper elder", "Peperomia pellucida", R.string.pepper_elder_content));
        herbItems.add(new HerbItems(R.drawable.peyote, "Peyote", "Lophophora williamsii",R.string.peyote_content));
        herbItems.add(new HerbItems(R.drawable.rangoon_creeper, "Rangoon creeper", "Combretum indicum", R.string.rangoon_creeper_content));
        herbItems.add(new HerbItems(R.drawable.raspberry, "Raspberry", "Rubus idaeus", R.string.raspberry_content));
        herbItems.add(new HerbItems(R.drawable.red_currant, "Red currant", "Ribes rubrum",R.string.redcurrant_content));
        herbItems.add(new HerbItems(R.drawable.rhubarb, "Rhubarb", "Rheum rhabarbarum",R.string.rhubarb_content));
        herbItems.add(new HerbItems(R.drawable.rose_hips, "Rose hips", "Rosa canina L.",R.string.rosehip_content));
        herbItems.add(new HerbItems(R.drawable.rosemary, "Rosemary", "Salvia rosmarinus",R.string.rosemary_content));
        herbItems.add(new HerbItems(R.drawable.saffron, "Saffron", "Crocus sativus",R.string.saffron_content));
        herbItems.add(new HerbItems(R.drawable.salvia, "Sage of the diviners", "Salvia divinorum", R.string.salvia_content));
        herbItems.add(new HerbItems(R.drawable.sambong, "Sambong", "Blumea balsamifera", R.string.sambong_content));
        herbItems.add(new HerbItems(R.drawable.sassafras, "Sassafras", "Sassafras albidum", R.string.sassafras_content));
        herbItems.add(new HerbItems(R.drawable.stevia, "Stevia", "Stevia rebaudiana",R.string.stevia_content));
        herbItems.add(new HerbItems(R.drawable.st_johns_wort, "St. John's Wort", "Hypericum perforatum", R.string.st_johns_wort_content));
        herbItems.add(new HerbItems(R.drawable.sweet_cicely, "Sweet cicely", "Myrrhis odorata",R.string.sweet_cicely_content));
        herbItems.add(new HerbItems(R.drawable.sweet_flag, "Sweet flag", "Nicotiana tabacum",R.string.sweet_flag_content));
        herbItems.add(new HerbItems(R.drawable.tobacco, "Tobacco", "Nicotiana tabacum",R.string.tobaco_content));
        herbItems.add(new HerbItems(R.drawable.tulsi, "Tulsi", "Ocimum tenuiflorum",R.string.tulsi_content));
        herbItems.add(new HerbItems(R.drawable.turmeric, "Turmeric", "Curcuma longa",R.string.turmeric_content));
        herbItems.add(new HerbItems(R.drawable.valerian, "Valerian", "Valeriana officinalis", R.string.valerian_content));
        herbItems.add(new HerbItems(R.drawable.white_clover, "White clover", "Trifolium repens",R.string.white_clover_content));
        herbItems.add(new HerbItems(R.drawable.yerba_buena, "Yerba buena", "Combretum indicum", R.string.yerba_buena_content));
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
