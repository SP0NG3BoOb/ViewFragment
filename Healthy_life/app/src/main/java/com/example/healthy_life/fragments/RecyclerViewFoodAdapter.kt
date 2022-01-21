package com.example.healthy_life.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthy_life.Food
import com.example.healthy_life.R

class RecyclerViewFoodAdapter(private val list: List<Food>):
    RecyclerView.Adapter<RecyclerViewFoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var foodName: TextView
        var cal : TextView


        init {
            foodName = itemView.findViewById(R.id.foodName)
            cal = itemView.findViewById(R.id.cal)


        }

        fun setData(food: Food){
            Glide.with(itemView)

            cal.text = "${food.cal} kcal"
            foodName.text = food.foodName


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView =
        LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val p = list[position]
        holder.setData(p)

    }

    override fun getItemCount() = list.size


}