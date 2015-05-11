package br.grupointegrado.projetoleadsandroidannotations;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NoTitle;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import br.grupointegrado.projetoleadsandroidannotations.model.Cidade;

@OptionsMenu(R.menu.menu_main)
@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @ViewById(R.id.edtNome)
    EditText edtNome;

    @ViewById(R.id.edtEmail)
    EditText edtEmail;

    @ViewById(R.id.edtTelefone)
    EditText edtTelefone;

    @Extra("cidade")
    Cidade cidadeIntent;

    @AfterViews
    public void init () {

        try {
            edtNome.setText(cidadeIntent.getNome());
        } catch (NullPointerException e) {
            Toast.makeText(this, "Não veio nada.", Toast.LENGTH_LONG).show();
        }

    }

    @OptionsItem(R.id.action_save)
    public void save () {

        Cidade c = new Cidade();
        c.setId(1);
        c.setNome("Campo Mourão");
        c.setEstado("Paraná");

        Intent i = new Intent(this, MainActivity_.class);
        i.putExtra("cidade", c);

        startActivity(i);
    }

    @OptionsItem(R.id.action_list)
    public void list () {

    }

//    https://github.com/excilys/androidannotations/wiki/Building-Project-Gradle
//    https://github.com/excilys/androidannotations/wiki/AvailableAnnotations

}
