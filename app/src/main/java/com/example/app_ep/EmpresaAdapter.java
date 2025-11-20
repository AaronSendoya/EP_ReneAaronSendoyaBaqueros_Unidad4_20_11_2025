package com.example.app_ep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EmpresaAdapter extends ArrayAdapter<Empresa>{
    public EmpresaAdapter(Context context, List<Empresa> listaEmpresas) {
        super(context, 0, listaEmpresas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Empresa empresa = getItem(position);

        //verficar layaouts
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_empresa, parent, false);
        }


        TextView txtNombre = convertView.findViewById(R.id.tv_nombre);
        TextView txtTelefono = convertView.findViewById(R.id.tv_telefono);
        TextView txtDomicilio = convertView.findViewById(R.id.tv_domicilio);
        TextView txtObservacion = convertView.findViewById(R.id.tv_observaciones);
        TextView txtContacto = convertView.findViewById(R.id.tv_contacto);
        TextView txtAbreviatura = convertView.findViewById(R.id.tv_abreviatura);


        if (empresa != null) {
            if (txtNombre != null) {
                txtNombre.setText(empresa.getNombre());
            }
            if (txtTelefono != null) {
                txtTelefono.setText(empresa.getTelefono());
            }
            if (txtDomicilio != null) {
                txtDomicilio.setText(empresa.getDomicilio());
            }
            if (txtObservacion != null) {
                txtObservacion.setText(empresa.getObservaciones());
            }
            if (txtContacto != null) {
                txtContacto.setText(empresa.getContacto());
            }
            if (txtAbreviatura != null) {
                txtAbreviatura.setText(empresa.getAbreviatura());
            }


        }

        return convertView;
    }
}
