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
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        executarImagem(  );
        this.opcao = opcao;
        mostraResultado();



    }
    private void mostraResultado(  ){
        Log.d("Opcao", opcao);
        String[] opcoes = {"pedra", "papel", "tesoura"};

        int n = new Random().nextInt(3);



        String resultado = opcoes[n];
        ImageView imageView = findViewById(R.id.imagePadrao);
        TextView textView = findViewById(R.id.textoResultado);

        imageView.setImageResource(R.drawable.transparente);

        /*Gif Animado*/
            /*imageView.setBackgroundResource(R.drawable.splash_animation);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            animationDrawable.start();*/


        switch (resultado){
            case "pedra":
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

            case "papel":

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

            case "tesoura":

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
    private void executarImagem(){

       Thread t = new Thread(new Runnable() {
           @Override
           public void run() {
               ImageView imageView = findViewById(R.id.imagePadrao);
               int m = 0;
               int n = 3;
               List<Integer> op = new ArrayList<Integer>();
               op.add(R.drawable.pedra);
               op.add(R.drawable.papel);
               op.add(R.drawable.tesoura);

               Collections.sort( op );

               Iterator iterator = op.iterator();
               for (int i = 0; i < 3; i++){
                   while (iterator.hasNext()){
                       m = (int) iterator.next();
                       imageView.setImageResource( m );
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
       });
       t.start();

       /*{
            public void run(){


                *//*
                for (int i = 0; i < 3; i++){

                    m = r.nextInt(n);
                    Log.d("Number: ", ""+n);
                    imageView.setImageResource(op[m]);
                    n--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Log.d("Number: ", ""+n);
                    m = r.nextInt(n);
                    imageView.setImageResource(op[m]);
                    n--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                  ///  Log.d("Number: ", ""+m);

                    Log.d("Numero", ""+n);
                    m = r.nextInt(n);
                    imageView.setImageResource(op[m]);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    n = 3;
                }*//*

            }

        }.start();*/




    }


}
