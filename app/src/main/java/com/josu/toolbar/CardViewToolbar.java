package com.josu.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class CardViewToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_toolbar);

        Toolbar tbCard = (Toolbar) findViewById(R.id.TbCard);
        tbCard.setTitle("Mi tarjeta");

        tbCard.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.action_1:
                                Log.i("Toolbar 2", "Acción Tarjeta 1");
                                break;
                            case R.id.action_2:
                                Log.i("Toolbar 2", "Acción Tarjeta 2");
                                break;
                        }
                        return true;
                    }
                });
        tbCard.inflateMenu(R.menu.menu_tarjeta);
    }
}
