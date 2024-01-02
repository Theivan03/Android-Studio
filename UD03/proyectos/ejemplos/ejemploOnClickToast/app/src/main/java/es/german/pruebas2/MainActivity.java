package es.german.pruebas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3ª manera
        Button btn1 = (Button) findViewById(R.id.my_button1);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.my_button2);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.my_button3);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.my_button4);
        btn4.setOnClickListener(this);

        /*// 2º manera.
        Button btn = (Button) findViewById(R.id.my_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // El codigo que quiero que se ejecute cuando pulso el boton...
                Toast.makeText(v.getContext()," 2ª manera",Toast.LENGTH_LONG).show();
            }
        });*/
    }

    // 3º manera
    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        int id = b.getId();
        if (id == R.id.my_button1) {
            Toast.makeText(view.getContext(), "Saluda", Toast.LENGTH_LONG).show();
        } else if (id == R.id.my_button2) {
            Toast.makeText(view.getContext(), "Hola", Toast.LENGTH_LONG).show();
        } else if (id == R.id.my_button3) {
            Toast.makeText(view.getContext(), "Adios", Toast.LENGTH_LONG).show();
        } else if (id == R.id.my_button4) {
            Toast.makeText(view.getContext(), "Prueba", Toast.LENGTH_LONG).show();
        }
    }

    // 1er manera.
    /*public void prueba(View view){
        Log.d("traza", "probando");
        Toast.makeText(view.getContext(),"1ª manera",Toast.LENGTH_LONG).show();
    }*/

}