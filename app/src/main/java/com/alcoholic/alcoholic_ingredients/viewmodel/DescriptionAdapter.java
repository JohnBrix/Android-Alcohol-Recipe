package com.alcoholic.alcoholic_ingredients.viewmodel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alcoholic.alcoholic_ingredients.R;
import com.alcoholic.alcoholic_ingredients.model.DescriptionModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.ViewHolder> {
    //    private Context context;
    private List<DescriptionModel.Drinks> descUtils;




    public DescriptionAdapter(Context context,  List descUtils) {
        //clone
        this.descUtils = descUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_content_description, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
         DescriptionModel.Drinks descriptionList = descUtils.get(position);
        //DITO SYA DIDISPLAY


        //get all description data from list
        holder.drinkName.setText(descriptionList.getStrDrink());
        holder.category.setText(descriptionList.getStrCategory());
        holder.alcoholic.setText(descriptionList.getStrAlcoholic());
        holder.instruction.setText(descriptionList.getStrInstructions());

//        List<String> get = new ArrayList<String>();
//        get.add(descriptionList.getStrIngredient1());
//        get.add(descriptionList.getStrIngredient2());
//        get.add(descriptionList.getStrIngredient3());
//        System.out.println("all data must be: "+get);
//        get.addAll(get);
        String[] ingred = {descriptionList.getStrIngredient1(), descriptionList.getStrIngredient2(), descriptionList.getStrIngredient3(), descriptionList.getStrIngredient4(),
                descriptionList.getStrIngredient5(), descriptionList.getStrIngredient6(), descriptionList.getStrIngredient7(),
                descriptionList.getStrIngredient8(), descriptionList.getStrIngredient9(), descriptionList.getStrIngredient10(), descriptionList.getStrIngredient11(),
                descriptionList.getStrIngredient12(), descriptionList.getStrIngredient13(), descriptionList.getStrIngredient14(),
                descriptionList.getStrIngredient15()};

        List<String>getAll = new ArrayList<>();
        getAll.addAll(Arrays.asList(ingred));


        String newGetAll = getAll.toString().replace("[","") //tinanggal yung [ replace as ""
                .replace("]","") // tinanggl yung: ] replace ""
                .replace("null","") //tinggal yung : null replace as ""
                .trim()
                .replace(", ,","");
//                .replace(",","");

        //REPLACE AY BINABAGO ANG SPECIFIC VALUE WITHOUT REPLACING OLD DATA
   //EXAMPLE: REPLACE MO SI l ng P = HEPPO
//        String myStr = "Hello";
//        System.out.println(myStr.replace('l', 'p'));


        System.out.println(getAll);
            holder.ingredients.setText(newGetAll);




        //MAG SETTER KA DITO PARA MAIPASA ANG DATA

        Picasso.get().load(descriptionList.getStrDrinkThumb()).into(holder.description_image_view);

    }


    @Override
    public int getItemCount() {
        return descUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        public TextView drinkName;
        public TextView category;
        public TextView alcoholic;
        public TextView instruction;
        public TextView ingredients;
        public ImageView description_image_view;

        public ViewHolder(View itemView) {
            super(itemView);
            drinkName = itemView.findViewById(R.id.drink_name_desc);
            category = (TextView) itemView.findViewById(R.id.category);
            alcoholic = (TextView) itemView.findViewById(R.id.alcoholic);
            instruction = (TextView) itemView.findViewById(R.id.instruction);
            ingredients = itemView.findViewById(R.id.ingredients_desc);
            description_image_view = (ImageView) itemView.findViewById(R.id.description_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}