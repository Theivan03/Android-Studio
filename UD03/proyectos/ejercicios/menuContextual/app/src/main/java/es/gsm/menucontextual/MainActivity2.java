package es.gsm.menucontextual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class

MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int position = intent.getIntExtra("CIUDAD_POSITION",0);

        // Obtener la ciudad
        Ciudad ciudad = CiudadDataSource.ciudades.get(position);

        TextView txtDescripcion = (TextView) findViewById(R.id.txtDescripcionData);
        txtDescripcion.setText(ciudad.getDescripcion());

        TextView txtCiudad = (TextView) findViewById(R.id.txtCiudadData);
        txtCiudad.setText(ciudad.getNombre());

        ImageView imgCiudad = (ImageView) findViewById(R.id.imgCiudadData);
        imgCiudad.setImageResource(ciudad.getImagen());

        Log.d("RDT","creada la fila " + position);
    }
}