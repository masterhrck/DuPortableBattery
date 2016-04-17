package com.example.martin.duportablebatteries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface IDuPortableService {
    @GET("/my-site")
    Call<List<Battery>> getBatteries(@Query("giveAll") boolean giveAll, @Query("id") int id, @Query("percent") int percent, @Query("state") int state);
}
