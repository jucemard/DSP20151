package br.grupointegrado.twitterproject;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView tvEmpty;
    private ListView lvContas;
    private AppDao appDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmpty = (TextView) findViewById(R.id.tvEmpty);
        lvContas = (ListView) findViewById(R.id.lvContas);
        lvContas.setEmptyView(tvEmpty);

        appDao = new AppDao(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final List<Conta> contas = appDao.listConta();

        ArrayAdapter<Conta> aaContas = new ArrayAdapter<>(this, R.layout.minha_querida_linha, contas);

        lvContas.setAdapter(aaContas);

        lvContas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), RogerioCeniActivity.class);
                i.putExtra("tipo", "longClick");
                i.putExtra("usuario", contas.get(position));

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

        switch (item.getItemId()) {

            case R.id.btnCadContas:
                startActivity(new Intent(this, CadContatoActivity.class));
            break;

        }

        return super.onOptionsItemSelected(item);
    }


}
