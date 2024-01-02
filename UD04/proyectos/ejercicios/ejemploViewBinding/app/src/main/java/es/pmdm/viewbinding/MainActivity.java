package es.pmdm.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import es.pmdm.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;  // Se crea de forma automatica una clase con el nombre del layout sin '_' y con binding al final.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sin viewBinding...
        /*
        setContentView(R.layout.activity_main);

        EditText editTxtNombre = (EditText) findViewById(R.id.editTxtNombre);
        Spinner spnTratamiento = (Spinner) findViewById(R.id.spnTratamiento);
        RadioButton rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
        RadioButton rbtn2 = (RadioButton) findViewById(R.id.rbtn2);
        RadioButton rbtn3 = (RadioButton) findViewById(R.id.rbtn3);
        CheckBox ckb1 = (CheckBox) findViewById(R.id.ckb1);
        Button btnSaludar = (Button) findViewById(R.id.btnSaludar);
        TextView lblSaludo = (TextView) findViewById(R.id.lblSaludo);

        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });
        */

        // Con viewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Directamente en el objeto binding, tenemos disponibles todos los componentes de nuestro layout.
        binding.rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });

    }
}