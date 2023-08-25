package com.jhonatan.hunnids.data.retrofit;

import com.jhonatan.hunnids.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MoviesInterface {

    @GET("b28c64a6-adac-442e-8908-9b5a1edd2ffb")
    Call<ShowResponse> getShows();
}
