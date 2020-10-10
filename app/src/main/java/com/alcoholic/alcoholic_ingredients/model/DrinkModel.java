package com.alcoholic.alcoholic_ingredients.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrinkModel {

    @SerializedName("drinks")
    private List<DrinkModel.Drinks> drinks = null;

    public static class Drinks{

        @SerializedName("strDrink")
        private String strDrink;
        @SerializedName("strDrinkThumb")
        private String strDrinkThumb;
        @SerializedName("idDrink")
        private String idDrink;

        public Drinks(String strDrink, String strDrinkThumb, String idDrink) {
            super();
            this.strDrink = strDrink;
            this.strDrinkThumb = strDrinkThumb;
            this.idDrink = idDrink;
        }

        public String getStrDrink() {
            return strDrink;
        }

        public void setStrDrink(String strDrink) {
            this.strDrink = strDrink;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        public void setStrDrinkThumb(String strDrinkThumb) {
            this.strDrinkThumb = strDrinkThumb;
        }

        public String getIdDrink() {
            return idDrink;
        }

        public void setIdDrink(String idDrink) {
            this.idDrink = idDrink;
        }

    }
    public List<DrinkModel.Drinks> getDrinks() {
        return drinks;
    }
    public void setDrinks(List<DrinkModel.Drinks> drinks) {
        this.drinks = drinks;

    }
}
