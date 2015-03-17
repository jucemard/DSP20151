package br.grupointegrado.twitterproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class CadContatoActivity extends ActionBarActivity {

    private EditText edtNome;
    private EditText edtConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_contato);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtConta = (EditText) findViewById(R.id.edtConta);

    }

    public Conta getConta () {
        return new Conta(edtConta.getText().toString(), edtNome.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cad_contato, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnSalvar:
                getConta();
            break;

            case R.id.btnListar:

            break;
        }

        return super.onOptionsItemSelected(item);
    }
}
