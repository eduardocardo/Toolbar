package com.josu.toolbar;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.josu.tabs.MiFragmentPagerAdapter;

public class CustomToolbar extends AppCompatActivity {

    private Button bt_launchCardViewToolbar, bt_launchAnimation1, bt_launchAnimation2,
            bt_launchAnimation3, bt_launchAnimation4;
    private TextView tv_info;
    private Spinner sp_filters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toolbar);

        tv_info = (TextView) findViewById(R.id.tv_info);
        sp_filters = (Spinner) findViewById(R.id.sp_filters);
        bt_launchCardViewToolbar = (Button) findViewById(R.id.bt_launch_card_view_toolbar);
        bt_launchAnimation1 = (Button) findViewById(R.id.bt_launch_animation_1);
        bt_launchAnimation2 = (Button) findViewById(R.id.bt_launch_animation_2);
        bt_launchAnimation3 = (Button) findViewById(R.id.bt_launch_animation_3);
        bt_launchAnimation4 = (Button) findViewById(R.id.bt_launch_animation_4);

        /* Asociamos la toolbar al appbar de la clase CustomToolbar. Al decirle que nuestra toolbar
           va a hacer las veces de la appbar no necesitamos indicarle el título, ya que lo cogerá
           automaticamente de la app, lo mismo para el menú */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Deshabilitamos el título para dejar sitio al spinner, aunque pueden estar los dos sin problemas
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Se encarga del efecto de desplazamiento entre las tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MiFragmentPagerAdapter(
                getSupportFragmentManager()));

        /* Layout de pestañas en modo scroll al que asociamos el viewPager, y que hara que aparezcan
           correctamente el contenido de cada pestaña y titulo correspondiente */
        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        // Muestra en tv_info que item del spinner de filtros de la appbar se ha seleccionado
        sp_filters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_info.setText(getResources().getStringArray(R.array.filters)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nada que hacer
            }
        });

        // Lanza la activity CardViewToolbar
        bt_launchCardViewToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CardViewToolbar.class));
            }
        });

        // ---------------------------------- ANIMACIONES ------------------------------------------

        // Lanza la activity Animation1 (Toolbar que aparece/desaparece en base al scrool del recycler)
        bt_launchAnimation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Animation1.class));
            }
        });

        // Lanza la activity Animation2 (Toolbar que aparece/desaparece y aumenta de tamaño en base al scrool del RecyclerView)
        bt_launchAnimation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Animation2.class));
            }
        });

        // Lanza la activity Animation3 (Imagen de fondo asociada a la toolbar que se expande y retrae a la vez que la toolbar)
        bt_launchAnimation3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Animation3.class));
            }
        });

        // Lanza la activity Animation4 (fab incrustado en la Toolbar con la animación de la misma)
        bt_launchAnimation4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Animation4.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menu; añade elementos al appbar si esta presente.
        getMenuInflater().inflate(R.menu.menu_custom_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean toReturn;
        // Acciones en base a la id del elemento en el que se ha hecho click
        switch (item.getItemId()) {
            case R.id.add:
                // Botón añadir
                tv_info.setText("Se presionó Añadir");
                toReturn = true;
                break;
            case R.id.search:
                // Botón buscar
                tv_info.setText("Se presionó Buscar");
                toReturn = true;
                break;
            case R.id.edit:
                // Botón editar
                tv_info.setText("Se presionó Editar");
                toReturn = true;
                break;
            case R.id.delete:
                // Botón eliminar
                tv_info.setText("Se presionó Eliminar");
                toReturn = true;
                break;
            case R.id.action_settings:
                // Botón Settings
                tv_info.setText("Se presionó Ajustes");
                toReturn = true;
                break;
            default:
                toReturn = super.onOptionsItemSelected(item);
                break;
        }
        return toReturn;
    }

}
