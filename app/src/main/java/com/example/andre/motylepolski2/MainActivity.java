package com.example.andre.motylepolski2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Butterfly> data;
    private ArrayAdapter<Butterfly> adapter;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);


        data = new ArrayList<Butterfly>();
        data.add(new Butterfly(R.drawable.bielinek_rukiewnik_icon, "Bielinek Rukiewnik", "Pontia edusa" ));
        data.add(new Butterfly(R.drawable.bielinek_rzepnik_icon, "Bielinek Rzepnik", "Pieris rapae"));
        data.add(new Butterfly(R.drawable.czerwonczyk_nieparek_icon, "Czerwończyk Nieparek", "Lycaena dispar"));
        data.add(new Butterfly(R.drawable.dostojka_selene_icon, "Dostojka Selene", "Boloria selene"));
        data.add(new Butterfly(R.drawable.latolistek_cytrynek_icon, "Latolistek Cytrynek", "Gonepteryx rhamni"));
        data.add(new Butterfly(R.drawable.mieniak_struznik_icon, "Mieniak Strużnik", "Apatura ilia"));
        data.add(new Butterfly(R.drawable.modraszek_zwieszczek_icon, "Modraszek Wieszczek", "Celastrina argiolus"));
        data.add(new Butterfly(R.drawable.paz_krolowej_icon, "Paź Królowej", "Papilio machaon"));
        data.add(new Butterfly(R.drawable.paz_zeglarz, "Paź Żeglarz", "Iphiclides podalirius "));
        data.add(new Butterfly(R.drawable.rusalka_admiral_icon, "Rusałka Admirał", "Vanessa atalanta"));
        data.add(new Butterfly(R.drawable.rusalka_osetnik_icon, "Rusałka Osetnik", "Vanessa cardui "));
        data.add(new Butterfly(R.drawable.rusalka_pawik_icon, "Rusałka Pawik", "Aglais io "));
        data.add(new Butterfly(R.drawable.rusalka_pokrzywnik_icon, "Rusałka Pokrzywnik", "Aglais urticae "));
        data.add(new Butterfly(R.drawable.rusalka_zalobnik_icon, "Rusałka Żałobnik", "Nymphalis antiopa"));
        data.add(new Butterfly(R.drawable.skalnik_driada_icon, "Skalnik Driada", "Minois dryas"));
        data.add(new Butterfly(R.drawable.zorzynek_rzezuchowiec, "Zorzynek Rzeżuchowiec", "Anthocharis cardamines"));


        adapter = new ButterfliesAdapter(this, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, ButterflyDetail.class);

                i.putExtra("name", data.get(position).getName());
                i.putExtra("latin", data.get(position).getLatinName());
                i.putExtra("image", data.get(position).getImageButterflyId());
                startActivity(i);
                //Toast.makeText(getApplicationContext(), "" + (data.get(position).getLatinName()), Toast.LENGTH_SHORT).show();

            }
        });





    }
}
