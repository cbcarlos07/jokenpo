package com.tafarelbrayan.jokenpo;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String opcao;
    int resultado;
    private ImageView imageView;
    private TextView  textView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imagePadrao);
        textView = findViewById(R.id.textoResultado);
    }

    public void pedra(View view){
        ImageView imageView = findViewById(R.id.imagePedra);
        imageView.setImageResource(R.drawable.pedra);

        this.jogar("pedra");
    }

    public void papel(View view){
        ImageView imageView = findViewById(R.id.imagePapel);
        imageView.setImageResource(R.drawable.papel);
        this.jogar("papel");
    }

    public void tesoura(View view){
        ImageView imageView = findViewById(R.id.imageTesoura);
        imageView.setImageResource(R.drawable.tesoura);
        this.jogar("tesoura");
    }

    @SuppressLint("ResourceAsColor")
    public void jogar(String opcao){
        int[] opcoes = {R.drawable.pedra, R.drawable.papel, R.drawable.tesoura};

        int n = new Random().nextInt(3);
        resultado = opcoes[n];
        textView.setText("Aguarde");
        executarImagem(   );
        this.opcao = opcao;




    }
    private void mostraResultado(  ){

        imageView.setImageResource(R.drawable.transparente);

        /*Gif Animado*/
            /*imageView.setBackgroundResource(R.drawable.splash_animation);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            animationDrawable.start();*/

        // Log.d("Resultado: ", resultado);
        switch (resultado){
            case R.drawable.pedra:
                // animationDrawable.stop();
                imageView.setImageResource(R.drawable.pedra);

                if(opcao != "pedra"){
                    if(opcao == "papel"){
                        textView.setText("VOCÊ GANHOU!");
                        textView.setTextColor(getResources().getColor(R.color.colorSuccess));
                    }else{
                        textView.setText("VOCÊ PERDEU!");
                        textView.setTextColor(getResources().getColor(R.color.colorDanger));
                    }
                }else{
                    textView.setText("EMPATE");
                    textView.setTextColor(getResources().getColor(R.color.colorWarning));
                }

                break;

            case R.drawable.papel:

                imageView.setImageResource(R.drawable.papel);

                if(opcao != "papel"){
                    if(opcao == "tesoura"){
                        textView.setText("VOCÊ GANHOU!");
                        textView.setTextColor(getResources().getColor(R.color.colorSuccess));
                    }else{
                        textView.setText("VOCÊ PERDEU!");
                        textView.setTextColor(getResources().getColor(R.color.colorDanger));
                    }
                }else{
                    textView.setText("EMPATE");
                    textView.setTextColor(getResources().getColor(R.color.colorWarning));
                }
                break;

            case R.drawable.tesoura:

                imageView.setImageResource(R.drawable.tesoura);

                if(opcao != "tesoura"){
                    if(opcao == "pedra"){
                        textView.setText("VOCÊ GANHOU!");
                        textView.setTextColor(getResources().getColor(R.color.colorSuccess));
                    }else{
                        textView.setText("VOCÊ PERDEU!");
                        textView.setTextColor(getResources().getColor(R.color.colorDanger));
                    }
                }else{
                    textView.setText("EMPATE");
                    textView.setTextColor(getResources().getColor(R.color.colorWarning));
                }
                break;
        }
    }
    private void executarImagem(  ){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                imageView = findViewById(R.id.imagePadrao);
                int m = 0;
                int n = 0;
                List<Integer> op = new ArrayList<Integer>();
                op.add(R.drawable.pedra);
                op.add(R.drawable.papel);
                op.add(R.drawable.tesoura);

                Collections.shuffle( op );

                Iterator iterator = op.iterator();
                for (int i = 0; i < 6; i++){
                    n++;
                    Log.d("Incremento", ""+n);
                    while (iterator.hasNext()){
                        m = (int) iterator.next();
                        Log.d( "Numero", ""+m );
                        imageView.setImageResource( m );
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Collections.shuffle( op );
                    iterator = op.iterator();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mostraResultado();
                    }
                });

            }
        });
        t.start();
        imageView = findViewById(R.id.imagePadrao);
        imageView.setImageResource( resultado );







    }


}
