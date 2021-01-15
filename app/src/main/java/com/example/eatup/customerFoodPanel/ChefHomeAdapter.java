package com.example.eatup.customerFoodPanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatup.R;
import com.example.eatup.UpdateDishModel;

import java.util.List;

public class ChefHomeAdapter extends RecyclerView.Adapter<ChefHomeAdapter.ViewHolder> {

    private Context mcout;
    private List<UpdateDishModel> updateDishModelList;

    public ChefHomeAdapter(Context context , List<UpdateDishModel>updateDishModelList){
        this.updateDishModelList = updateDishModelList;
        this.mcout = context;
    }


    @NonNull
    @Override
    public ChefHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcout).inflate(R.layout.chefmenu_update_delete,parent,false);
        return new ChefHomeAdapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ChefHomeAdapter.ViewHolder holder, int position) {

        final UpdateDishModel updateDishModel = updateDishModelList.get(position);
        holder.dishes.setText(updateDishModel.getDishes());
        updateDishModel.getRandomUID();



    }

    @Override
    public int getItemCount() {
        return updateDishModelList.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dishes;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        dishes = itemView.findViewById(R.id.dish_name);

    }
}
}
