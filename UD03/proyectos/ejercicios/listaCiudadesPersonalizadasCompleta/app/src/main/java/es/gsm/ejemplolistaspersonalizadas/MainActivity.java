package es.gsm.ejemplolistaspersonalizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView miListaCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CiudadDataSource.Inizialize();  // Inicializar el listado de ciudades.
        miListaCiudades = findViewById(R.id.miListaCiudades); // IU -> se va a "inflar" una fila por cada ciudad a través de mi_fila_personalizada.xml

        
        CiudadAdapter miAdaptadorCiudades = new CiudadAdapter(this,R.layout.ciudad_personalizada,CiudadDataSource.ciudades);  // Crear el adaptador para gestionar las ciudades.

        // Enchufar adaptador a la vista
        miListaCiudades.setAdapter(miAdaptadorCiudades);
        miListaCiudades.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Acción al clickar sobre un elemento determinado
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("CIUDAD_POSITION", position);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}