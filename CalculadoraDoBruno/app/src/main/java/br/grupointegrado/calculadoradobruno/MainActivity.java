package br.grupointegrado.calculadoradobruno;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText edtNumero1;
    private EditText edtNumero2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1  = (EditText) findViewById(R.id.edtNumero1);
        edtNumero1.setInputType(InputType.TYPE_NULL);

        edtNumero2  = (EditText) findViewById(R.id.edtNumero2);
        edtNumero2.setInputType(InputType.TYPE_NULL);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
    }

    public TextView getTextViewNumero () {
        try {
            return (TextView) this.getCurrentFocus();
        } catch (Exception e) {
            return null; //corrigir
        }
    }

    public void clickBtn7 (View v) {
        getTextViewNumero().setText(getTextViewNumero().getText().toString() + "7");
    }

    public void clickBtn8 (View v) {
        getTextViewNumero().setText(getTextViewNumero().getText().toString() + "8");
    }

    public double getValor (EditText tv) {
        try {
            return Double.parseDouble(tv.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entada inválida.", Toast.LENGTH_LONG).show();

            return 0;
        }
    }

    public void clickBtnMenos (View v) {
        this.mostraResultado(getValor(edtNumero1) - getValor(edtNumero2));
    }

    public void clickBtnMais (View v) {
        double nr1 = getValor(edtNumero1);
        double nr2 = getValor(edtNumero2);

        double soma = (nr1 + nr2);

        this.mostraResultado(soma);
    }

    public void mostraResultado (Double resultado) {
        Toast.makeText(this, "Resultado: " + resultado.toString(), Toast.LENGTH_LONG).show();
        tvResultado.setText("Resultado: " + resultado.toString());

    }

    public void clickBtnClear (View v) {
        edtNumero1.setText("");
        edtNumero2.setText("");
    }

}
