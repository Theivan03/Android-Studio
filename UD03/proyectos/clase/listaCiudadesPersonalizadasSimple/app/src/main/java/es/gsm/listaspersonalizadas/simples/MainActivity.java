
package es.gsm.listaspersonalizadas.simples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView miListaCiudades;

    // Datos a mostrar en la lista.
    String [] provincias = new String[]{"Ciudad Real","Toledo","Guadalajara","Cuenca","Albacete","Talavera", "Alicante", "Valencia", "Castellón", "Burgos", "Salamanca", "Valladolid",
                                       "Teruel", "Zaragoza", "Huesca", "Segovia", "Avila", "Barcelona", "Tarragona","Gerona", "Lérida"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miListaCiudades = findViewById(R.id.miListaCiudades); // IU -> se va a "inflar" una fila por cada ciudad a través de mi_fila_personalizada.xml

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, R.layout.fila, provincias); // Adaptador

        // Enchufar adaptador a la vista
        miListaCiudades.setAdapter(miAdaptador);
        miListaCiudades.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Se ha pulsado "+ provincias[position],Toast.LENGTH_SHORT).show();
        String s = ((TextView)view).getText().toString();
    }
}