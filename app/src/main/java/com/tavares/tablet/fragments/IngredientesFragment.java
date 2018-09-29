package com.tavares.tablet.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tavares.tablet.R;
import com.tavares.tablet.adapter.IngredientesAdapter;
import com.tavares.tablet.adapter.ReceitasAdapter;
import com.tavares.tablet.adapter.StepsAdapter;
import com.tavares.tablet.model.Ingredientes;
import com.tavares.tablet.model.Receitas;
import com.tavares.tablet.model.Steps;

import java.util.ArrayList;


public class IngredientesFragment extends Fragment{

    RecyclerView recyclerViewIngredientes;
    RecyclerView recyclerViewSteps;

    TextView mNameReceita;
    int mRecipeId;
    Receitas mReceitas;
    Receitas receitas;

    Ingredientes mIngredientes;



    public IngredientesFragment() {
        // Required empty public constructor
    }



    public void setmReceitas(Receitas mReceitas) {
        receitas = mReceitas;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingredientes, container, false);

        //todo: RECEBE ITENS DE UMA FRAGMENT , POSSIBILITANDO A TWO PANE , Obrigado DEUS!
        if(receitas == null) {
            receitas = (Receitas) getActivity().getIntent().getSerializableExtra("RecipeObject");
        }


        if (receitas != null){

            recyclerViewSteps =   view.findViewById(R.id.recycler_view_steps);
            mNameReceita =        view.findViewById(R.id.text_nome_receita);
            recyclerViewIngredientes = view.findViewById(R.id.recycler_view_ingredients);


            //todo: INGREDIENTES
            recyclerViewIngredientes.setLayoutManager(new LinearLayoutManager(getActivity()));
            ArrayList<Ingredientes> ingredientarrayList = receitas.getIngredientesArrayList();
            IngredientesAdapter ingredientAdapter = new IngredientesAdapter(ingredientarrayList, getActivity());
            recyclerViewIngredientes.setAdapter(ingredientAdapter);

            //todo: STEPS
            recyclerViewSteps.setLayoutManager(new LinearLayoutManager(getActivity()));
            ArrayList<Steps> stepsArrayList = receitas.getStepsArrayList();
            StepsAdapter stepsAdapter = new StepsAdapter(stepsArrayList, getActivity());
            recyclerViewSteps.setAdapter(stepsAdapter);

            //Nome da receita
            mNameReceita.setText(receitas.getmName());
            mRecipeId = receitas.getmId();

        }

        return view;

    }




}
