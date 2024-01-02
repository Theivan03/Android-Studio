package com.pmdm.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final String CANAL_ID = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSimple = (Button) findViewById(R.id.btnNotificacionSimple);
        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarNotificacion(false, false);
            }
        });

        Button btnExpandida = (Button) findViewById(R.id.btnNotificacionExpandida);
        btnExpandida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarNotificacion(true, false);
            }
        });

        Button btnActividad = (Button) findViewById(R.id.btnNotificacionActividad);
        btnActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarNotificacion(false, true);
            }
        });

    }

    // Vamos a usar la clase NotificationCompat para crear una notificación compatible con versiones anteriores de Android.
    // En versiones más recientes de Android (a partir del api 26, esto es, Android 8.0 (Oreo), tenemos que usar las conales de notificación.
    private void mostrarNotificacion(boolean expandible, boolean actividad) {

        // 1.- Crear la notificación con sus propiedades.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CANAL_ID);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);

        if(!expandible) {  // Notificación simple
            builder.setContentTitle("Mi notificación");
            builder.setContentText("Has recibido una notificación");
        } else {          // Notificación expandible
            NotificationCompat.InboxStyle estilo = new NotificationCompat.InboxStyle();
            estilo.setBigContentTitle("Notificación expandible");

            // Creo las diferentes líneas
            String[] lineas = new String[5];
            lineas[0] = "Linea 1 de la notificación";
            lineas[1] = "Linea 2 de la notificación";
            lineas[2] = "Linea 3 de la notificación";
            lineas[3] = "Linea 4 de la notificación";
            lineas[4] = "Linea 5 de la notificación";

            for(int i=0; i<lineas.length; i++)
                estilo.addLine(lineas[i]);

            // Asignamos el "estilo" al builder.
            builder.setStyle(estilo);
        }

        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        // Si queremos que lance otra actividad
        if (actividad) {
            // Creamos el intent para la nueva actividad que se lanzará al pulsar la notificación
            Intent intent = new Intent(this, MainActivity2.class);
            PendingIntent pending = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            builder.setContentIntent(pending);
        }

        // 2.- Añadir el canal al sistema de notificaciones
        // Accedo al sistema de notificaciones de Android (al servicio)
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // A partir de dispositivos que usen API 26 o superior (Android Oreo)
            NotificationChannel canal = new NotificationChannel(CANAL_ID, "Titulo del canal", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(canal); // Crear/Añadir mi canal en el sistema de notificaciones
        }

        // 3.- Enviar la notificación al canal para mostrarla
        Notification notificacion =  builder.build();
        notificationManager.notify(Integer.parseInt(CANAL_ID), notificacion);

    }

}