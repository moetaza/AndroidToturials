package app.moetaz.androidtoturials.mainpackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.moetaz.androidtoturials.R;
import app.moetaz.androidtoturials.retrofitToturial.MainActivityRetrofit;

public class MainActivity extends AppCompatActivity {

    Button buRetrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buRetrofit = findViewById(R.id.bu_retrofit);

        buRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityRetrofit.class));
            }
        });
    }
}
