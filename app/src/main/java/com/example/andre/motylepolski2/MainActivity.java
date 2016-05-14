package com.example.andre.motylepolski2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    public ListView listView;
    public ButterfliesAdapter adapter;
    public ArrayList<Butterfly> data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        data = new ArrayList<Butterfly>();
        data.add(new Butterfly(R.drawable.bielinek_rukiewnik_icon, "Bielinek Rukiewnik", "Pontia edusa","biały",
                R.drawable.bielinek_rukiewnik_full, R.drawable.bielinek_rukiewnik_gasiennica,R.drawable.bielinek_rukiewnik_poczwarka));
        data.add(new Butterfly(R.drawable.bielinek_rzepnik_icon, "Bielinek Rzepnik", "Pieris rapae","biały" ));
        data.add(new Butterfly(R.drawable.czerwonczyk_nieparek_icon, "Czerwończyk Nieparek", "Lycaena dispar","pomarańczowy"));
        data.add(new Butterfly(R.drawable.dostojka_selene_icon, "Dostojka Selene", "Boloria selene", "pomarańczowy"));
        data.add(new Butterfly(R.drawable.latolistek_cytrynek_icon, "Latolistek Cytrynek", "Gonepteryx rhamni","żółty"));
        data.add(new Butterfly(R.drawable.mieniak_struznik_icon, "Mieniak Strużnik", "Apatura ilia","czarny"));
        data.add(new Butterfly(R.drawable.modraszek_zwieszczek_icon, "Modraszek Wieszczek", "Celastrina argiolus", "niebieski"));
        data.add(new Butterfly(R.drawable.paz_krolowej_icon, "Paź Królowej", "Papilio machaon", "żółty"));
        data.add(new Butterfly(R.drawable.paz_zeglarz, "Paź Żeglarz", "Iphiclides podalirius ","żółty"));
        data.add(new Butterfly(R.drawable.rusalka_admiral_icon, "Rusałka Admirał", "Vanessa atalanta", "czarny"));
        data.add(new Butterfly(R.drawable.rusalka_osetnik_icon, "Rusałka Osetnik", "Vanessa cardui ","pomarańczowy"));
        data.add(new Butterfly(R.drawable.rusalka_pawik_icon, "Rusałka Pawik", "Aglais io", "czerwony"));
        data.add(new Butterfly(R.drawable.rusalka_pokrzywnik_icon, "Rusałka Pokrzywnik", "Aglais urticae", "pomarańczowy"));
        data.add(new Butterfly(R.drawable.rusalka_zalobnik_icon, "Rusałka Żałobnik", "Nymphalis antiopa","czarny"));
        data.add(new Butterfly(R.drawable.skalnik_driada_icon, "Skalnik Driada", "Minois dryas", "brązowy"));
        data.add(new Butterfly(R.drawable.zorzynek_rzezuchowiec, "Zorzynek Rzeżuchowiec", "Anthocharis cardamines", "biały"));


        adapter = new ButterfliesAdapter(this, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Intent i = new Intent(MainActivity.this, ButterflyDetail.class);

                i.putExtra("name", data.get(position).getName());
                i.putExtra("latin", data.get(position).getLatinName());
                i.putExtra("image", data.get(position).getImageButterflyId());
                i.putExtra("full", data.get(position).getImageGalleryOne());
                i.putExtra("gasienica", data.get(position).getImageGalleryTwo());
                i.putExtra("poczwarka", data.get(position).getImageGalleryThree());
                startActivity(i);



            }
        });

        listView.setTextFilterEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("Wpisz nazwę lub kolor dominujący");

        //*** setOnQueryTextFocusChangeListener ***
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchQuery) {
                adapter.filter(searchQuery.toString().trim());
                listView.invalidate();
                return true;
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
