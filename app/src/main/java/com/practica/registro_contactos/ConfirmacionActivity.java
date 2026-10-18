
package com.practica.registro_contactos;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirmacion);

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvCorreo = findViewById(R.id.tvCorreo);
        TextView tvTelefono = findViewById(R.id.tvTelefono);
        TextView tvTipo = findViewById(R.id.tvTipo);

        Button btnVolver = findViewById(R.id.btnVolver);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        String nombre = getIntent().getStringExtra("nombre");
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        String tipo = getIntent().getStringExtra("tipo");

        tvNombre.setText("Nombre: " + nombre);
        tvCorreo.setText("Correo: " + correo);
        tvTelefono.setText("Teléfono: " + telefono);
        tvTipo.setText("Tipo: " + tipo);

        btnVolver.setOnClickListener(v -> {
            finish();
        });

        btnConfirmar.setOnClickListener(v -> {

            Toast.makeText(
                    ConfirmacionActivity.this,
                    "Contacto confirmado",
                    Toast.LENGTH_SHORT
            ).show();

        });
    }
}
