package br.edu.ifsp.scl.sdm.parouimpar;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import br.edu.ifsp.scl.sdm.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {
        // Referencias para objetos de Ui no leioute

    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.mostrarOpcoesSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean mostrarOpcoes) {
                activityMainBinding.selecionarOpcaolL.setVisibility( mostrarOpcoes? View.VISIBLE : View.GONE );
            }
        });

    }


    public void onClick(View view) {
        int jogada = -1;
        switch (view.getId()) {
            case R.id.zeroBt:
                jogada = 0;
                break;
            case  R.id.umBt:
                jogada = 1;
                break;
            case R.id.doisBt:
                jogada = 2;
                break;
            case R.id.tresBt:
                jogada = 3;
                break;
            case R.id.quatroBt:
                jogada = 4;
                break;
            case R.id.cincoBt:
                jogada = 5;
                break;
            default:
                break;

        }
        jogarParOuImpar (jogada);
    }

    private void jogarParOuImpar(int jogada) {
        Random random = new  Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(6);

        // Setando imagem da jogada do computador

        int imagemJogadaComputadorId = -1;
        switch (jogadaComputador) {
            case 0:
                imagemJogadaComputadorId = R.mipmap.zero;
                break;
            case 1:
                imagemJogadaComputadorId = R.mipmap.one;
                break;
            case 2:
                imagemJogadaComputadorId = R.mipmap.two;
                break;
            case 3:
                imagemJogadaComputadorId = R.mipmap.three;
                break;
            case 4:
                imagemJogadaComputadorId = R.mipmap.four;
                break;
            case 5:
                imagemJogadaComputadorId = R.mipmap.five;
                break;
            default:
                break;

        }
            activityMainBinding.jogadaComputadorIv.setImageResource(imagemJogadaComputadorId);


        StringBuilder resultadoSB = new StringBuilder();
        resultadoSB.append("Sua jogada:  ");
        resultadoSB.append(jogada);

        resultadoSB.append(",  Computador  ");
        resultadoSB.append(jogadaComputador);

        if (activityMainBinding.parRb.isChecked()) {
            resultadoSB.append((jogada + jogadaComputador) % 2 == 0 ? " Você GANHOU! " : " Você PERDEU! ");
        }
        else {
            resultadoSB.append((jogada + jogadaComputador) % 2 == 0 ? " Você PERDEU! " : " Você GANHOU! ");
        }

        activityMainBinding.resultadoTv.setText(resultadoSB.toString());
        }
    }


