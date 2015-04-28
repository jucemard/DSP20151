package br.grupointegrado.twitterproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView tvEmpty;
    private ListView lvContas;
    private Spinner spnContas;
    private ContaDao contaDao;
    private List<Conta> contas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmpty = (TextView) findViewById(R.id.tvEmpty);
        lvContas = (ListView) findViewById(R.id.lvContas);
        lvContas.setEmptyView(tvEmpty);

        spnContas = (Spinner) findViewById(R.id.spnContas);
        spnContas.setEmptyView(tvEmpty);

        contaDao = new ContaDao(this);
        Log.e("MSG", contaDao.list().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();

        contas = contaDao.list();

        ContaArrayAdapter aaContas = new ContaArrayAdapter(this, contas);

        spnContas.setAdapter(aaContas);
        lvContas.setAdapter (aaContas);

        lvContas.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                getMenuInflater().inflate(R.menu.menu_alt_conta, menu);
                menu.setHeaderTitle("Alterar Contato");

                //Mostrar ICON
                //menu.setHeaderIcon()
            }
        });

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo pListMenu = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Conta c = contas.get(pListMenu.position);

        switch (item.getItemId()) {

            case R.id.btnAlterar:
                Intent i = new Intent(this, CadContaActivity.class);
                i.putExtra("contaAlt", c);

                startActivity(i);
            break;

            case R.id.btnDeletar:
                contaDao.delete(c);
                onResume();
            break;

        }

        return super.onContextItemSelected(item);
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
                startActivity(new Intent(this, CadContaActivity.class));
            break;

        }

        return super.onOptionsItemSelected(item);
    }


}
