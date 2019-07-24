package com.example.son.retrofittutorial;

import com.example.son.retrofittutorial.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {
    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<Example>getAnswers();
    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<Example> getAnswers(@Query("tagged") String tags);
}
