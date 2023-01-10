package com.example.greenacresnursery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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
    int TOTALPR;
    TextView quantitynumber;
    Button addtocart,button;
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
        int id=getIntent().getIntExtra("ID",0);


        TextView tvdesc=findViewById(R.id.tvdesc);
        ImageView imageView2=findViewById(R.id.imageView2);
        TextView tvsun=findViewById(R.id.tvsun);
        TextView tvwater=findViewById(R.id.tvwater);
        TextView tvprice=findViewById(R.id.textView11);
        ImageButton plusquantity=findViewById(R.id.addquantity);
        ImageButton minusquantity=findViewById(R.id.subquantity);
        quantitynumber=findViewById(R.id.quantity);
        addtocart=findViewById(R.id.addtocart);
        button=findViewById(R.id.button);
        TextView totalprice=findViewById(R.id.totalprice);
        String price1=price.replace("₹","");

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int baseprice=Integer.parseInt(price1);
                quantity++;
                displayQuantity();
                int tot_price=baseprice*quantity;
                TOTALPR=tot_price;
                totalprice.setText("₹"+String.valueOf(TOTALPR));
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
                    TOTALPR=tot_price;
                    totalprice.setText("₹"+String.valueOf(TOTALPR));
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
                AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"cart_database").allowMainThreadQueries().build();
                ProductDao productDao =db.ProductDao();
                Boolean check=productDao.is_exist(id);
                if(check==false){
                    int pid=id;
                    String pname=name;
                    int price=Integer.parseInt(price1);
                    int qnt=quantity;
                    productDao.insertrecord(new Product(pid,pname,price,qnt));
                    Toast.makeText(Plantsdata.this,"Item added to cart",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Plantsdata.this,"Product already exists in the cart",Toast.LENGTH_SHORT).show();
                }

//                Intent intent=new Intent(Plantsdata.this,CartActivity.class);
//                intent.putExtra("Image",image);
//                intent.putExtra("Name",name);
//                intent.putExtra("Quantity",String.valueOf(quantity));
//                intent.putExtra("Price",String.valueOf(TOTALPR));
//                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Plantsdata.this,CartActivity.class);
                startActivity(intent);
            }
        });
    }
    public void displayQuantity(){
        quantitynumber.setText(String.valueOf(quantity));
    }
}