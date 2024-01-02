package es.gsm.ejemploactividades;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private static final int SELECCIONA_OPCION = 15;

    String mes = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button);
        EditText text = (EditText) findViewById(R.id.editTextText);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent Explicito
                Intent siguiente = new Intent(MainActivity.this, MainActivity2.class);
                String aux = text.getText().toString().trim();
                siguiente.putExtra("nombre",aux);
                startActivity(siguiente);
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abrirWebSelector("https://www.marca.es");
                //llamadaTelefono("tel:+34699765234");
                //abrirLocalizacion();
                //mandarCorreo();
                //anadirContacto("Pepe","pepe@usuario.es");
                //anadirAlarma("Prueba", 13, 45);
                abrirCamaraFoto();
            }
        });

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent Explicito
                Intent siguiente = new Intent(MainActivity.this, MainActivity3.class);
                startActivityForResult(siguiente, SELECCIONA_OPCION);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECCIONA_OPCION) {  // CODIGO_ACTIVIDAD_RESULTANTE
            if (resultCode == RESULT_OK) {  // RESULT_OK
                mes = data.getStringExtra("Mes");
                TextView t = (TextView) findViewById(R.id.textView);
                t.setText(mes);
            }
            else {  // RESULT_CANCELED
                if (data == null) {
                    Toast.makeText(MainActivity.this, "No se ha devuelto un intent.", Toast.LENGTH_SHORT).show();
                } else {
                    if (!data.hasExtra("Mes")) {
                        Toast.makeText(MainActivity.this, "No se han devuelto datos para el mes.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("Mes", mes);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        mes = savedInstanceState.getString("Mes");
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText(mes);
    }

    // Métodos usados para ejecutar las distintas acciones...
    // Abrir Web presentando varias opciones...
    private void abrirWebSelector(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marca.com"));
        Intent selector = Intent.createChooser(intent, "Abre la web utilizando");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(selector);
        }
    }
    // Llamar por telefono.
    private void llamadaTelefono(String tel) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(tel));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // Buscar en google.
    private void abrirLocalizacion() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.34513,-0.34551"));
        //if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        //}
    }
    // Mandar correo.
    private void mandarCorreo() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"admin@correo.es"});
        startActivity(intent);
    }
    // Añadir Contacto
    public void anadirContacto(String name, String email) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        //if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
        //}
    }
    // Añadir una alarma.     // Requiere permisos...
    private void anadirAlarma(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // Abrir camara fotos.   // Requiere permisos...
    private void abrirCamaraFoto() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

}