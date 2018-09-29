package com.tavares.tablet.adapter;

import android.content.Context;
import android.content.Intent;

import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tavares.tablet.R;
import com.tavares.tablet.activity.IngredientesActivity;
import com.tavares.tablet.fragments.IngredientesFragment;
import com.tavares.tablet.model.Ingredientes;
import com.tavares.tablet.model.Receitas;

import java.util.List;


public  class ReceitasAdapter extends RecyclerView.Adapter<ReceitasAdapter.ViewHolder> {
    private Context mContext;
    int Position ;
    private    List<Receitas> listReceitas;

    private android.app.FragmentManager mFragmentManager;




    public ReceitasAdapter(  List<Receitas> receitas, Context context,android.app.FragmentManager fragmentManager ) {

        this.listReceitas = receitas;
        this.mContext = context;
        this.mFragmentManager = fragmentManager;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View newsView = LayoutInflater.from(context).inflate(R.layout.adapter_receita, parent, false);
        return new ReceitasAdapter.ViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Receitas receitas = listReceitas.get(position);



        holder.name.setText(receitas.getmName());
//        holder.name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(mTwoPane) {
//                    IngredientesFragment ingredientesFragment = new IngredientesFragment();
//                                         ingredientesFragment.setIngredientesIndex( mIngredientes );
//                    FragmentTransaction ft = mFragmentManager.beginTransaction();
//                     ft.replace(R.id.container_ingredientes, ingredientesFragment, IngredientesFragment.TAG_DETALHE);
//                     ft.commit();
//
//
//
//                }else {
//
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, IngredientesActivity.class);
//                    intent.putExtra("RecipeObject", receitas);
//                    context.startActivity(intent);
//
//                }
//
//
//
//            }
//        });


        holder.servings.setText(receitas.getmServings());
    }



    @Override
    public int getItemCount() {
        return listReceitas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView servings;
        final ImageView favorite;

        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.noticias_tipo);
            servings = v.findViewById(R.id.noticias_data);
            favorite = v.findViewById(R.id.image_favorites);
        }



    }

    public void clear(){
        listReceitas.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Receitas> receitasList){
        listReceitas.addAll(receitasList);
        notifyDataSetChanged();
    }
}