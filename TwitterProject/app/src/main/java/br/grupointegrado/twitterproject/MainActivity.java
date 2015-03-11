package br.grupointegrado.twitterproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lvContas = (ListView) findViewById(R.id.lvContas);

        final List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile("bhpachulski", "Bruno Henrique Pachulski"));
        profiles.add(new Profile("teste", "Teste"));

        ArrayAdapter<Profile> aaContas = new ArrayAdapter<>(this, R.layout.minha_querida_linha, profiles);

        lvContas.setAdapter(aaContas);
        lvContas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;

                Intent i = new Intent(view.getContext(), RogerioCeniActivity.class);
                Profile profileSelecionado = profiles.get(position);

                i.putExtra("tipo", "click");
                i.putExtra("usuario", profileSelecionado);

                startActivity(i);
            }
        });

        lvContas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), RogerioCeniActivity.class);
                i.putExtra("tipo", "longClick");
                i.putExtra("usuario", profiles.get(position));

                startActivity(i);
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
