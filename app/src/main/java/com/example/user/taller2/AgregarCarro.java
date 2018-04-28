package com.example.user.taller2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AgregarCarro extends AppCompatActivity {
    private EditText txtPlaca,txtPrecio;
    private Spinner cmbMarca,cmbModelo,cmbColor;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private String opc[];
    private String opc2[];
    private String opc3[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);
        txtPlaca=findViewById(R.id.txtPlaca);
        txtPrecio=findViewById(R.id.txtPrecio);
        cmbMarca=findViewById(R.id.cmbMarca);
        cmbModelo=findViewById(R.id.cmbModelo);
        cmbColor=findViewById(R.id.cmbColor);

        opc = this.getResources().getStringArray(R.array.marca);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbMarca.setAdapter(adapter);

        opc2 = this.getResources().getStringArray(R.array.modelo);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc2);
        cmbModelo.setAdapter(adapter2);

        opc3 = this.getResources().getStringArray(R.array.color);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc3);
        cmbColor.setAdapter(adapter3);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.carro);
        fotos.add(R.drawable.carro1);
        fotos.add(R.drawable.carro2);
    }


    public boolean validar(){
        if (txtPlaca.getText().toString().isEmpty()){
            txtPlaca.setError(getResources().getString(R.string.error1));
            return false;
        }
        if (txtPrecio.getText().toString().isEmpty()){
            txtPrecio.setError(getResources().getString(R.string.error1));
            return false;
        }
        return true;
    }

    public void guardar(View v){
        if (validar()) {


            String placa;
            int precio, mod, color, marca, foto;
            foto = Metodos.fotoAleatoria(fotos);
            placa = txtPlaca.getText().toString();
            precio = Integer.parseInt(txtPrecio.getText().toString());
            marca = cmbMarca.getSelectedItemPosition();
            mod = cmbModelo.getSelectedItemPosition();
            color = cmbColor.getSelectedItemPosition();

            Carros p = new Carros(foto, placa, marca, mod, color, precio);
            p.guardar();

            Snackbar.make(v, getResources().getString(R.string.mensaje_guardado), Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            limpiar();
        }
    }

    public void limpiar(){
        txtPlaca.setText("");
        txtPrecio.setText("");
        cmbMarca.setSelection(0);
        cmbModelo.setSelection(0);
        cmbColor.setSelection(0);
        txtPlaca.requestFocus();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarro.this,Principal.class);
        startActivity(i);
    }

}
