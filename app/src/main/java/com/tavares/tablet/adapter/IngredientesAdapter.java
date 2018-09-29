package com.tavares.tablet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.tavares.tablet.R;
import com.tavares.tablet.model.Ingredientes;

import java.util.List;

public class IngredientesAdapter extends RecyclerView.Adapter<IngredientesAdapter.NewsViewHolder> {
    private  List<Ingredientes> listaIngredients;
    private Context mContext;

    public IngredientesAdapter(List<Ingredientes> listaIngredients, Context mContext) {
        this.listaIngredients = listaIngredients;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View newsView = LayoutInflater.from(context).inflate(R.layout.adapter_ingredientes, parent, false);
        return new NewsViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final Ingredientes ingredientes = listaIngredients.get(position);

        holder.ingredient.setText(
                                    ingredientes.getQuantity() +
                                            "   "
                                    + ingredientes.getMeasure() +
                                            " of "
                                   +ingredientes.getIngredient() );

    }

    @Override
    public int getItemCount() {
        return listaIngredients.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

          final TextView ingredient;

        public NewsViewHolder(View v) {
            super(v);
             ingredient = v.findViewById(R.id.text_ingredientes);

         }
    }

    public void clear(){
        listaIngredients.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Ingredientes> ingredientsList){
        listaIngredients.addAll(ingredientsList);
        notifyDataSetChanged();
    }

}