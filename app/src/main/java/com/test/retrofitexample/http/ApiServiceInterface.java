package com.test.retrofitexample.http;


import com.test.retrofitexample.model.Photo;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.GET;

public interface ApiServiceInterface {

    @GET("photos")
    static Observable<List<Photo>> getPhotos();

}
