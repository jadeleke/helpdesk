package co.obware.hashcode.api;


import retrofit2.Retrofit;

import static retrofit2.Retrofit.Builder;
import static retrofit2.converter.gson.GsonConverterFactory.create;

public class ApiClient {
    //    private static final String BASE_URL = "http://192.168.8.100/helpDesk/public/api/";
    private static final String BASE_URL = "http://192.168.8.100/helpDesk/public/api/";

    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        if (retrofit == null) {
            retrofit = new Builder()
                    .baseUrl( BASE_URL )
                    .addConverterFactory( create() )
                    .build();
        }
        return retrofit;
    }
}