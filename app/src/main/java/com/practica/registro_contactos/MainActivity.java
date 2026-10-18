
package com.practica.registro_contactos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etCorreo = findViewById(R.id.etCorreo);
        EditText etTelefono = findViewById(R.id.etTelefono);

        RadioGroup rgTipo = findViewById(R.id.rgTipo);
        Button btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(v -> {

            String nombre = etNombre.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();
            String telefono = etTelefono.getText().toString().trim();

            if (nombre.isEmpty()) {
                etNombre.setError("Ingrese su nombre");
                etNombre.requestFocus();
                return;
            }

            if (correo.isEmpty() ||
                    !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {

                etCorreo.setError("Ingrese un correo válido");
                etCorreo.requestFocus();
                return;
            }

            if (!telefono.matches("[0-9]{8}")) {

                etTelefono.setError(
                        "El teléfono debe tener 8 dígitos"
                );

                etTelefono.requestFocus();
                return;
            }

            int idSeleccionado = rgTipo.getCheckedRadioButtonId();

            if (idSeleccionado == -1) {

                Toast.makeText(
                        MainActivity.this,
                        "Seleccione un tipo de contacto",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            RadioButton rbSeleccionado =
                    findViewById(idSeleccionado);

            String tipo = rbSeleccionado.getText().toString();

            Intent intent = new Intent(
                    MainActivity.this,
                    ConfirmacionActivity.class
            );

            intent.putExtra("nombre", nombre);
            intent.putExtra("correo", correo);
            intent.putExtra("telefono", telefono);
            intent.putExtra("tipo", tipo);

            startActivity(intent);

        });
    }
}
