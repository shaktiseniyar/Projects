package com.example.greenacresnursery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Plantsdata extends AppCompatActivity {

    int quantity;
    String TOTALPR;
    TextView quantitynumber;
    Button addtocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantsdata);

        int image=getIntent().getIntExtra("IMAGE",0);
        String description=getIntent().getStringExtra("DESCRIPTION");
        String sunlight=getIntent().getStringExtra("SUNLIGHT");
        String watering=getIntent().getStringExtra("WATERING");
        String price=getIntent().getStringExtra("PRICE");
        String name=getIntent().getStringExtra("NAME");

        TextView tvdesc=findViewById(R.id.tvdesc);
        ImageView imageView2=findViewById(R.id.imageView2);
        TextView tvsun=findViewById(R.id.tvsun);
        TextView tvwater=findViewById(R.id.tvwater);
        TextView tvprice=findViewById(R.id.textView11);
        ImageButton plusquantity=findViewById(R.id.addquantity);
        ImageButton minusquantity=findViewById(R.id.subquantity);
        quantitynumber=findViewById(R.id.quantity);
        addtocart=findViewById(R.id.addtocart);
        TextView totalprice=findViewById(R.id.totalprice);
        String price1=price.replace("₹","");

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int baseprice=Integer.parseInt(price1);
                quantity++;
                displayQuantity();
                int tot_price=baseprice*quantity;
                TOTALPR="₹"+String.valueOf(tot_price);
                totalprice.setText(TOTALPR);
            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity==0){
                    Toast.makeText(Plantsdata.this, "", Toast.LENGTH_SHORT).show();
                }
                else {
                    int baseprice = Integer.parseInt(price1);;
                    quantity--;
                    displayQuantity();
                    int tot_price = baseprice * quantity;
                    TOTALPR="₹"+String.valueOf(tot_price);
                    totalprice.setText(TOTALPR);
                }
            }
        });

        tvdesc.setText(description);
        imageView2.setImageResource(image);
        tvsun.setText(sunlight);
        tvwater.setText(watering);
        tvprice.setText(price);

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Plantsdata.this,CartActivity.class);
                intent.putExtra("Image",image);
                intent.putExtra("Name",name);
                intent.putExtra("Quantity",String.valueOf(quantity));
                intent.putExtra("Price",String.valueOf(TOTALPR));
                startActivity(intent);
            }
        });
    }
    public void displayQuantity(){
        quantitynumber.setText(String.valueOf(quantity));
    }
}