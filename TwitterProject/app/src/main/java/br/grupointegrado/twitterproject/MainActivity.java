package br.grupointegrado.twitterproject;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvEmpty = (TextView) findViewById(R.id.tvEmpty);
        final ListView lvContas = (ListView) findViewById(R.id.lvContas);
        lvContas.setEmptyView(tvEmpty);

        AppDao appDao = new AppDao(this);
        final List<Conta> contas = appDao.listConta();

        ArrayAdapter<Conta> aaContas = new ArrayAdapter<>(this, R.layout.minha_querida_linha, contas);

        lvContas.setAdapter(aaContas);
        lvContas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;

                Intent i = new Intent(view.getContext(), RogerioCeniActivity.class);
                Conta contaSelecionado = contas.get(position);

                i.putExtra("tipo", "click");
                i.putExtra("usuario", contaSelecionado);

                startActivity(i);
            }
        });

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
