package app.moetaz.androidtoturials.mainpackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.moetaz.androidtoturials.R;
import app.moetaz.androidtoturials.retrofitToturial.MainActivityRetrofit;
import app.moetaz.androidtoturials.simpedagger2example.Main3Activity;

public class MainActivity extends AppCompatActivity {

    Button buRetrofit , buSimpleDagger2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buRetrofit = findViewById(R.id.bu_retrofit);
        buSimpleDagger2 = findViewById(R.id.buSimpleDagger2);

        buRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityRetrofit.class));
            }
        });

        buSimpleDagger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });
    }
}
