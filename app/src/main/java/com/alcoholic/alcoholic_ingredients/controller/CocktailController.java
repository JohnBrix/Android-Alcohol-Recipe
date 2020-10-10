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
import com.alcoholic.alcoholic_ingredients.viewmodel.CocktailAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.Thread.sleep;

public class CocktailController extends AppCompatActivity {
    ImageView imageView;
    RecyclerView dashboardRecycleView;
    RecyclerView searchRecyclerAdapter; // for search
    RecyclerView.LayoutManager dashBoardLayout;
    RecyclerView.LayoutManager searchLayout;
    List<DrinkModel.Drinks> cocktailModels;

    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocktail_recycler_view_data_only);

        imageView = findViewById(R.id.cocktail_image_view);
        searchView = findViewById(R.id.search_view);


        getSupportActionBar().setTitle("Cocktail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dashboardRecycleView = (RecyclerView) findViewById(R.id.dashboard_view);//display
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
//                Toast.makeText(CocktailController.this, "No Search Results"+newText, Toast.LENGTH_SHORT).show();

//                searchDrinks(newText);

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
        searchLayout = new GridLayoutManager(CocktailController.this,2 , GridLayoutManager.VERTICAL, false);
        dashboardRecycleView.setLayoutManager(searchLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DrinksApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        DrinksApiService drinksApiService = retrofit.create(DrinksApiService.class);

        //object calling
        Call<DrinkModel> call = drinksApiService.searchCocktail(i);


        call.enqueue(new Callback<DrinkModel>() {
            @Override
            public void onResponse(Call<DrinkModel> call, Response<DrinkModel> response) {
                DrinkModel cocktailLists = response.body();
                List<DrinkModel.Drinks> cocktailList = cocktailLists.getDrinks();
                cocktailModels = new ArrayList<>();

                try{
                    for (int i = 0; i < cocktailList.size(); i++) {
                        cocktailModels.add(new DrinkModel.Drinks(
                                cocktailList.get(i).getStrDrink(),
                                cocktailList.get(i).getStrDrinkThumb(), cocktailList.get(i).getIdDrink()));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    getDrinks();
                    Toast.makeText(CocktailController.this, "No Search Results", Toast.LENGTH_SHORT).show();
                }
                System.out.println("your search:"+ cocktailModels.size());
                //para sa image view
                CocktailAdapter mAdapter = new CocktailAdapter(CocktailController.this, cocktailModels);
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
        dashBoardLayout = new GridLayoutManager(CocktailController.this,2 , GridLayoutManager.VERTICAL, false);
        dashboardRecycleView.setLayoutManager(dashBoardLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DrinksApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        DrinksApiService drinksApiService = retrofit.create(DrinksApiService.class);

        //object calling
        Call<DrinkModel> call = drinksApiService.getCocktail();


        call.enqueue(new Callback<DrinkModel>() {
            @Override
            public void onResponse(Call<DrinkModel> call, Response<DrinkModel> response) {
                DrinkModel cocktailLists = response.body();

                List<DrinkModel.Drinks> cocktailList = cocktailLists.getDrinks();

                cocktailModels = new ArrayList<>();
                for (int i = 0; i < cocktailList.size(); i++) {

                    cocktailModels.add(new DrinkModel.Drinks(
                            cocktailList.get(i).getStrDrink(),
                            cocktailList.get(i).getStrDrinkThumb(), cocktailList.get(i).getIdDrink()));
                }
                //new adaptor
                System.out.println(cocktailModels);

                CocktailAdapter mAdapter = new CocktailAdapter(CocktailController.this, cocktailModels);

                dashboardRecycleView.setAdapter(mAdapter);

            }


            @Override
            public void onFailure(Call<DrinkModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}