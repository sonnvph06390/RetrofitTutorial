package com.example.son.retrofittutorial;

import com.example.son.retrofittutorial.data.remote.RetrofitClient;

public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(SOService.class);
    }
}
