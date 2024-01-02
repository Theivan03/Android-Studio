package es.gsm.menucontextual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView miListaCiudades;
    CiudadAdapter miAdaptadorCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CiudadDataSource.Inizialize();  // Inicializar el listado de ciudades.
        miListaCiudades = findViewById(R.id.miListaCiudades); // IU -> se va a "inflar" una fila por cada ciudad a través de mi_fila_personalizada.xml

        miAdaptadorCiudades = new CiudadAdapter(this,R.layout.ciudad_personalizada,CiudadDataSource.ciudades);  // Crear el adaptador para gestionar las ciudades.

        // Enchufar adaptador a la vista
        miListaCiudades.setAdapter(miAdaptadorCiudades);
        miListaCiudades.setOnItemClickListener(this);

        // Registar el menú contextual
        registerForContextMenu(miListaCiudades);
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

    // Crea el menú contextual.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // Al hacer click sobre un elemento del menú contextual.
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Ciudad c = (Ciudad) miListaCiudades.getItemAtPosition(info.position);

        int id = item.getItemId();
        switch (id) {
            case R.id.eliminar:
                Toast.makeText(getApplicationContext(), "Eliminar " + c.getNombre(), Toast.LENGTH_LONG).show();
                // Elimino la ciudad sobre la que ha pulsado.
                CiudadDataSource.ciudades.remove(c);
                // Notifico al adaptador que se han realizado cambios para refrescar el listado de la pantalla.
                miAdaptadorCiudades.notifyDataSetChanged();
                break;
            case R.id.editar:
                // Al pulsar sobre editar de un elemento determinado, voy a la segunda pantalla donde le paso la posición de la ciudad en el arraylist.
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("CIUDAD_POSITION", info.position);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
                break;
        }
        return super.onContextItemSelected(item);
    }
}