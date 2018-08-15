package app.moetaz.androidtoturials.retrofitToturial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GithubClient {


    @GET("/users/{user}/repos")
     Call<List<GithubRepo>> repoFromUser(@Path("user") String user);
}
