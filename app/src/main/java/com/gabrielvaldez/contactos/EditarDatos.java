package com.gabrielvaldez.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditarDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);

        Bundle Datos = getIntent().getExtras();
        if (Datos!=null) {
            String nombre = Datos.getString("nombre");
            String FechaNacimiento = Datos.getString("FechaNacimiento");
            String telefono = Datos.getString("telefono");
            String email = Datos.getString("email");
            String descripcion = Datos.getString("descripcion");

            tvNombre = findViewById(R.id.NombreConfirmar);
            tvFecha = findViewById(R.id.FechaNacimientoC);
            tvTelefono = findViewById(R.id.TelefonoC);
            tvEmail = findViewById(R.id.emailC);
            tvDescripcion = findViewById(R.id.DescripcionC);

            tvNombre.setText(nombre);
            tvFecha.setText(FechaNacimiento);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescripcion.setText(descripcion);
        }else {
            tvNombre.setText(" ");
            tvFecha.setText(" ");
            tvTelefono.setText(" ");
            tvEmail.setText(" ");
            tvDescripcion.setText(" ");
        }
    }
    public void EditarDatos(View view){
        Intent i = new Intent(this , MainActivity.class);
        i.putExtra("NombreEdit",tvNombre.getText().toString());
        i.putExtra("fecha",tvFecha.getText().toString());
        i.putExtra("TelefonoEdit",tvTelefono.getText().toString());
        i.putExtra("EmailEdit",tvEmail.getText().toString());
        i.putExtra("DescripcionEdit",tvDescripcion.getText().toString());
        startActivity(i);
        finish();
    }
}