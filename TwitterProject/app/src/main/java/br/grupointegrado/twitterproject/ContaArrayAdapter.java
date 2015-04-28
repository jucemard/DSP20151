package br.grupointegrado.twitterproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bhpachulski on 4/27/2015.
 */
public class ContaArrayAdapter extends ArrayAdapter<Conta> {

    public ContaArrayAdapter(Context context, List<Conta> contas) {
        super(context, android.R.layout.simple_list_item_1, contas);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = li.inflate(R.layout.arrayadapter_conta, null);

        TextView tvConta = (TextView) v.findViewById(R.id.tvConta);
        TextView tvNome = (TextView) v.findViewById(R.id.tvNome);

        tvConta.setText(getItem(position).getConta());
        tvNome.setText(getItem(position).getNome());

        if (getItem(position).getNome().charAt(0) == 'd')
            tvConta.setTextColor(Color.RED);

        return v;
    }

}
