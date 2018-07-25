package app.moetaz.androidtoturials.simpleBR;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import app.moetaz.androidtoturials.R;

public class Main5Activity extends AppCompatActivity {

    TextView textView;
    IntentFilter intentFilter;
    CharginhBR charginhBR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        textView = findViewById(R.id.textview_br);
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        charginhBR = new CharginhBR();

    }

    private void setText(boolean isCharging){

        if (isCharging){
            textView.setText("Phone is charging");
        }else {
            textView.setText("Phone is not charging");
        }

    }

    private class CharginhBR extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean isCharge = action.equals(Intent.ACTION_POWER_CONNECTED);
            setText(isCharge);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(charginhBR,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(charginhBR);
    }
}
