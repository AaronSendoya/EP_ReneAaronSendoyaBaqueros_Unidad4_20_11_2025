package com.example.app_ep;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // Definimos la ruta relativa (La base URL se define en el cliente)
    @GET("api/productos")
    Call<List<Empresa>> obtenerEmpresas();

    @POST("api/productos")
    Call<Void> agregarEmpresa(@Body Empresa empresa);
}
