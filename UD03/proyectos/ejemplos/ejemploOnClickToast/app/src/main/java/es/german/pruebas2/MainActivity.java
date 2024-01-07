package es.german.pruebas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.my_button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // El codigo que quiero que se ejecute cuando pulso el boton...
                Toast.makeText(v.getContext()," 2ª manera",Toast.LENGTH_LONG).show();
                ImageView imagen = (ImageView) findViewById(R.id.imageView);
                imagen.setImageResource(R.drawable.ivam);
            }
        });

    }


}