package com.example.greenacresnursery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<PlantsModel> plantsModel=new ArrayList<>();
    int[] id={1,2,3,4,5,6,7};
    int[] images={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.mRecyclerView);
        setUpPlantsModel();
        PM_RecyclerViewAdapter adapter=new PM_RecyclerViewAdapter(this,plantsModel,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpPlantsModel(){
        String[] plantNames = getResources().getStringArray(R.array.plant_name);
        String[] price=getResources().getStringArray(R.array.price);
        String[] description=getResources().getStringArray(R.array.description);
        String[] sunlight=getResources().getStringArray(R.array.Sunlight);
        String[] watering=getResources().getStringArray(R.array.Watering);


        for(int i=0;i<plantNames.length;i++){
            plantsModel.add(new PlantsModel(plantNames[i],
                    price[i],images[i],description[i],sunlight[i],watering[i],id[i]));
        }
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent =new Intent(MainActivity.this,Plantsdata.class);
        intent.putExtra("DESCRIPTION",plantsModel.get(position).getDescription());
        intent.putExtra("IMAGE",plantsModel.get(position).getImage());
        intent.putExtra("SUNLIGHT",plantsModel.get(position).getSunlight());
        intent.putExtra("WATERING",plantsModel.get(position).getWatering());
        intent.putExtra("PRICE",plantsModel.get(position).getPrice());
        intent.putExtra("NAME",plantsModel.get(position).getPlantName());
        intent.putExtra("ID",plantsModel.get(position).getId());

        startActivity(intent);
    }
}