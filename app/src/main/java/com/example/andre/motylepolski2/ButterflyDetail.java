package com.example.andre.motylepolski2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ButterflyDetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfly_detail);

        TextView text = (TextView) findViewById(R.id.motylekTextView);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        Intent in = this.getIntent();
        
        String name = in.getStringExtra("name");
        final int imageIconIntent = in.getExtras().getInt("image");
        final int imageFullIntent = in.getExtras().getInt("full");
        final int imageGasienicaIntent = in.getExtras().getInt("gasienica");
        final int imageKokonIntent = in.getExtras().getInt("poczwarka");




        text.setText(name);


        class ImageAdapter extends PagerAdapter {
            Context context;
            private int[] GalImages = new int[]{
                    imageFullIntent,
                    imageGasienicaIntent,
                    imageKokonIntent,


            } ;

            ImageAdapter(Context context) {
                this.context = context;
            }

            @Override
            public int getCount () {
                return GalImages.length;
            }

            @Override
            public boolean isViewFromObject (View view, Object object){
                return view == ((ImageView) object);
            }

            @Override
            public Object instantiateItem (ViewGroup container, int position){
                ImageView imageView = new ImageView(context);
                int padding = context.getResources().getDimensionPixelSize(R.dimen.gallery_margin);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(GalImages[position]);
                ((ViewPager) container).addView(imageView, 0);
                return imageView;
            }

            @Override
            public void destroyItem (ViewGroup container,int position, Object object){
                ((ViewPager) container).removeView((ImageView) object);
            }


        }

        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

    }





}



