package com.josu.toolbar;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.josu.list.AdaptadorTitulares;
import com.josu.list.DividerItemDecoration;
import com.josu.list.Titular;

import java.util.ArrayList;

public class Animation4 extends AppCompatActivity {

    private RecyclerView lstLista;
    private FloatingActionButton btnFab;
    private CollapsingToolbarLayout ctlLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation4);

        //Floating Action Button
        btnFab = (FloatingActionButton)findViewById(R.id.btnFab);
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "El FloatingActionButton se desplaza junto con la toolbar", Snackbar.LENGTH_LONG).show();
            }
        });

        //App bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Animacion 3");

        //CollapsingToolbarLayout
        ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.ctlLayout);
        ctlLayout.setTitle("Animacion 4");

        //RecyclerView
        RecyclerView lstLista = (RecyclerView) findViewById(R.id.lstLista);

        ArrayList<Titular> datos = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));

        AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
        lstLista.setAdapter(adaptador);

        lstLista.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lstLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        lstLista.setItemAnimator(new DefaultItemAnimator());
    }
}