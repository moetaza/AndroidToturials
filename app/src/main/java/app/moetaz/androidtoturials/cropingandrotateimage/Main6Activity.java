package app.moetaz.androidtoturials.cropingandrotateimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import app.moetaz.androidtoturials.R;

public class Main6Activity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        imageView = findViewById(R.id.imagetotest);
        button = findViewById(R.id.butest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bMap = BitmapFactory.decodeResource(getResources(),R.drawable.background);
                Matrix mat = new Matrix();
                mat.postRotate(90);
                Bitmap bMapRotate = Bitmap.createBitmap(bMap, 0, 0,
                        bMap.getWidth(), bMap.getHeight(), mat, true);
                BitmapDrawable bmd = new BitmapDrawable(getApplicationContext().getResources(), bMapRotate);
                imageView.setImageBitmap(bMapRotate);
                imageView.setImageDrawable(bmd);
            }
        });
    }
}
