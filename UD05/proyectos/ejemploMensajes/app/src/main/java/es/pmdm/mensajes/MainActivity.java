package es.pmdm.mensajes;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToastNormal = (Button) findViewById(R.id.btnToastNormal);
        btnToastNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Toast Normal", Toast.LENGTH_LONG).show();
            }
        });

        Button btnToastPersonalizado = (Button) findViewById(R.id.btnToastPersonalizado);
        btnToastPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarToastPersonalizado();
            }
        });

        Button btnSnackbar = (Button) findViewById(R.id.btnSnackbar);
        btnSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar s = Snackbar.make(v, "Aviso con Snackbar!", Snackbar.LENGTH_INDEFINITE);
                s.setAction("Accion", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Accion
                    }
                });
                s.setBackgroundTint(Color.BLUE);
                s.setTextColor(Color.RED);
                s.setActionTextColor(Color.YELLOW);
                s.show();
            }
        });


        Button btnDialogo = (Button) findViewById(R.id.btnDialogo);
        btnDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo();
            }
        });

    }
    private void mostrarToastPersonalizado() {
        Toast toast = new Toast(this);
        View toast_layout = getLayoutInflater().inflate(R.layout.toast_personalizado, null);
        toast.setView(toast_layout);
        TextView textView = (TextView) toast_layout.findViewById(R.id.toastMessage);
        textView.setText("Toast Personalizado");
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    private void mostrarDialogo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Título del Diálogo");
        builder.setMessage("¿Estás seguro de borrar la película?.");

        // Configurar el botón "Sí"
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Lógica a ejecutar al hacer clic en "Aceptar"
                dialog.dismiss(); // Cierra el diálogo
            }
        });

        // Configurar el botón "No"
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Lógica a ejecutar al hacer clic en "Cancelar"
                dialog.dismiss(); // Cierra el diálogo
            }
        });

        // Mostrar el diálogo
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}