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
    TextView txtVitorias;
    TextView txtDerrotas;
    TextView txtEmpates;
    int vitorias = 0, derrotas = 0, empates = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escolhaMaqView = (ImageView) findViewById(R.id.escolhaMaqView);
        escolhaUsuView = (ImageView) findViewById(R.id.escolhaUsuView);
        resultado = (TextView) findViewById(R.id.resultado);
        txtVitorias = (TextView) findViewById(R.id.txtVitorias);
        txtDerrotas = (TextView) findViewById(R.id.txtDerrotas);
        txtEmpates = (TextView) findViewById(R.id.txtEmpates);
    }

    public void pedra(View view){this.opcaoSelecionada("pedra");}
    public void papel(View view){this.opcaoSelecionada("papel");}
    public void tesoura(View view){this.opcaoSelecionada("tesoura");}

    public void mudarImagemEscolhaApp(String escolhaApp){
        if(escolhaApp.equals("pedra")){escolhaMaqView.setImageResource(R.drawable.pedra); }
        else if(escolhaApp.equals("papel")){escolhaMaqView.setImageResource(R.drawable.papel);}
        else {escolhaMaqView.setImageResource(R.drawable.tesoura);}
    }

    public void mudarImagemEscolhaUser(String escolhaUsuario){
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
            mudarImagemEscolhaUser(escolhaUsuario);
            resultado.setText("Você venceu!");
            vitorias++;
            txtVitorias.setText(String.valueOf(vitorias));

            //App Ganha
        }else if (escolhaApp=="pedra" && escolhaUsuario=="tesoura"
                || escolhaApp=="papel" && escolhaUsuario=="pedra"
                || escolhaApp=="tesoura" && escolhaUsuario=="papel"){
            mudarImagemEscolhaApp(escolhaApp);
            mudarImagemEscolhaUser(escolhaUsuario);
            resultado.setText("Você perdeu!");
            derrotas++;
            txtDerrotas.setText(String.valueOf(derrotas));

            //Empate
        }else{
            mudarImagemEscolhaApp(escolhaApp);
            mudarImagemEscolhaUser(escolhaUsuario);
            resultado.setText("Empate!");
            empates++;
            txtEmpates.setText(String.valueOf(empates));
        }

    }
}
