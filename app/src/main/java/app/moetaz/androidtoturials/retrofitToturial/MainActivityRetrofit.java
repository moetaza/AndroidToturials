package app.moetaz.androidtoturials.retrofitToturial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.moetaz.androidtoturials.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityRetrofit extends AppCompatActivity {

    private List<Movie> movieList;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__retrofit);

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

//lvdnvnfjvn
        Call<List<Movie>> call = apiInterface.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {

                movieList = response.body();

                for(Movie movie : movieList){
                    Toast.makeText(getApplicationContext(),movie.getName(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }

}
