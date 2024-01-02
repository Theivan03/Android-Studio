package es.pmdm.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.pmdm.viewbinding.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sin viewBinding...
        /*
        setContentView(R.layout.activity_main2);

        TextView lbl = (TextView) findViewById(R.id.txtViewActividad2);
        lbl.setText("HOLA");
        */

        // Con viewBinding...
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.txtViewActividad2.setText("HOLA");
    }
}