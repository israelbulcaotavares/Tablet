package com.tavares.tablet.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tavares.tablet.R;
import com.tavares.tablet.activity.StepsActivity;
import com.tavares.tablet.model.Steps;

import java.util.List;


public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.NewsViewHolder> {
    private  List<Steps> listaSteps;
    private Context mContext;


    public StepsAdapter(List<Steps> listaSteps, Context mContext) {
        this.listaSteps = listaSteps;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View newsView = LayoutInflater.from(context).inflate(R.layout.adapter_steps, parent, false);
        return new NewsViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final Steps steps = listaSteps.get(position);


        holder.detalhes.setText("Step " +steps.getStepID()+ ": " +steps.getmShortDescription());
        holder.detalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, StepsActivity.class);
                intent.putExtra("RecipeObject", steps);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaSteps.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

           final TextView detalhes;

        public NewsViewHolder(View v) {
            super(v);
              detalhes = v.findViewById(R.id.short_description);

         }
    }


}