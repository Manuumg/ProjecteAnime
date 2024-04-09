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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerView;
    List<Anime> animes = new ArrayList<>();
    private static String JSON_URL =
            "https://joanseculi.com/edt69/animes3.php?email=mgonzalez@mail.com";
   MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView = findViewById(R.id.recyclerView);


        getAnimes();



    }



   private void getAnimes() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                JSON_URL,
                null,


                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {



                        try {
                            JSONArray jsonArray = response.getJSONArray("animes");

                            for(int i = 0; i < jsonArray.length(); i++){
                                try {
                                    JSONObject animeObject = jsonArray.getJSONObject(i);
                                    Anime anime = new Anime();
                                    anime.setId(animeObject.getInt("id"));
                                    anime.setName(animeObject.getString("name"));
                                    anime.setDescription(animeObject.getString("description"));
                                    anime.setType(animeObject.getString("type"));
                                    anime.setYear(animeObject.getInt("year"));
                                    anime.setImage(animeObject.getString("image"));
                                    anime.setImage2(animeObject.getString("image2"));
                                    anime.setOriginalname(animeObject.getString("originalname"));
                                    anime.setRating(animeObject.getString("rating"));
                                    anime.setDemography(animeObject.getString("demography"));
                                    anime.setGenre(animeObject.getString("genre"));
                                    anime.setActive(animeObject.getBoolean("active"));
                                    anime.setFavorite(animeObject.getString("favorite"));
                                    animes.add(anime);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


                        recyclerView.setAdapter(myAdapter);


                        recyclerView.setLayoutManager(new
                                        LinearLayoutManager(getApplicationContext()));
                        myAdapter = new MyAdapter(getApplicationContext(), animes);
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
