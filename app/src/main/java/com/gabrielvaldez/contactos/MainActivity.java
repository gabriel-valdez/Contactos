package com.gabrielvaldez.contactos;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.PersistableBundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.CalendarView;
        import android.widget.EditText;
        import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private CalendarView fechaNacimiento;
    private EditText numero;
    private EditText email;
    private EditText descripcion;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fechaNacimiento=findViewById(R.id.calendarView);
        nombre=findViewById(R.id.etNombre);
        numero=findViewById(R.id.etTelefono);
        email=findViewById(R.id.etEmail);
        descripcion=findViewById(R.id.etDescripcion);

        Bundle DatosVuelta = getIntent().getExtras();
        if (DatosVuelta != null) {
            String Nombre = DatosVuelta.getString("NombreEdit");
            String FechaNacimiento = DatosVuelta.getString("fecha");
            String Telefono = DatosVuelta.getString("TelefonoEdit");
            String Email = DatosVuelta.getString("EmailEdit");
            String Descripcion = DatosVuelta.getString("DescripcionEdit");

            nombre.setText(Nombre);
            numero.setText(Telefono);
            email.setText(Email);
            descripcion.setText(Descripcion);
        }
    }

    public void Cancelar(View view){
        fechaNacimiento.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date= "00/00/0000";
            }
        });
    }
    public void Ok(View view){
        fechaNacimiento.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "/" + (month-1) + "/" + year;
            }
        });
    }

    public void Siguiente(View view){
        Intent i = new Intent(this,EditarDatos.class);
        i.putExtra("nombre",nombre.getText().toString());
        i.putExtra("FechaNacimiento",date);
        i.putExtra("telefono",numero.getText().toString());
        i.putExtra("email",email.getText().toString());
        i.putExtra("descripcion",descripcion.getText().toString());
        startActivity(i);
        finish();
    }
}