package app.moetaz.androidtoturials.dagger2retrofitokhttpgson;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import app.moetaz.androidtoturials.R;
import app.moetaz.androidtoturials.mainpackage.AppControl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Main2Activity extends AppCompatActivity {


    @Inject
    Retrofit retrofit;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textview);

        ((AppControl)(getApplication())).getNetComponent().inject(this);

        //Create a retrofit call object
        Call<List<Post>> posts = retrofit.create(Restapi.class).getPosts();

        //Enque the call
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                //Set the response to the textview
                textView.setText(response.body().get(0).getBody());

            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                //Set the error to the textview
                textView.setText(t.toString());
            }
        });
    }
}
