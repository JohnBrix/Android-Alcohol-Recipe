package com.alcoholic.alcoholic_ingredients.viewmodel;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alcoholic.alcoholic_ingredients.R;
import com.alcoholic.alcoholic_ingredients.controller.CocktailController;
import com.alcoholic.alcoholic_ingredients.controller.CocktailDescription;
import com.alcoholic.alcoholic_ingredients.model.DrinkModel;
import com.squareup.picasso.Picasso;
import java.util.List;


public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.ViewHolder> {
    private List<DrinkModel.Drinks> cocktailUtils;
    public CocktailAdapter(CocktailController context, List cocktailUtils) {
//        this.context = (Context) context;
        this.cocktailUtils = cocktailUtils;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktail_image, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

//        CategoryModel.Category categories = categoriesList.get(position);
        final DrinkModel.Drinks cocktailList = cocktailUtils.get(position);
        //DITO SYA DIDISPLAY


        holder.name_text.setText(cocktailList.getStrDrink());
//        holder.description.setText(cocktailList.getTitle());
        Picasso.get().load(cocktailList.getStrDrinkThumb()).into(holder.image_view);
        //dito ka ggwa ng description
        holder.image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String setData = cocktailList.getStrDrink();
                //GUMAWA KA NG BAGONG DESCRIPTION CONTROLLER
                Intent myIntent = new Intent(v.getContext(), CocktailDescription.class);
                myIntent.putExtra("getData", setData); //pass data should be name same as variable
                v.getContext().startActivity(myIntent);


            }
        });


    }


    @Override
    public int getItemCount() {
        return cocktailUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //VARIABLE PARA MABASA
        public TextView name_text;

        public ImageView image_view;

        public ViewHolder(View itemView) {
            super(itemView);

            name_text = (TextView) itemView.findViewById(R.id.cocktail_drinks_name);

            image_view = (ImageView) itemView.findViewById(R.id.cocktail_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }

}