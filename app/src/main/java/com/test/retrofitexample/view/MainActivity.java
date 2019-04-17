package com.test.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.retrofitexample.MyRecyclerAdapter;
import com.test.retrofitexample.R;
import com.test.retrofitexample.di.App;
import com.test.retrofitexample.http.ApiServiceInterface;
import com.test.retrofitexample.model.Photo;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_data;
    @Inject
    ApiServiceInterface serviceInterface;

    List<String> titles;
    List<String> thumbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_data = findViewById(R.id.rv_data);

        App app = new App();
        app.getComponent().inject(this);

        Call<Photo> call = (Call<Photo>) ApiServiceInterface.getPhotos();
        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                titles.add(response.body().getTitle());
                thumbs.add(response.body().getThumbnailUrl());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                t.printStackTrace();
            }
        });

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this, titles, thumbs);
        // Set the Layout Manager.
        rv_data.setLayoutManager(new LinearLayoutManager(this));

        rv_data.setAdapter(myRecyclerAdapter);


    }
}
