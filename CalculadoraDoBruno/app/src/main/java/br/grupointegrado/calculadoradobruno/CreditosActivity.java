package br.grupointegrado.calculadoradobruno;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class CreditosActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        TextView tvResultadoNovaActivity = (TextView) findViewById(R.id.tvResultadoNovaActivity);

        Intent i = getIntent();
        String resultado = i.getExtras().getString("resultado");

        tvResultadoNovaActivity.setText(resultado);
    }

}
