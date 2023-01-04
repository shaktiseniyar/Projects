package com.example.greenacresnursery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PM_RecyclerViewAdapter extends RecyclerView.Adapter<PM_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<PlantsModel> plantsModel;

    public PM_RecyclerViewAdapter(Context context, ArrayList<PlantsModel> plantsModel,
                                  RecyclerViewInterface recyclerViewInterface){
this.context=context;
this.plantsModel=plantsModel;
this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public PM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where we inflate the layout.(Giving a look to our rows)
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.plants_data,parent,false);
        return new PM_RecyclerViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assigning values to the views we created in the plants_data layout file
        // based on the position of the recycler view
        holder.textView.setText(plantsModel.get(position).getPlantName());
        holder.textView2.setText(plantsModel.get(position).getPrice());
        holder.imageView.setImageResource(plantsModel.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return plantsModel.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
//        grabbing the views from our plants_data layout file

        TextView textView;
        TextView textView2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
             imageView=itemView.findViewById(R.id.imageView);
             textView=itemView.findViewById(R.id.textView);
             textView2=itemView.findViewById(R.id.textView2);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (recyclerViewInterface != null){
                         int pos=getAdapterPosition();
                         if(pos!=RecyclerView.NO_POSITION){
                             recyclerViewInterface.OnItemClick(pos);
                         }
                     }
                 }
             });
        }
    }
}
