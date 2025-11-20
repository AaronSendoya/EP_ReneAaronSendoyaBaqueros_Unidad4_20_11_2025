package com.example.app_ep;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Empresa> listaEmpresas = new ArrayList<>();
    private EmpresaAdapter adapter;

    private EditText txtNombre, txtTelefono, txtDomicilio, txtObservaciones, txtContacto,
    txtAbreviatura;
    private Button btnAgregar;

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializamos Retrofit
        apiService = RetrofitClient.getApiService();

        cargarPantallaDatos();

    }

    private void cargarPantallaDatos() {
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.recyclerViewProductos);
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtDomicilio = findViewById(R.id.txtDomicilio);
        txtObservaciones = findViewById(R.id.txtObservaciones);
        txtContacto = findViewById(R.id.txtContacto);
        txtAbreviatura = findViewById(R.id.txtabreviatura);

        btnAgregar = findViewById(R.id.btn_agregar);

        // Cargar datos al iniciar esta vista
        cargarEmpresas();

        if (btnAgregar != null) {
            btnAgregar.setOnClickListener(v -> agregarEmpresa());
        }
    }

    private void agregarEmpresa() {
        // 1. Obtener datos de la UI
        String empName = txtNombre.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String domicilio = txtDomicilio.getText().toString();
        String observacion = txtObservaciones.getText().toString();
        String contacto = txtContacto.getText().toString();
        String abreviatura = txtAbreviatura.getText().toString();

//        if (empName.isEmpty() || precioStr.isEmpty()) {
//            Toast.makeText(this, "Nombre y precio son obligatorios", Toast.LENGTH_SHORT).show();
//            return;
//        }

//        double precioVal;
//        try {
//            precioVal = Double.parseDouble(telefono);
//        } catch (NumberFormatException e) {
//            precioVal = 0.0;
//        }

        // 2. Crear el objeto Producto
        Empresa nuevaEmpresa = new Empresa(1, empName, telefono, domicilio, observacion, contacto, abreviatura );

        // 3. Llamada POST con Retrofit
        apiService.agregarEmpresa(nuevaEmpresa).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Agregado correctamente", Toast.LENGTH_SHORT).show();

                    txtNombre.setText("");
                    txtTelefono.setText("");
                    txtDomicilio.setText("");
                    txtObservaciones.setText("");
                    txtContacto.requestFocus();
                    txtAbreviatura.requestFocus();

                    cargarEmpresas();
                } else {
                    Toast.makeText(MainActivity.this, "Error código: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarEmpresas() {
        apiService.obtenerEmpresas().enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listaEmpresas.clear();
                    listaEmpresas.addAll(response.body());

                    if (adapter == null) {
                        adapter = new EmpresaAdapter(MainActivity.this, listaEmpresas);
                        listView.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error al obtener datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}