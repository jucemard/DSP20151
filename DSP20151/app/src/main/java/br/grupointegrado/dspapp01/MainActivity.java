package br.grupointegrado.dspapp01;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHelloWorld = (TextView) findViewById(R.id.tvHelloWorld);
        tvHelloWorld.setText("Olá mundo !! =D ... ");

        tvHelloWorld.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.e("MSG", "Teste de Botão !! ");

            }

        });

    }

}
