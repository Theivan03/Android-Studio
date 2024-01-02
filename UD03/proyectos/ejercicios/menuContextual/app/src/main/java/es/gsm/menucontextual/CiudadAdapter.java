package es.gsm.menucontextual;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CiudadAdapter extends ArrayAdapter<Ciudad> {

    private int mResource;
    private ArrayList<Ciudad> misCiudades;

    public CiudadAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Ciudad> objects) {
        super(context, resource, objects);
        mResource = resource;
        misCiudades = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Este método es invocado tantas veces como "filas" se pinten en la actividad (para cada ciudad, se invoca).
        LayoutInflater miInflador = LayoutInflater.from(this.getContext());
        View miFila = miInflador.inflate(mResource, parent,false);

        TextView txtDescripcion = miFila.findViewById(R.id.txtDescripcion);
        txtDescripcion.setText(misCiudades.get(position).getDescripcion());

        TextView txtCiudad = miFila.findViewById(R.id.txtCiudad);
        txtCiudad.setText(misCiudades.get(position).getNombre());

        ImageView imgCiudad = miFila.findViewById(R.id.imgCiudad);
        imgCiudad.setImageResource(misCiudades.get(position).getImagen());

        Log.d("RDT","creada la fila " + position);

        return miFila;
    }

}
