package br.grupointegrado.dspapp01;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private EditText edtNumero1;
    private EditText edtNumero2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
    }

    public void somar(View v) {
        int nr1 = Integer.parseInt(edtNumero1.getText().toString());
        int nr2 = Integer.parseInt(edtNumero2.getText().toString());

        Integer soma = (nr1 + nr2);
        tvResultado.setText(soma.toString());
    }
}
