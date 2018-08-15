package app.moetaz.androidtoturials.retrofitToturial;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BaseUrl = "https://api.github.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit =new Retrofit.Builder().baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
