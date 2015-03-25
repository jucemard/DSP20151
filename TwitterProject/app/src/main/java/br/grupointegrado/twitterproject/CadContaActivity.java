package br.grupointegrado.twitterproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class CadContaActivity extends ActionBarActivity {

    private AppDao appDao;
    private EditText edtNome;
    private EditText edtConta;
    private Conta contaAlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_contato);

        appDao = new AppDao(this);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtConta = (EditText) findViewById(R.id.edtConta);

        try {
            contaAlt = (Conta) getIntent().getSerializableExtra("contaAlt");
            setValues(contaAlt);

            Toast.makeText(this, "Modo de Alteração", Toast.LENGTH_LONG).show();
        } catch (Exception e ) {
            Toast.makeText(this, "Modo de Cadastro", Toast.LENGTH_LONG).show();
        }

    }

    public void setValues (Conta c) {
        edtNome.setText(c.getNome());
        edtConta.setText(c.getConta());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cad_conta, menu);
        return true;
    }

    public Conta getConta () {
        return new Conta(edtConta.getText().toString(), edtNome.getText().toString());
    }

    public Conta getConta (Conta c) {
        c.setNome(edtNome.getText().toString());
        c.setConta(edtConta.getText().toString());

        return c;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnSalvar:

                if (contaAlt == null)
                    appDao.saveConta(getConta());
                else
                    appDao.updateConta(getConta(contaAlt));

            break;

            case R.id.btnListar:
                startActivity(new Intent(this, MainActivity.class));
            break;

        }

        return super.onOptionsItemSelected(item);
    }
}
