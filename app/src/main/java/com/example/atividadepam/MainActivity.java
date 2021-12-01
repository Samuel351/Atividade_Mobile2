package com.example.atividadepam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Personagem> listpers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listpers.add(new Personagem("Ahri", "10", R.drawable.ahri));
        listpers.add(new Personagem("Yasuo", "10", R.drawable.ahri));
        listpers.add(new Personagem("Ziggs", "10", R.drawable.ahri));
        listpers.add(new Personagem("Morgana", "10", R.drawable.ahri));
        listpers.add(new Personagem("Yone", "10", R.drawable.ahri));
        listpers.add(new Personagem("Captain Price", "10", R.drawable.ahri));
        listpers.add(new Personagem("Smoke", "10", R.drawable.ahri));
        listpers.add(new Personagem("Ash", "10", R.drawable.ahri));
        listpers.add(new Personagem("Smoke", "10", R.drawable.ahri));
        listpers.add(new Personagem("Smoke", "10", R.drawable.ahri));


        //declarando a variavel xml enviando para o java
        RecyclerView mRecyclerView = findViewById(R.id.recycler);

        //Instânciando o adaptador com os valores necessários
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getApplicationContext(), listpers);
        //Criando o layout para inserção dos valores

        //LayoutManager não é necessário inserção de colunas - pode ser utilizado na vertical ou horizontal
        // mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,true));

        //GriLayoutManager necessário a inserção de colunas
        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        //Para melhorar a performance do RecyclerView na listagem com um tamanho fixo
        mRecyclerView.setHasFixedSize(true);

        //Inserindo os valores na lista do RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }
}