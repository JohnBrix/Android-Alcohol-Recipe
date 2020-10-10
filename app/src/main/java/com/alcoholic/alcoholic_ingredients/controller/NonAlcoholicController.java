package com.alcoholic.alcoholic_ingredients.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.alcoholic.alcoholic_ingredients.R;
import com.alcoholic.alcoholic_ingredients.model.DrinkModel;
import com.alcoholic.alcoholic_ingredients.service.DrinksApiService;
import com.alcoholic.alcoholic_ingredients.viewmodel.NonAlcoholicAdapter;
import com.alcoholic.alcoholic_ingredients.viewmodel.SearchNonAlcoholicDescriptionAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NonAlcoholicController extends AppCompatActivity {

    ImageView imageView;
    RecyclerView dashboardRecycleView;
    RecyclerView searchRecyclerAdapter; // for search
    RecyclerView.LayoutManager dashBoardLayout;
    RecyclerView.LayoutManager searchLayout;
    List<DrinkModel.Drinks> alcoholicModels;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alcoholic_recycler_view_data_only);
        imageView = findViewById(R.id.cocktail_image_view);
        searchView = findViewById(R.id.alcoholic_search_view);
        getSupportActionBar().setTitle("Non Alcoholic");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dashboardRecycleView = (RecyclerView) findViewById(R.id.alcoholic_dashboard_view);//display
        searchRecyclerAdapter = (RecyclerView) findViewById(R.id.search_view_display); //search
        getDrinks();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {



                searchDrinks(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (newText.isEmpty()){
                    getDrinks();
                }
                return false;
            }
        });


    }
    public void progressBar(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Processing data..");
        progressDialog.setMessage("Please wait loading data...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
        progressDialog.show();
    }
    public void searchDrinks(String i) {
        progressBar();

        //layout
        searchLayout = new GridLayoutManager(NonAlcoholicController.this,2 , GridLayoutManager.VERTICAL, false);
        dashboardRecycleView.setLayoutManager(searchLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DrinksApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        DrinksApiService drinksApiService = retrofit.create(DrinksApiService.class);

        //object calling
        Call<DrinkModel> call = drinksApiService.searchAlcoholic(i);


        call.enqueue(new Callback<DrinkModel>() {
            @Override
            public void onResponse(Call<DrinkModel> call, Response<DrinkModel> response) {
                DrinkModel cocktailLists = response.body();
                List<DrinkModel.Drinks> alcoholicList = cocktailLists.getDrinks();
                alcoholicModels = new ArrayList<>();

                try{
                    for (int i = 0; i < alcoholicList.size(); i++) {
                        alcoholicModels.add(new DrinkModel.Drinks(
                                alcoholicList.get(i).getStrDrink(),
                                alcoholicList.get(i).getStrDrinkThumb(), alcoholicList.get(i).getIdDrink()));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    getDrinks();
                    Toast.makeText(NonAlcoholicController.this, "No Search Results", Toast.LENGTH_SHORT).show();
                }
                System.out.println("your search:"+ alcoholicModels.size());
                //REMAKE AS ONE IN ADAPTER
                SearchNonAlcoholicDescriptionAdapter mAdapter = new SearchNonAlcoholicDescriptionAdapter(NonAlcoholicController.this, alcoholicModels);
                dashboardRecycleView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<DrinkModel> call, Throwable t) { Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error");
            }

        });

    }
    public void getDrinks() {
        progressBar();
        //layout
        dashBoardLayout = new GridLayoutManager(NonAlcoholicController.this,2 , GridLayoutManager.VERTICAL, false);
        dashboardRecycleView.setLayoutManager(dashBoardLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DrinksApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        DrinksApiService drinksApiService = retrofit.create(DrinksApiService.class);

        //object calling
        Call<DrinkModel> call = drinksApiService.getNonAlcoholic();


        call.enqueue(new Callback<DrinkModel>() {
            @Override
            public void onResponse(Call<DrinkModel> call, Response<DrinkModel> response) {
                DrinkModel cocktailLists = response.body();

                List<DrinkModel.Drinks> cocktailList = cocktailLists.getDrinks();

                alcoholicModels = new ArrayList<>();
                for (int i = 0; i < cocktailList.size(); i++) {

                    alcoholicModels.add(new DrinkModel.Drinks(
                            cocktailList.get(i).getStrDrink(),
                            cocktailList.get(i).getStrDrinkThumb(), cocktailList.get(i).getIdDrink()));
                }
                //new adaptor
                System.out.println(alcoholicModels);
                NonAlcoholicAdapter mAdapter = new NonAlcoholicAdapter(NonAlcoholicController.this, alcoholicModels);

                dashboardRecycleView.setAdapter(mAdapter);

            }


            @Override
            public void onFailure(Call<DrinkModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}