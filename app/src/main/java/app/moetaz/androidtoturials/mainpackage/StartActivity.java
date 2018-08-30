package app.moetaz.androidtoturials.mainpackage;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.moetaz.androidtoturials.R;

public class StartActivity extends AppCompatActivity {

    ViewPager mViewPager;
    LinearLayout mLinearLayout;
    SliderAdapter sliderAdapter;
    private TextView [] dots;
    Button next ,back;
    int currentpage;
    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        addDotsIndicators(position);
        currentpage = position;
        if(position == 0){
            next.setEnabled(true);
            back.setEnabled(false);
            back.setVisibility(View.INVISIBLE);
            next.setText("NEXT");
            back.setText("");
        }else if(position == dots.length-1){
            next.setEnabled(true);
            back.setEnabled(true);
            back.setVisibility(View.VISIBLE);
            next.setText("FINISH");
            back.setText("BACK");
        }else {
            next.setEnabled(true);
            back.setEnabled(true);
            back.setVisibility(View.VISIBLE);
            next.setText("NEXT");
            back.setText("BACK");
        }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mViewPager = findViewById(R.id.slideVeiwPager);
        mLinearLayout = findViewById(R.id.dotslinearlayout);
        next = findViewById(R.id.nextbtn);
        back = findViewById(R.id.previosbtn);

        sliderAdapter = new SliderAdapter(this);
        mViewPager.setAdapter(sliderAdapter);
        addDotsIndicators(0);
        mViewPager.addOnPageChangeListener(pageChangeListener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentpage == dots.length -1) {
                    finish();
                    startActivity(new Intent(StartActivity.this,MainActivity.class));
                }else {
                    mViewPager.setCurrentItem(currentpage+1);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(currentpage-1);
            }
        });
    }

    public void addDotsIndicators (int postion){
        dots = new TextView[3];
        mLinearLayout.removeAllViews();

        for(int i = 0;i<dots.length;i++){
            dots[i]  = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparantWhite));
            mLinearLayout.addView(dots[i]);
        }

        if(dots.length >0){
            dots[postion].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }
}
