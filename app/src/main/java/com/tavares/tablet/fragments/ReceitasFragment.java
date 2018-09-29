package com.tavares.tablet.fragments;


import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tavares.tablet.R;
import com.tavares.tablet.activity.IngredientesActivity;
import com.tavares.tablet.activity.ReceitasActivity;
import com.tavares.tablet.adapter.ReceitasAdapter;
import com.tavares.tablet.adapter.StepsAdapter;
import com.tavares.tablet.constants.Constantes;
import com.tavares.tablet.helper.RecyclerItemClickListener;
import com.tavares.tablet.loader.ReceitasLoader;
import com.tavares.tablet.model.Ingredientes;
import com.tavares.tablet.model.Receitas;

import java.util.ArrayList;
import java.util.List;



public class ReceitasFragment extends Fragment
        implements  LoaderManager.LoaderCallbacks<List<Receitas>>  {

    private ArrayList<Receitas> listReceitas = new ArrayList<>();

    private ReceitasAdapter mAdapter;

    private RecyclerView recyclerView;
    private TextView mEmptyStateTextView;
    private View mLoadingIndicator;

    private boolean mTwoPane;



    public ReceitasFragment() {
        // Required empty public constructor
    }


    public void isTwoPane(boolean twoPane) {
        mTwoPane = twoPane;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receitas, container, false);

        mLoadingIndicator = view.findViewById(R.id.loading_indicator);
        mEmptyStateTextView = view.findViewById(R.id.empty_view);
        recyclerView = view.findViewById(R.id.recycler_view_receitas);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ReceitasAdapter( listReceitas,  getActivity(),getFragmentManager());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {

                final Receitas receitas = listReceitas.get(position);

                if(mTwoPane) {

                    IngredientesFragment ingredientesFragment = new IngredientesFragment();
                                    ingredientesFragment.setmReceitas(receitas);
                    getActivity().getFragmentManager().beginTransaction()
                            .replace(R.id.container_ingredientes, ingredientesFragment)
                            .commit();


                }else {

                    Intent intent = new Intent(getActivity(), IngredientesActivity.class);
                    intent.putExtra("RecipeObject", receitas);
                    startActivity(intent);

                }

            }
        }));

        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {

          getLoaderManager().initLoader(Constantes.NEWS_LOADER_ID, null,  this);


        } else {
            mLoadingIndicator.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            mEmptyStateTextView.setVisibility(View.VISIBLE);
            mEmptyStateTextView.setText("Sem conexão");
        }

        return view;

    }
    //android.support.v4.app.


    @NonNull
    @Override
    public Loader<List<Receitas>> onCreateLoader(int i, @Nullable Bundle bundle) {
        mLoadingIndicator.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        Uri baseUri = Uri.parse("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
        Uri.Builder uriBuilder = baseUri.buildUpon();

        return new ReceitasLoader(getActivity(), uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Receitas>> loader, List<Receitas> receitasList) {
        mLoadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setVisibility(View.VISIBLE);
        mEmptyStateTextView.setText("Sem resultados");

        mAdapter.clear();

        if (receitasList != null && !receitasList.isEmpty()) {
            recyclerView.setVisibility(View.VISIBLE);
            mEmptyStateTextView.setVisibility(View.GONE);
            mAdapter.addAll(receitasList);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Receitas>> loader) {
        mAdapter.clear();
    }







}
