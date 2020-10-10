package com.alcoholic.alcoholic_ingredients.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.alcoholic.alcoholic_ingredients.service.DrinksApiService;
import com.alcoholic.alcoholic_ingredients.R;

import com.alcoholic.alcoholic_ingredients.model.DescriptionModel;
import com.alcoholic.alcoholic_ingredients.viewmodel.DescriptionAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrdinaryDrinkDescription extends AppCompatActivity {
    List<DescriptionModel.Drinks>descModel;

    RecyclerView descriptionRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordinary_drink_image_recycler_view);
        descriptionRecycleView = findViewById(R.id.recycle_view_for_desc);
        progressBar(); //onload
        descriptionRecycleView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setTitle("Description");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String setData = getIntent().getExtras().getString("getData");

        getDataDescription(setData); //passing data
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                System.out.println("backed");
                Intent intent = new Intent(OrdinaryDrinkDescription.this, OrdinaryDrinkController.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void progressBar(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Processing data..");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
        progressDialog.show();
    }
    public void getDataDescription(String setData){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DrinksApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        DrinksApiService drinksApiService = retrofit.create(DrinksApiService.class);

        //object calling
        Call<DescriptionModel> call = drinksApiService.getDescription(setData);


        call.enqueue(new Callback<DescriptionModel>() {
            @Override
            public void onResponse(Call<DescriptionModel> call, Response<DescriptionModel> response) {
                DescriptionModel descList = response.body();
                List<DescriptionModel.Drinks> desc = descList.getDrinks();
                descModel = new ArrayList<>();

                try{
                    for (int i = 0; i < desc.size(); i++) {

                        descModel.add(new DescriptionModel.Drinks(
                                desc.get(i).getIdDrink(),
                                desc.get(i).getStrDrink(),
                                desc.get(i).getStrAlcoholic(),
                                desc.get(i).getStrCategory(),
                                desc.get(i).getStrInstructions(),
                                desc.get(i).getStrDrinkThumb(),
                                desc.get(i).getStrIngredient1(),
                                desc.get(i).getStrIngredient2(),
                                desc.get(i).getStrIngredient3(),
                                desc.get(i).getStrIngredient4(),
                                desc.get(i).getStrIngredient5(),
                                desc.get(i).getStrIngredient6(),
                                desc.get(i).getStrIngredient7(),
                                desc.get(i).getStrIngredient8(),
                                desc.get(i).getStrIngredient9(),
                                desc.get(i).getStrIngredient10(),
                                desc.get(i).getStrIngredient11(),
                                desc.get(i).getStrIngredient12(),
                                desc.get(i).getStrIngredient13(),
                                desc.get(i).getStrIngredient14(),
                                desc.get(i).getStrIngredient15() ));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(OrdinaryDrinkDescription.this, "No data", Toast.LENGTH_SHORT).show();
                }
//                System.out.println("your search:"+ descModel.size());
//
                DescriptionAdapter mAdapter = new DescriptionAdapter(OrdinaryDrinkDescription.this, descModel);//constructor
                descriptionRecycleView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<DescriptionModel> call, Throwable t) { Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error");
            }

        });

    }

}