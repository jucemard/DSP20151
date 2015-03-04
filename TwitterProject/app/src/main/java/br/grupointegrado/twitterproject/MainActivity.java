package br.grupointegrado.twitterproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvContas = (ListView) findViewById(R.id.lvContas);

        List<String> contas = new ArrayList<String>();
        contas.add("bhpachulski");
        contas.add("Mundin");
        contas.add("...");

        ArrayAdapter<String> aaContas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contas);

        lvContas.setAdapter(aaContas);

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
