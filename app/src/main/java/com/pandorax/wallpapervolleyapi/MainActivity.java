package com.pandorax.wallpapervolleyapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    //ItsFRZ

    RequestQueue requestQueue;
    ArrayList<WallpaperItem> list;
    RecyclerView recyclerView;
    WallpaperAdapter wallpaperAdapter;
    String api ="https://pixabay.com/api/?key=yourapikey&q=yellow+flowers&image_type=photo";

    // Your Api Key Is Needed at api section
    // For example api get from pixabay.com

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler123);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        list = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        readData();

    }

    private void readData() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, api, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray array = response.getJSONArray("hits");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                String url = object.getString("webformatURL");
                                String likes = object.getString("likes");
                                String download = object.getString("downloads");
                                list.add(new WallpaperItem(url, likes, download));


                            }
                            wallpaperAdapter = new WallpaperAdapter(MainActivity.this, list);
                            recyclerView.setAdapter(wallpaperAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);

    }
}
