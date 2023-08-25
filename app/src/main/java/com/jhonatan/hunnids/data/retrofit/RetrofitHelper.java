package com.jhonatan.hunnids.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static Retrofit instance;

    public static MoviesInterface service;


    public RetrofitHelper(){

    }

    public static Retrofit getInstance(){

        if (instance == null){
            Retrofit  retrofit = new Retrofit.Builder()
          //  https://run.mocky.io/v3/ca8d72a8-4e9e-4756-a468-c776769a58ce
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getLogginBuilder().build())
                    .build();
            instance = retrofit;

        }  return instance;
    }

    public static OkHttpClient.Builder getLogginBuilder(){
        HttpLoggingInterceptor interceptor  = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder;

    }

    public static MoviesInterface getService(){

        if(service == null){
            service = getInstance().create(MoviesInterface.class);
        }
        return service;
    }

}
