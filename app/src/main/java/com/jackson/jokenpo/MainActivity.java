package com.jackson.jokenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView escolhaMaqView;
    ImageView escolhaUsuView;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escolhaMaqView = (ImageView) findViewById(R.id.escolhaMaqView);
        escolhaUsuView = (ImageView) findViewById(R.id.escolhaUsuView);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void pedra(View view){this.opcaoSelecionada("pedra");}
    public void papel(View view){this.opcaoSelecionada("papel");}
    public void tesoura(View view){this.opcaoSelecionada("tesoura");}

    public void mudarImagemEscolhaApp(String escolhaApp){
        if(escolhaApp.equals("pedra")){escolhaMaqView.setImageResource(R.drawable.pedra); }
        else if(escolhaApp.equals("papel")){escolhaMaqView.setImageResource(R.drawable.papel);}
        else {escolhaMaqView.setImageResource(R.drawable.tesoura);}
    }

    public void mudarImagemEscolaUser(String escolhaUsuario){
        if(escolhaUsuario.equals("pedra")){escolhaUsuView.setImageResource(R.drawable.pedra);}
        else if(escolhaUsuario.equals("papel")){escolhaUsuView.setImageResource(R.drawable.papel);}
        else{escolhaUsuView.setImageResource(R.drawable.tesoura);}
    }

    public void opcaoSelecionada(String escolhaUsuario){

        //Escolha do App
        String opcoes[] = {"pedra","papel","tesoura"};
        int indice = new Random().nextInt(opcoes.length);
        String escolhaApp = opcoes[indice];

        //Usuário Ganha
        if(escolhaUsuario=="pedra" && escolhaApp=="tesoura"
                || escolhaUsuario=="papel" && escolhaApp=="pedra"
                || escolhaUsuario=="tesoura" && escolhaApp=="papel"){
            mudarImagemEscolhaApp(escolhaApp);
            mudarImagemEscolaUser(escolhaUsuario);
            resultado.setText("Você venceu!");


            //App Ganha
        }else if (escolhaApp=="pedra" && escolhaUsuario=="tesoura"
                || escolhaApp=="papel" && escolhaUsuario=="pedra"
                || escolhaApp=="tesoura" && escolhaUsuario=="papel"){
            mudarImagemEscolhaApp(escolhaApp);
            mudarImagemEscolaUser(escolhaUsuario);
            resultado.setText("Você perdeu!");
            //Empate
        }else{
            mudarImagemEscolhaApp(escolhaApp);
            mudarImagemEscolaUser(escolhaUsuario);
            resultado.setText("Empate!");
        }


    }
}
