package com.test.retrofitexample.http;

import com.test.retrofitexample.model.Photo;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @Provides
    public OkHttpClient provideClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();

    }
    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Provides
    public ApiServiceInterface provideApiService() {
        return provideRetrofit(BASE_URL, provideClient()).create(ApiServiceInterface.class);
    }


}
