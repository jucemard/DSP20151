package br.grupointegrado.projetoleadsandroidannotations;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.grupointegrado.projetoleadsandroidannotations.model.Cidade;

@EActivity(R.layout.activity_list_test)
public class ListTestActivity extends ActionBarActivity {

    List<Cidade> cidades;

    @ViewById(R.id.lvTeste)
    ListView lvTest;

    @AfterViews
    public void init () {
        cidades = new ArrayList<>();
        Cidade c = new Cidade();
        c.setId(1);
        c.setNome("Campo Mourão");
        c.setEstado("Paraná");
        cidades.add(c);

        Cidade c1 = new Cidade();
        c1.setId(2);
        c1.setNome("Maringá");
        c1.setEstado("Paraná");
        cidades.add(c1);

        setAdapter();
    }

    public void setAdapter () {

        lvTest.setAdapter(new ArrayAdapter<Cidade>(this, android.R.layout.simple_list_item_1, cidades));

        lvTest.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                getMenuInflater().inflate(R.menu.menu_list_test, menu);
                menu.setHeaderTitle("Alterar Contato");
            }
        });

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo pListMenu = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Cidade c = cidades.get(pListMenu.position);

        switch (item.getItemId()) {
            case R.id.action_update:

                //alterar c

                break;

            case R.id.action_delete:

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Deseja realmente remover " + c.getNome() + " ?");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                cidades.remove(c);
                                setAdapter();
                            }
                        });

                    builder1.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                break;
        }

        return super.onContextItemSelected(item);
    }
}
