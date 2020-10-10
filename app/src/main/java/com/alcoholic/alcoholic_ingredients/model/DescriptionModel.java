package com.alcoholic.alcoholic_ingredients.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DescriptionModel {

    @SerializedName("drinks")
    private List<DescriptionModel.Drinks> drinks = null;

    public static class Drinks{
        @SerializedName("idDrink")
        private String idDrink;
        @SerializedName("strDrink")
        private String strDrink;
        @SerializedName("strCategory")
        private String strCategory;
        @SerializedName("strAlcoholic")
        private String strAlcoholic;
        @SerializedName("strGlass")
        private String strGlass;
        @SerializedName("strInstructions")
        private String strInstructions;
        @SerializedName("strDrinkThumb")
        private String strDrinkThumb;

        //NEW ADDED MODEL
        @SerializedName("strIngredient1")
        private String strIngredient1;
        @SerializedName("strIngredient2")
        private String strIngredient2;
        @SerializedName("strIngredient3")
        private String strIngredient3;
        @SerializedName("strIngredient4")
        private String strIngredient4;
        @SerializedName("strIngredient5")
        private String strIngredient5;
        @SerializedName("strIngredient6")
        private String strIngredient6;
        @SerializedName("strIngredient7")
        private String strIngredient7;
        @SerializedName("strIngredient8")
        private String strIngredient8;
        @SerializedName("strIngredient9")
        private String strIngredient9;
        @SerializedName("strIngredient10")
        private String strIngredient10;
        @SerializedName("strIngredient11")
        private String strIngredient11;
        @SerializedName("strIngredient12")
        private String strIngredient12;
        @SerializedName("strIngredient13")
        private String strIngredient13;
        @SerializedName("strIngredient14")
        private String strIngredient14;


        @SerializedName("strIngredient15")
        private String strIngredient15;

        public Drinks(String idDrink, String strDrink, String strCategory, String strAlcoholic, String strInstructions, String strDrinkThumb,
                      String strIngredient1,String strIngredient2,String strIngredient3,
                      String strIngredient4, String strIngredient5, String strIngredient6,
                      String strIngredient7, String strIngredient8, String strIngredient9,
                      String strIngredient10, String strIngredient11, String strIngredient12,
                      String strIngredient13, String strIngredient14, String strIngredient15) {
            this.idDrink = idDrink;
            this.strDrink = strDrink;
            this.strCategory = strCategory;
            this.strAlcoholic = strAlcoholic;
            this.strInstructions = strInstructions;
            this.strDrinkThumb = strDrinkThumb;
            this.strIngredient1 =strIngredient1;
            this.strIngredient2 = strIngredient2;
            this.strIngredient3 = strIngredient3;
            this.strIngredient4 = strIngredient4;
            this.strIngredient5 = strIngredient5;
            this.strIngredient6 = strIngredient6;
            this.strIngredient7 = strIngredient7;
            this.strIngredient8 = strIngredient8;
            this.strIngredient9 = strIngredient9;
            this.strIngredient10 = strIngredient10;
            this.strIngredient11 = strIngredient11;
            this.strIngredient12 = strIngredient12;
            this.strIngredient13 = strIngredient13;
            this.strIngredient14 = strIngredient14;
            this.strIngredient15 = strIngredient15;

        }

        public String getStrIngredient4() {
            return strIngredient4;
        }

        public void setStrIngredient4(String strIngredient4) {
            this.strIngredient4 = strIngredient4;
        }

        public String getStrIngredient5() {
            return strIngredient5;
        }

        public void setStrIngredient5(String strIngredient5) {
            this.strIngredient5 = strIngredient5;
        }

        public String getStrIngredient6() {
            return strIngredient6;
        }

        public void setStrIngredient6(String strIngredient6) {
            this.strIngredient6 = strIngredient6;
        }

        public String getStrIngredient7() {
            return strIngredient7;
        }

        public void setStrIngredient7(String strIngredient7) {
            this.strIngredient7 = strIngredient7;
        }

        public String getStrIngredient8() {
            return strIngredient8;
        }

        public void setStrIngredient8(String strIngredient8) {
            this.strIngredient8 = strIngredient8;
        }

        public String getStrIngredient9() {
            return strIngredient9;
        }

        public void setStrIngredient9(String strIngredient9) {
            this.strIngredient9 = strIngredient9;
        }

        public String getStrIngredient10() {
            return strIngredient10;
        }

        public void setStrIngredient10(String strIngredient10) {
            this.strIngredient10 = strIngredient10;
        }

        public String getStrIngredient11() {
            return strIngredient11;
        }

        public void setStrIngredient11(String strIngredient11) {
            this.strIngredient11 = strIngredient11;
        }

        public String getStrIngredient12() {
            return strIngredient12;
        }

        public void setStrIngredient12(String strIngredient12) {
            this.strIngredient12 = strIngredient12;
        }

        public String getStrIngredient13() {
            return strIngredient13;
        }

        public void setStrIngredient13(String strIngredient13) {
            this.strIngredient13 = strIngredient13;
        }

        public String getStrIngredient14() {
            return strIngredient14;
        }

        public void setStrIngredient14(String strIngredient14) {
            this.strIngredient14 = strIngredient14;
        }

        public String getStrIngredient15() {
            return strIngredient15;
        }

        public void setStrIngredient15(String strIngredient15) {
            this.strIngredient15 = strIngredient15;
        }

        public String getStrIngredient1() {
            return strIngredient1;
        }

        public void setStrIngredient1(String strIngredient1) {
            this.strIngredient1 = strIngredient1;
        }

        public String getStrIngredient2() {
            return strIngredient2;
        }

        public void setStrIngredient2(String strIngredient2) {
            this.strIngredient2 = strIngredient2;
        }

        public String getStrIngredient3() {
            return strIngredient3;
        }

        public void setStrIngredient3(String strIngredient3) {
            this.strIngredient3 = strIngredient3;
        }



        public String getIdDrink() {
            return idDrink;
        }

        public void setIdDrink(String idDrink) {
            this.idDrink = idDrink;
        }

        public String getStrDrink() {
            return strDrink;
        }

        public void setStrDrink(String strDrink) {
            this.strDrink = strDrink;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        public String getStrAlcoholic() {
            return strAlcoholic;
        }

        public void setStrAlcoholic(String strAlcoholic) {
            this.strAlcoholic = strAlcoholic;
        }

        public String getStrGlass() {
            return strGlass;
        }

        public void setStrGlass(String strGlass) {
            this.strGlass = strGlass;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public void setStrInstructions(String strInstructions) {
            this.strInstructions = strInstructions;
        }
        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }
        public void setStrDrinkThumb(String strDrinkThumb) {
            this.strDrinkThumb = strDrinkThumb;
        }
    }
    //List
    public List<DescriptionModel.Drinks> getDrinks() {
        return drinks;
    }
    public void setDrinks(List<DescriptionModel.Drinks> drinks) {
        this.drinks = drinks;

    }

}
