package com.example.healthy_life.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthy_life.Food
import com.example.healthy_life.R

class FoodFragment: Fragment(R.layout.fragment_food) {
    private lateinit var recyclerViewFoodAdapter: RecyclerViewFoodAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewFoodAdapter = RecyclerViewFoodAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerViewFoodAdapter





    }

    }

    private fun getData(): List<Food>{

        val foodList = ArrayList<Food>()

        foodList.add(
            Food(
                "1 Boiled Egg",
                155
            )

        )
        foodList.add(
            Food(
                "1 Slice of Bread",
                85
            )

        )
        foodList.add(
            Food(
                "100g Chicken Salad",
                48
            )

        )
        foodList.add(
            Food(
                "30g Yogurt",
                58
            )

        )
        foodList.add(
            Food(
                "1 Slice of French Toast",
                70
            )

        )
        foodList.add(
            Food(
                "100g Fries",
                311
            )

        )
        foodList.add(
            Food(
                "100g Hamburger",
                194
            )

        )
        foodList.add(
            Food(
                "100g Caeser",
                44
            )

        )
        foodList.add(
            Food(
                "1 sandwich",
                250
            )

        )
        foodList.add(
            Food(
                "30g bacon",
                180
            )

        )
        foodList.add(
            Food(
                "100g Cake",
                256
            )

        )
        foodList.add(
            Food(
                "1 Slice of mozzarella pizza",
                110
            )

        )
        foodList.add(
            Food(
                "30g Dark Chocolate",
                90
            )

        )
        foodList.add(
            Food(
                "100g Noodles",
                138
            )

        )
        foodList.add(
            Food(
                "100g Lasagna",
                135
            )

        )

        foodList.add(
            Food(
                "150g Mexican Fries",
                365
            )

        )
        foodList.add(
            Food(
                "100g Meatloaf",
                149
            )

        )
        foodList.add(
            Food(
                "100g Bolognese pasta",
                267
            )

        )
        foodList.add(
            Food(
                "100g Spaghetti",
                157
            )

        )
        foodList.add(
            Food(
                "100g Chicken Tenders",
                299
            )

        )
        foodList.add(
            Food(
                "30g Buffalo wings",
                75
            )

        )
        foodList.add(
            Food(
                "100g Chicken Nuggets",
                295
            )

        )
        foodList.add(
            Food(
                "100g Taco",
                226
            )

        )
        foodList.add(
            Food(
                "100g Apple Pie",
                237
            )

        )
        foodList.add(
            Food(
                "100g sausage",
                300
            )

        )
        foodList.add(
            Food(
                "100g Mac and Cheese",
                164
            )

        )
        foodList.add(
            Food(
                "1 Corn Dog",
                262
            )

        )
        foodList.add(
            Food(
                "100g Ravioli",
                77
            )

        )
        foodList.add(
            Food(
                "100g Meatballs",
                196
            )

        )
        foodList.add(
            Food(
                "1 Donut",
                452
            )

        )
        foodList.add(
            Food(
                "1 Avocado Roll",
                28
            )

        )
        foodList.add(
            Food(
                "1 California Roll",
                38
            )

        )
        foodList.add(
            Food(
                "1 Kappa Maki Roll",
                30
            )

        )
        foodList.add(
            Food(
                "100g Waffles",
                290
            )

        )

        return foodList
    }

