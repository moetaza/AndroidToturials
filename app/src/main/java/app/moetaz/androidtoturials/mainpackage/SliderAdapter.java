package app.moetaz.androidtoturials.mainpackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.moetaz.androidtoturials.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public int [] slideimages = {
      R.drawable.pic1,R.drawable.pic2,R.drawable.pic3
    };

    public String [] slideHeadings = {
            "EAT","SLEEP","CODE"
    };

    public String [] slideDesc = {
            "mmfvmdlldlvndlnvlnvknlfnvlnlfnvlndflnvldnlnvldnlvnldnlvndlnvlndlnvlndlnvdnvlndlnvldnlvn"
            ,"mmfvmdlldlvndlnvlnvknlfnvlnlfnvlndflnvldnlnvldnlvnldnlvndlnvlndlnvlndlnvdnvlndlnvldnlvn",
            "mmfvmdlldlvndlnvlnvknlfnvlnlfnvlndflnvldnlnvldnlvnldnlvndlnvlndlnvlndlnvdnvlndlnvldnlvn"
    };

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
            return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.slideimage);
        TextView textViewheading = view.findViewById(R.id.slide_heading);
        TextView textViewdesc = view.findViewById(R.id.slide_desc);

        imageView.setImageResource(slideimages[position]);
        textViewheading.setText(slideHeadings[position]);
        textViewdesc.setText(slideDesc[position]);

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
