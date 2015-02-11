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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        final EditText edtNumero2 = (EditText) findViewById(R.id.edtNumero2);

        final TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        Button btnSomar = (Button) findViewById(R.id.btnSomar);

        btnSomar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int nr1 = Integer.parseInt(edtNumero1.getText().toString());
                int nr2 = Integer.parseInt(edtNumero2.getText().toString());

                Integer soma = (nr1 + nr2);
                tvResultado.setText(soma.toString());

            }

        });

    }

}
