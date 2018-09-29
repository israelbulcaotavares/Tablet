package com.tavares.tablet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tavares.tablet.R;
import com.tavares.tablet.fragments.ReceitasFragment;

public class ReceitasActivity extends AppCompatActivity {

   boolean  mTwoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);


        if (findViewById(R.id.container_ingredientes) != null) {
            mTwoPane = true;
        } else {
            mTwoPane = false;
        }

        ReceitasFragment receitasFragment = new ReceitasFragment();
        receitasFragment.isTwoPane(mTwoPane);
        getFragmentManager().beginTransaction()
                .replace(R.id.container_receitas, receitasFragment)
                .commit();




    }
}
