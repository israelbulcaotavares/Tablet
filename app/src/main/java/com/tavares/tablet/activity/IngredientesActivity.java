package com.tavares.tablet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tavares.tablet.R;
import com.tavares.tablet.fragments.IngredientesFragment;
import com.tavares.tablet.fragments.ReceitasFragment;

public class IngredientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredientes);

        getFragmentManager().beginTransaction()
                .replace(R.id.container_ingredientes, new IngredientesFragment())
                .commit();
    }
}
