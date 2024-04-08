package com.example.projecteanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<Anime> animes = new ArrayList<>();
    private static String JSON_URL =
            "https://joanseculi.com/edt69/animes3.php?email=mgonzalez@mail.com";
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView =findViewById(R.id.recyclerView);


        myAdapter= new MyAdapter(animes,this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();

    }

    /*private void initData() {
        Anime anime = new Anime(
                1,
                "The Idaten Deities Know Only Peace",
                "Eight hundred years ago, terrifying demons threatened mankind's existence. On the brink of extinction, humans prayed to their gods, calling out for someone to save them. Emerging from these desperate pleas for salvation, battle deities known as the \"Idaten\" were born. Possessing unnatural strength and endurance, the Idaten managed to defeat the demons and an era of unprecedented peace was finally ushered in.\r\nHaving never encountered demons before, the present generation of Idaten knows nothing of the demon's brutality, but they have instead only lived a peaceful existence. Training under Rin, the only remaining Idaten from 800 years ago, the new Idaten find ways to survive in a time where they have seemingly outlived their usefulness. However, when the tyrannical Zoble Empire resurrects a demon, the misfit crop of gods are called to the battlefield against their natural enemy once more. ",
                "TV",
                2018,
                "edt69/images/1.jpg",
                "edt69/images/1b.jpg",
                "Heion Sedai no Idaten-tachi",
                "17+",
                "Seinen",
                "Dark fantasy",
                true,
                null


        );


        Anime anime1 = new Anime(
                2,
                "Sonny Boy",
                "El drama de ciencia ficci\u00f3n se centra en treinta y seis chicos y chicas. El 16 de agosto, a mitad de unas vacaciones de verano aparentemente interminables, el estudiante de tercer a\u00f1o de preparatoria Nagara, la misteriosa estudiante transferida Nozomi y compa\u00f1eros de clase como Mizuho y Asakaze, son repentinamente transportados de su tranquila vida cotidiana a una escuela a la deriva en una dimensi\u00f3n alternativa. Deber\u00e1n sobrevivir con los superpoderes que han despertado en su interior.",
                "TV",
                2021,
                "edt69/images/2.jpg",
                "edt69/images/2b.jpg",
                "Sonny Boy",
                "13+",
                "Sh\u00f4nen",
                "Science fiction, Survival",
                true,
                null

        );


        Anime anime2 = new Anime(
                3,
                "Mother of the Goddess\u2019 Dormitory",
                "Koshi Nagumo is a 12-year-old boy who was abandoned by his broke father after their house caught on fire, leaving him to roam the streets penniless. He then one day, meets a girl named Mineru who finds him lying on the sidewalk. She takes him to a women\u2019s college dormitory, one known for housing troublesome residents, and asks him to be their \"Dormitory Mother.\" Surrounded by older women and forced to deal with their idiosyncrasies, Koshi starts his new life!",
                "TV",
                2021,
                "edt69/images/3.jpg",
                "edt69/images/3b.jpg",
                "Megami-Ryou no Ryoubo-kun",
                "12+",
                "Sh\u00f4nen",
                "Harem, Comedy, Romance, Ecchi",
                true,
                null
        );


        Anime anime3 = new Anime(
                4,
                "Night Head 2041",
                "In the year 2041, World War III has wiped out two-thirds of the human population, and in the newfound structure, the belief in any god or beyond-human entity is considered a preposterous notion. In order to prevent citizens from bearing possibly incriminating thoughts, the government has assembled a Special Weapon Enforcement division to capture and rehabilitate such believers.\r\nThe Kirihara brothers, Naoya and Naoto\u2014who were hidden away from society by their captors for years to conceal their psychic abilities\u2014were promised freedom once the world was ready to face their existence. Now, wandering in the appalling new societal climate where psychics are not welcome, the brothers find themselves on the run from the Enforcement's devoted operatives, Yuuya and Takuya Kuroki.",
                "TV",
                2021,
                "edt69/images/4.jpg",
                "edt69/images/4b.jpg",
                "Night Head 2041",
                "12+",
                "Seinen",
                "Science fiction, Supernatural, \r\nSuspense",
                true,
                null

        );
        animes.add(anime);
        animes.add(anime1);
        animes.add(anime2);
        animes.add(anime3);

    }
    */

    private void getAnimes() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                JSON_URL,
                null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject animeObject = response.getJSONObject(i);
                                Anime anime = new Anime();
                                anime.setName(animeObject.getString("name"));
                                anime.setGenre(animeObject.getString("genre"));
                                anime.setYear(animeObject.getInt("year"));
                                anime.setImage(animeObject.getString("url"));
                                animes.add(anime);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        recyclerView.setLayoutManager(new
                                LinearLayoutManager(getApplicationContext()));
                        myAdapter = new MyAdapter(animes, getApplicationContext());
                        recyclerView.setAdapter(myAdapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag", "onErrorResponse: " + error.getMessage());

                    }
                }

        );
        queue.add(jsonArrayRequest);
    }
}
