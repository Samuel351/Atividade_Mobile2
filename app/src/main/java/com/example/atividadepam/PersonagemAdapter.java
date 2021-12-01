package com.example.atividadepam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext; //É a classe onde estou
    private List<Personagem> mData; //O objeto que irá representar os dados


    //Construtor da classe
    public RecyclerViewAdapter(Context mContext, List<Personagem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.personagem_layout, parent, false);

        return new MyViewHolder(view);
    }

    //Será realizada a montagem dos dados.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //passando valores para o RecyclerView
        holder.Pername.setText(mData.get(position).getName());
        holder.Perima.setImageResource(mData.get(position).getImage());
        //Evento de clique no cardView
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, Personagem.class);

                intent.putExtra("Nome", mData.get(position).getName());
                intent.putExtra("Rating", mData.get(position).getRating());
                intent.putExtra("Imagem", mData.get(position).getImage());

                mContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        //tamanho da lista de livros
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Pername;
        ImageView Perima;
        CardView cardView;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            Pername = itemView.findViewById(R.id.name);
            Perima = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.idCardView);


        }
    }
}
