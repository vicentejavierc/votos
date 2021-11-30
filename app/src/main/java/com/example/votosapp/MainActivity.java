package com.example.votosapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import dao.DaoVoto;
import model.Voto;

public class MainActivity extends AppCompatActivity {

    public RadioGroup radioGroup;
    public RadioButton radioButton1, radioButton2, radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup)findViewById(R.id.grupoRadios);
        radioButton1=(RadioButton)findViewById(R.id.radioButton);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioButton3=(RadioButton)findViewById(R.id.radioButton3);

    }


    public void votar(View view){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Confirmación");
        builder.setMessage("Seguro de ejercer el voto?");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,  "Voto registrado", Toast.LENGTH_SHORT).show();
                        String selectedId="";

                        if(radioButton1.isChecked())
                            selectedId="nulo";
                        if(radioButton2.isChecked())
                            selectedId="gabriel";
                        if(radioButton3.isChecked())
                            selectedId="jose";

                        if(selectedId.equals("nulo")){
                            DaoVoto oD=new DaoVoto(getApplicationContext());
                            Voto oV=new Voto();
                            oV.setVoto_nulo(1);
                            oD.insert(oV);

                        }else
                        if(selectedId.equals("gabriel")){
                            DaoVoto oD=new DaoVoto(getApplicationContext());
                            Voto oV=new Voto();
                            oV.setVoto_boric(1);
                            oD.insert(oV);

                        }else
                        if(selectedId.equals("jose")){
                            DaoVoto oD=new DaoVoto(getApplicationContext());
                            Voto oV=new Voto();
                            oV.setVoto_kast(1);
                            oD.insert(oV);

                        }else{
                            DaoVoto oD=new DaoVoto(getApplicationContext());
                            Voto oV=new Voto();
                            oV.setVoto_blaco(1);
                            oD.insert(oV);
                        }


                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "Voto no registrado", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();





    }

    public void verResultados(View view){
       Intent votos = new Intent(this,VotosActivity.class);
       this.startActivity(votos);

    }
}