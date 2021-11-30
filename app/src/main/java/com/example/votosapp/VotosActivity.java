package com.example.votosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import dao.DaoVoto;
import model.Voto;

public class VotosActivity extends AppCompatActivity {

    TextView blanco,nulo,boric,kast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votos);
        blanco=(TextView)findViewById(R.id.blancos);
        nulo=(TextView)findViewById(R.id.nulos);
        boric=(TextView)findViewById(R.id.gabriel);
        kast=(TextView)findViewById(R.id.antonio);

        DaoVoto oD=new DaoVoto(getApplicationContext());
        //EXTRAEMOS LOS VOTOS DE LA BASE DE DATOS
        List<Voto> votos=oD.getVotos();
        for(Voto v : votos){
            blanco.setText("BLANCOS: "+v.getVoto_blaco());
            nulo.setText("NULOS: "+v.getVoto_nulo());
            boric.setText("BORIC: "+v.getVoto_boric());
            kast.setText("KAST: "+v.getVoto_kast());
        }

    }

    public void volver(View view){
        Intent main = new Intent(this,MainActivity.class);
        this.startActivity(main);
    }

}