package br.grupointegrado.twitterproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


public class RogerioCeniActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rogerio_ceni);

        Conta conta = (Conta) getIntent().getSerializableExtra("usuario");

        Intent i = getIntent();
        TextView tvMostraString = (TextView) findViewById(R.id.tvMostraString);
        tvMostraString.setText(i.getStringExtra("tipo") + ": " + conta.getNome());

    }

}
