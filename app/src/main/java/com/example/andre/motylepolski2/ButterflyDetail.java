package com.example.andre.motylepolski2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class ButterflyDetail extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfly_detail);

        TextView text = (TextView) findViewById(R.id.motylekTextView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        Intent in = this.getIntent();
        String name = in.getStringExtra("name");
        int image = getIntent().getExtras().getInt("image");

        text.setText(name);
        imageView.setImageResource(image);


    }



}
