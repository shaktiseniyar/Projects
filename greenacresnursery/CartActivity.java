package com.example.greenacresnursery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    ImageView imageView3;
    TextView textView15,textView16,textView17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        int Image=getIntent().getIntExtra("Image",0);
        String Name=getIntent().getStringExtra("Name");
        String Quantity=getIntent().getStringExtra("Quantity");
        String Price=getIntent().getStringExtra("Price");

        imageView3=findViewById(R.id.imageView3);
        textView15=findViewById(R.id.textView15);
        textView16=findViewById(R.id.textView16);
        textView17=findViewById(R.id.textView17);

        imageView3.setImageResource(Image);
        textView15.setText(Name);
        textView16.setText(Quantity);
        textView17.setText(Price);

    }
}