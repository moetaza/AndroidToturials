package app.moetaz.androidtoturials.mainpackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.moetaz.androidtoturials.R;
import app.moetaz.androidtoturials.broadcastrecieverexample.Main4Activity;
import app.moetaz.androidtoturials.cropingandrotateimage.Main6Activity;
import app.moetaz.androidtoturials.dagger2retrofitokhttpgson.Main2Activity;
import app.moetaz.androidtoturials.recordaudio.Main7Activity;
import app.moetaz.androidtoturials.retrofitToturial.MainActivityRetrofit;
import app.moetaz.androidtoturials.simpedagger2example.Main3Activity;
import app.moetaz.androidtoturials.simpleBR.Main5Activity;

public class MainActivity extends AppCompatActivity {

    Button buRetrofit , buSimpleDagger2
            ,buSimpleDagger2withretrofit,buBroadCastRecievr,buBroadCastRecievr2,buImagerotation
            ,recordButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buRetrofit = findViewById(R.id.bu_retrofit);
        buSimpleDagger2 = findViewById(R.id.buSimpleDagger2);
        buSimpleDagger2withretrofit = findViewById(R.id.buSimpleDagger2withretrofit);
        buBroadCastRecievr = findViewById(R.id.buBroadCastRecievr);
        buBroadCastRecievr2 = findViewById(R.id.buBroadCastRecievr2);
        buImagerotation = findViewById(R.id.buImagerotation);
        recordButton = findViewById(R.id.recordButton);

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

        buSimpleDagger2withretrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        buBroadCastRecievr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main4Activity.class));
            }
        });

        buBroadCastRecievr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main5Activity.class));
            }
        });


        buImagerotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main6Activity.class));
            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main7Activity.class));
            }
        });
    }
}
