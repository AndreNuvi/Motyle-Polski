package com.example.andre.motylepolski2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        listView = (ListView)findViewById(R.id.listView);

        data = new ArrayList<Butterfly>();
        data.add(new Butterfly(R.drawable.bielinek_kapustnik_small, "Bielinek Kapustnik", "Kapusto bielinko"));
        data.add(new Butterfly(R.drawable.dostojka_eunomia_small, "Bielinek Kapustnik", "Kapusto bielinko"));
        data.add(new Butterfly(R.drawable.przeplatka_aurelia_small, "Bielinek Kapustnik", "Kapusto bielinko"));
        data.add(new Butterfly(R.drawable.skalnik_driada_small, "Bielinek Kapustnik", "Kapusto bielinko"));
        data.add(new Butterfly(R.drawable.bielinek_kapustnik_small, "Bielinek Kapustnik", "Kapusto bielinko"));
        data.add(new Butterfly(R.drawable.dostojka_eunomia_small, "Bielinek Kapustnik", "Kapusto bielinko"));
        data.add(new Butterfly(R.drawable.przeplatka_aurelia_small, "Bielinek Kapustnik", "Kapusto bielinko"));
        data.add(new Butterfly(R.drawable.skalnik_driada_small, "Bielinek Kapustnik", "Kapusto bielinko"));

        adapter = new ButterfliesAdapter(this,data);
        listView.setAdapter(adapter);


    }
}
