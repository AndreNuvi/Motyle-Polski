package com.example.andre.motylepolski2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String STATE_LIST = "stateList";

    public ListView listView;
    public ButterfliesAdapter adapter;
    public ArrayList<Butterfly> data;
    private SharedPreferences preferences;
    MenuItem searchItem;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        preferences = getSharedPreferences("listViewPosition", Activity.MODE_PRIVATE);

        data = new ArrayList<Butterfly>();

        String style = "<style> p{text-align: justify;} h3{text-align: center;} h4{text-align: center; margin-top:50px;} a{ color: black;}</style>";

        data.add(new Butterfly(
                "Bielinek Rukiewnik",
                "Pontia Edusa",
                "biały",
                R.drawable.bielinek_rukiewnik_icon,
                R.drawable.bielinek_rukiewnik_imago1,
                R.drawable.bielinek_rukiewnik_imago2,
                R.drawable.bielinek_rukiewnik_imago3,
                R.drawable.bielinek_rukiewnik_caterpillar,
                R.drawable.bielinek_rukiewnik_cocoon,
                R.drawable.bielinek_rukiewnik_egg,
                R.drawable.bielinek_rukiewnik_area,
                style +
                        "<h3>Informacje:</h3>" +
                        "<p>Niezbyt pospolity. Stale migruje, co jest rzadkością u bielinków. Wyróżniamy odmianę wschodnią i zachodnią, które różnią się głównie biochemią. Prawnie chroniony (LR - gatunek niższego ryzyka).</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Ciepłe otwarte tereny, suche łąki, nieużytki, tereny ruderalne. </p>" +

                        "<h3>Pożywienie:</h3>" +
                        "<p>Gorczyca, gęsiówka, rezeda żółta, smagliczka.</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=6653&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"

        ));

        data.add(new Butterfly("" +
                "Bielinek Rzepnik",
                "Pieris rapae",
                "biały",
                R.drawable.bielinek_rzepnik_icon, R.drawable.bielinek_rzepnik_imago1, R.drawable.bielinek_rzepnik_imago2,
                R.drawable.bielinek_rzepnik_imago3, R.drawable.bielinek_rzepnik_caterpillar, R.drawable.bielinek_rzepnik_cocoon, R.drawable.bielinek_rzepnik_egg,
                R.drawable.bielinek_rzepnik_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl pospolity. W większych ilościach może wyrządzać szkody w uprawach rolnych. Lata stosunkowo powoli – 9 uderzeń skrzydła na sekundę.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Występuję w lasach, zaroślach, sadach, ogrodach, terenach ruderalnych, na polach, miedzach." +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Rośliny z rodziny kapustowatych takie jak kapusta, pieprzyca, gęsiówka, czosnaczek. </p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=10&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Czerwończyk Nieparek", "Lycaena dispar", "pomarańczowy", R.drawable.czerwonczyk_nieparek_icon, R.drawable.czerwonczyk_nieparek_imago1, R.drawable.czerwonczyk_nieparek_imago2,
                R.drawable.czerwonczyk_nieparek_imago3, R.drawable.czerwonczyk_nieparek_caterpillar, R.drawable.czerwonczyk_nieparek_cocoon, R.drawable.czerwonczyk_nieparek_egg,
                R.drawable.czerwonczyk_nieparek_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Dość pospolity w Polsce chociaż w niewielkim zagęszczeniu. Wyginął na wielu stanowiskach w Europie w wyniku zarastania torfowisk. Prawnie chroniony (LR - gatunek niższego ryzyka).</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Podmokłe łąki oraz torfowiska niskie. Ostatnio obserwuje się go również w siedliskach suchszych, takich jak siedliska ruderalne.</p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Szczaw lancetowaty oraz inne gatunki szczawiu</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=131&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Dostojka Selene", "Boloria selene", "pomarańczowy", R.drawable.dostojka_selene_icon, R.drawable.dostojka_selene_imago1, R.drawable.dostojka_selene_imago2,
                R.drawable.dostojka_selene_imago3, R.drawable.dostojka_selene_caterpillar, R.drawable.dostojka_selene_cocoon, R.drawable.dostojka_selene_egg,
                R.drawable.dostojka_selene_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Pospolity na terenie kraju.Larwa w poszukiwaniu pokarmu może przebyć dość duże odległości, rzędu kilku metrów. Inaczej jak u innych dostojek, larwy selene unikają słońca.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Wilgotne łąki, torfowiska i tereny bagienne, poza tym polany leśne, ugory i suche łąki </p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Fiołki</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=41&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Latolistek Cytrynek", "Gonepteryx rhamni", "żółty", R.drawable.latolistek_cytrynek_icon, R.drawable.latolistek_cytynek_imago1, R.drawable.latolistek_cytynek_imago2,
                R.drawable.latolistek_cytynek_imago3, R.drawable.latolistek_cytynek_caterpillar, R.drawable.latolistek_cytrynek_cocoon, R.drawable.latolistek_cytrynek_egg,
                R.drawable.latolistek_cytrynek_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl pospolity. Jest to jedyny europejski motyl zimujący w opadłych liściach. Nazwa \"Listkowiec\" wzięła się z tego, że zimuje w opadłych listkach, a \"cytrynek\" nie tylko od koloru, ale i zapachu - jego skrzydełka pachną cytryną. Motyl ten jest jednym z najbardziej długowiecznych motyli Europy. Żyje do jedenastu miesięcy. To jeden z najwcześniej pojawiających się wiosną motyli. Dzięki temu to jedne z nielicznych owadów, które zapylają pierwiosnki. To typowy zwiastun wiosny.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Wolne przestrzenie w pobliżu lasów. Można go także spotkać na nasłonecznionych polanach i w ogrodach, lasach, zaroślach, miedzach, terenach ruderalnych. </p>" +

                        "<h3>Pożywienie:</h3>" +
                        "<p>Szakłak pospolity, kruszyna</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=23&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Mieniak Strużnik", "Apatura ilia", "czarny", R.drawable.mieniak_struznik_icon, R.drawable.mieniak_struznik_imago1, R.drawable.mieniak_struznik_imago2,
                R.drawable.mieniak_struznik_imago3, R.drawable.mieniak_struznik_caterpillar, R.drawable.mieniak_struznik_cocoon, R.drawable.mieniak_struznik_egg,
                R.drawable.mieniak_struznik_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl powszechnie występujący ale nieliczny. W odróżnieniu od większości motyli dziennych żywi się sokiem wyciekającym z ran na drzewach oraz płynami zawartymi w gnijących substancjach (także odchodach zwierzęcych). Często występuje też inna forma strużnika, która różni się od formy podstawowej pomarańczowym zabarwieniem plam na skrzydłach. Odmiana ta jest lokalnie częstsza od nominatywnej. </p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Nasłonecznione lasy liściaste i mieszane. </p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Topole i wierzby</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=26&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Modraszek Wieszczek", "Celastrina argiolus", "niebieski", R.drawable.modraszek_zwieszczek_icon, R.drawable.modraszek_zwieszczek_imago1, R.drawable.modraszek_zwieszczek_imago2,
                R.drawable.modraszek_zwieszczek_imago3, R.drawable.modraszek_zwieszczek_caterpillar, R.drawable.modraszek_zwieszczek_cocoon, R.drawable.modraszek_zwieszczek_egg,
                R.drawable.modraszek_zwieszczek_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Pospolity i liczny. Obwieszcza wiosnę. Znany również jako modraszek kruszyniak. Gąsiennice w zamian za ochronę są dojone przez mrówki z rodzajów Lasius, Formica i Myrmica. </p>" +

                        "<h3>Występowanie</h3>" +
                        "<p> Wysępuje w lasach liściastych i mieszanych, zaroślach, zrębach i wrzosowiskach </p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Gąsiennice są wielożerne, żywią się min. bluszcz, borówka, dereń, wrzos, kruszyna, malina.</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=122\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Paź Królowej", "Papilio machaon", "żółty", R.drawable.paz_krolowej_icon, R.drawable.paz_krolowej_imago1, R.drawable.paz_krolowej_imago2,
                R.drawable.paz_krolowej_imago3, R.drawable.paz_krolowej_caterpillar, R.drawable.paz_krolowej_cocoon, R.drawable.paz_krolowej_egg,
                R.drawable.paz_krolowej_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Był niegdyś bardzo licznym motylem, ale wskutek nowoczesnego rolnictwa i działalności kolekcjonerów, w niektórych miejscach niemal wyginął. Na Bliskim Wschodzie paź królowej jest notowany jako szkodnik drzew cytrusowych.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Tereny otwarte, łąki, ugory, tereny ruderalne, przytorza, obrzeża lasów sosnowych.</p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Rośliny baldaszkowate, zwłaszcza dzikia i ogrodowa marchew, koper, biedrzenieca, kminek i pietruszka</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=5&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Paź Żeglarz", "Iphiclides podalirius ", "żółty", R.drawable.paz_zeglarz_icon, R.drawable.paz_zeglarz_imago1, R.drawable.paz_zeglarz_imago2,
                R.drawable.paz_zeglarz_imago3, R.drawable.paz_zeglarz_caterpillar, R.drawable.paz_zeglarz_cocoon, R.drawable.paz_zeglarz_egg,
                R.drawable.paz_zeglarz_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl rzadki, chroniony. Jeszcze 100 lat temu był to gaunek pospolity, uznawany za szkodnika. Osobniki dorosłe latają szybko, charakterystycznym lotem szybowcowym. Żegluje w powietrzu z czego wzięła się jego nazwa. </p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Murawy, zadrzewienia śródpolne, skraje lasów, sady. </p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Tarnina, głóg, czeremcha, drzewa owocowe.</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=4&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Rusałka Admirał", "Vanessa atalanta", "czarny", R.drawable.rusalka_admiral_icon, R.drawable.rusalka_admiral_imago1, R.drawable.rusalka_admiral_imago2,
                R.drawable.rusalka_admiral_imago3, R.drawable.rusalka_admiral_caterpillar, R.drawable.rusalka_admiral_cocoon, R.drawable.rusalka_admiral_egg,
                R.drawable.rusalk_admiral_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl ten migruje. Wiosną można u nas spotkać osobniki migrujące z południa Europy. Pokolenie drugie, które u nas się rozwija na jesień, odlatuje na południe. Coraz częściej zdarza się, że motyl ten u nas zimuje, ze względu na łagodne zimy.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p Występuje na wielu stanowiskach.</p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Gąsienice żerują na pokrzywie zwyczajnej i żegawce.</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=98&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Rusałka Osetnik", "Vanessa cardui ", "pomarańczowy", R.drawable.rusalka_osetnik_icon, R.drawable.rusalka_osetnik_imago1, R.drawable.rusalka_osetnik_imago2,
                R.drawable.rusalka_osetnik_imago3, R.drawable.rusalka_osetnik_caterpillar, R.drawable.rusalka_osetnik_cocoon, R.drawable.rusalka_osetnik_egg,
                R.drawable.rusalka_osetnik_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl pospolity, wędrowny. Odbywa dalekie migracje z i do Afryki około 14 tys. km. Pełen cykl w ciagu roku nie pokonuje jeden motyl a kilka jego pokoleń. Wędrówki odbywają na wysokości około 500 metrów gdzie wiatry nadają im średniej prędkości około 45 km /h.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Tereny ruderalne, ogrody, miedze, ugory, przydroża. Rusałka osetnik unika lasów.</p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Ostrożeń, oset, popłoch i pokrzywa zwyczajna </p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=99&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Rusałka Pawik", "Aglais io", "czerwony", R.drawable.rusalka_pawik_icon, R.drawable.rusalka_pawik_imago1, R.drawable.rusalka_pawik_imago2,
                R.drawable.rusalka_pawik_imago3, R.drawable.rusalka_pawik_caterpillar, R.drawable.rusalka_pawik_caterpillar, R.drawable.rusalka_pawik_egg,
                R.drawable.rusalka_pawik_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl pospolity. Zyje nawet do 10 miesięcy. Oczy na skrzydłach służą do odstraszania i drapieżników, dodatkowo potrafi wytwarzać dźwięk przypominający syk. Jest bardzo terytorialny</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Motyl ten spotykany jest w lasach, parkach, ogrodach, na łąkach, w górach i na nizinach.</p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Pokrzywa i chmiel</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=70&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Rusałka Pokrzywnik", "Aglais urticae", "pomarańczowy", R.drawable.rusalka_pokrzywnik_icon, R.drawable.rusalka_pokrzywnik_imago1, R.drawable.rusalka_pokrzywnik_imago2,
                R.drawable.rusalka_pokrzywnik_imago3, R.drawable.rusalka_pokrzywnik_caterpillar, R.drawable.rusalka_pokrzywnik_cocoon, R.drawable.rusalka_pokrzywnik_egg,
                R.drawable.rusalka_pokrzywnik_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl pospolity. Jest kilka gatunków podobnych do niego. Zazwyczaj jednak są one na pierwszy rzut oka nie do odróżnienia. Stąd też większość ludzi nazywa wszystkie te gatunki - rusałką pokrzywnikiem.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Można go spotkać na nasłonecznionych leśnych polanach, leśnych drogach, łąkach, w ogrodach oraz terenach ruderalnych.</p>" +

                        "<h3>Pożywienie:</h3>" +
                        "<p>Pokrzywa</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=25&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Rusałka Żałobnik", "Nymphalis antiopa", "czarny", R.drawable.rusalka_zalobnik_icon, R.drawable.rusalka_zalobnik_imago1, R.drawable.rusalka_zalobnik_imago2,
                R.drawable.rusalka_zalobnik_imago3, R.drawable.rusalka_zalobnik_caterpillar, R.drawable.rusalka_zalobnik_cocoon, R.drawable.rusalka_zalobnik_egg,
                R.drawable.rusalka_zalobnik_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>W Polsce rozpowszechniony, spotykany pojedyńczo. Podstawę jego dorosłej formy stanowią fermentujące owoce i soki wyciekające z uszkodzonych drzew. Z reguły są to motyle bardzo płochliwe i trudno je oglądać z bliska. W dawnych wierzeniach, motyl ten był uważany za przeklętego, a jego zimowanie w czyimś domu, miało oznaczać śmierć któregoś z domowników </p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Nasłonecznione skraje lasów liściastych, leśne drogi i polany sąsiadujące z lasem liściastym lub mieszanym.</p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Brzozy, wiązy, osiki, grusze</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=90&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Skalnik Driada", "Minois dryas", "brązowy", R.drawable.skalnik_driada_icon, R.drawable.skalnik_driada_imago1, R.drawable.skalnik_driada_imago2,
                R.drawable.skalnik_driada_imago3, R.drawable.skalnik_driada_caterpillar, R.drawable.skalnik_driada_cocoon, R.drawable.skalnik_driada_egg,
                R.drawable.skalnik_driada_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl pospolity. Silnie terytorialny. Samice rozpylają na roślinach feromon informujący inne samice, że tu jest już złożone jajo. Gąsiennice mogą uprawiać kanibalizm. </p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Tereny podmokłe, wilgotne łąki, skraje lasów oraz drogi i polany leśne.</p>" +

                        "<h3>Pożywienie gąsiennic:</h3>" +
                        "<p>Rzeżucha łąkowa, czosnaczek pospolity, wieżyczka gładka czy stulisz lekarski.</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=87&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));

        data.add(new Butterfly("Zorzynek Rzeżuchowiec", "Anthocharis cardamines", "biały", R.drawable.zorzynek_rzezuchowiec_icon, R.drawable.zorzynek_rzezuchowiec_imago1, R.drawable.zorzynek_rzezuchowiec_imago2,
                R.drawable.zorzynek_rzezuchowiec_imago3, R.drawable.zorzynek_rzezuchowiec_caterpillar, R.drawable.zorzynek_rzezuchowiec_cocoon, R.drawable.zorzynek_rzezuchowiec_egg,
                R.drawable.zorzynek_rzezuchowiec_area,
                style +

                        "<h3>Informacje:</h3>" +
                        "<p>Motyl pospolity. Jest kilka gatunków podobnych do niego. Zazwyczaj jednak są one na pierwszy rzut oka nie do odróżnienia. Stąd też większość ludzi nazywa wszystkie te gatunki - rusałką pokrzywnikiem.</p>" +

                        "<h3>Występowanie</h3>" +
                        "<p>Można go spotkać na nasłonecznionych leśnych polanach, leśnych drogach, łąkach, w ogrodach oraz terenach ruderalnych.</p>" +

                        "<h3>Pożywienie:</h3>" +
                        "<p>Pokrzywa</p>" +

                        "<h4><a href=\"http://www.lepidoptera.eu/show.php?ID=20&country=PL\">Źródło zdjęć: www.lepidoptera.eu</a></h4>"));


        adapter = new ButterfliesAdapter(this, data);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Intent i = new Intent(MainActivity.this, ButterflyDetail.class);

                i.putExtra("name", data.get(position).getName());
                i.putExtra("latin", data.get(position).getLatinName());
                i.putExtra("imageImago1", data.get(position).getButterflyImago1());
                i.putExtra("imageImago2", data.get(position).getButterflyImago2());
                i.putExtra("imageImago3", data.get(position).getButterflyImago3());
                i.putExtra("imageCaterpillar", data.get(position).getButterflyCaterpillar());
                i.putExtra("imageCocoon", data.get(position).getButterflyCocoon());
                i.putExtra("imageEgg", data.get(position).getButterflyEgg());
                i.putExtra("imageArea", data.get(position).getButterflyArea());
                i.putExtra("detailInfo", data.get(position).getDetailInfo());
                startActivity(i);

            }

        });

        listView.setTextFilterEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
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

