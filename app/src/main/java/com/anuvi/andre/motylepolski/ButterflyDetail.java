package com.anuvi.andre.motylepolski;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


public class ButterflyDetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfly_detail);


        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        WebView webView =(WebView) findViewById(R.id.webview) ;
        webView.getSettings();



        webView.setBackgroundColor(Color.TRANSPARENT);
        TextView textView =(TextView)findViewById(R.id.nameTextView);


        Intent in = this.getIntent();

        String name = in.getStringExtra("name");
        final int imageImago1 = in.getExtras().getInt("imageImago1");
        final int imageImago2 = in.getExtras().getInt("imageImago2");
        final int imageImago3 = in.getExtras().getInt("imageImago3");
        final int imageCaterpillar = in.getExtras().getInt("imageCaterpillar");
        final int imageCocoon = in.getExtras().getInt("imageCocoon");
        final int imageEgg = in.getExtras().getInt("imageEgg");
        final int imageArea = in.getExtras().getInt("imageArea");
        String detailInfo = in.getStringExtra("detailInfo");

        webView.loadDataWithBaseURL(null,detailInfo,"text/html","UTF-8", null);

        textView.setText(name);


        class ImageAdapter extends PagerAdapter {
            Context context;
            private int[] GalImages = new int[]{
                    imageImago1,
                    imageImago2,
                    imageImago3,
                    imageCaterpillar,
                    imageCocoon,
                    imageEgg,
                    imageArea

            };

            ImageAdapter(Context context) {
                this.context = context;
            }

            @Override
            public int getCount() {
                return GalImages.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == ((ImageView) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(context);
                int padding = context.getResources().getDimensionPixelSize(R.dimen.gallery_margin);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(GalImages[position]);
                ((ViewPager) container).addView(imageView, 0);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager) container).removeView((ImageView) object);
            }


        }

        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

    }


}



