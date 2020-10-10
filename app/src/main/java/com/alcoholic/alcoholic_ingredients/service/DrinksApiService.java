package com.alcoholic.alcoholic_ingredients.service;

import com.alcoholic.alcoholic_ingredients.model.DescriptionModel;
import com.alcoholic.alcoholic_ingredients.model.DrinkModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DrinksApiService {
    String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";

    @GET("filter.php?c=Ordinary_Drink")
    Call<DrinkModel> getOrdinaryDrinks();

    @GET("search.php?")
    Call<DrinkModel> searchOrdinaryDrink(@Query("s")String newText);

    @GET("search.php?")
    Call<DescriptionModel> getDescription(@Query("s")String drinkName);

    // for cocktails
    @GET("filter.php?c=Cocktail")
    Call<DrinkModel> getCocktail();
    @GET("search.php?")
    Call<DrinkModel> searchCocktail(@Query("s")String setData);

    //FOR non alcoholic
    @GET("filter.php?a=Non_Alcoholic")
    Call<DrinkModel> getNonAlcoholic();
    @GET("search.php?")
    Call<DrinkModel> searchAlcoholic(@Query("s")String i);





}
