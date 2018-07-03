package app.moetaz.androidtoturials.retrofitToturial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("baking.json")
     Call<List<Movie>> getMovies();
}
