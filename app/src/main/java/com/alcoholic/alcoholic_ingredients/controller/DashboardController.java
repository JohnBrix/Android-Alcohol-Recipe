package com.alcoholic.alcoholic_ingredients.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.alcoholic.alcoholic_ingredients.R;

public class DashboardController extends AppCompatActivity {
    //create intent that can call activity per modules

    ImageView ordinaryDrink;
    ImageView cocktail;
    ImageView nonAlcoholic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ordinaryDrink = findViewById( R.id.open_ordinarydrink);
        nonAlcoholic = findViewById( R.id.open_nonalcoholic);
        cocktail = findViewById( R.id.open_cocktail);

        changingActivity();



    }


    public void changingActivity(){
        ordinaryDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardController.this, OrdinaryDrinkController.class);
                startActivity(intent);
            }
        });
        nonAlcoholic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardController.this, NonAlcoholicController.class);
                startActivity(intent);
            }
        });

        cocktail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardController.this, CocktailController.class);
                startActivity(intent);
            }
        });



    }
}