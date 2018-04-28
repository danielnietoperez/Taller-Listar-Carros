package com.example.user.taller2;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCarros extends RecyclerView.Adapter<AdaptadorCarros.CarrosViewHolder>{
    private ArrayList<Carros> carros;

    public AdaptadorCarros(ArrayList<Carros> carros){
        this.carros=carros;
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_carro,parent,false);
        return new CarrosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarrosViewHolder holder, int position) {
        Resources res = holder.itemView.getContext().getResources();
        Carros c = carros.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.placa.setText(c.getPlaca());
        holder.marca.setText(res.getStringArray(R.array.marca)[c.getMarca()]);
        holder.modelo.setText(res.getStringArray(R.array.modelo)[c.getModelo()]);
        holder.precio.setText(""+c.getPrecio());
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView marca;
        private TextView modelo;
        private TextView precio;
        private View v;
        public CarrosViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            placa = v.findViewById(R.id.lblPlaca);
            marca = v.findViewById(R.id.lblMarca);
            modelo = v.findViewById(R.id.lblModelo);
            precio = v.findViewById(R.id.lblPrecio);
        }
    }
}

