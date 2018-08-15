package app.moetaz.androidtoturials.retrofitToturial;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.moetaz.androidtoturials.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityRetrofit extends AppCompatActivity {

    private List<GithubRepo> list;
    private GithubClient githubClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__retrofit);

        githubClient = ApiClient.getRetrofit().create(GithubClient.class);


        //get names of user's repos
        Call<List<GithubRepo>> call = githubClient.repoFromUser("amoetaz");

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(@NonNull Call<List<GithubRepo>> call, @NonNull Response<List<GithubRepo>> response) {

                list = response.body();

                for(GithubRepo repo : list){
                    Toast.makeText(getApplicationContext(),repo.getName(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

            }
        });
    }

}
