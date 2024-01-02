package es.german.ejemploguiado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String saludo = "";
    private String checkText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTxtNombre = (EditText) findViewById(R.id.editTxtNombre);
        Spinner spnTratamiento = (Spinner) findViewById(R.id.spnTratamiento);
        RadioButton rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
        RadioButton rbtn2 = (RadioButton) findViewById(R.id.rbtn2);
        RadioButton rbtn3 = (RadioButton) findViewById(R.id.rbtn3);
        CheckBox ckb1 = (CheckBox) findViewById(R.id.ckb1);
        Button btnSaludar = (Button) findViewById(R.id.btnSaludar);
        TextView lblSaludo = (TextView) findViewById(R.id.lblSaludo);

        // Radio Buttons
        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saludo = rbtn1.getText().toString();
            }
        });
        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saludo = rbtn2.getText().toString();
            }
        });
        rbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saludo = rbtn3.getText().toString();
            }
        });

        ckb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ckb1.isChecked())
                    checkText = ckb1.getText().toString().toLowerCase();
                else
                    checkText = "";
            }
        });


        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Donde va el codigo que se ejecuta cuando pulso mi boton!!
                lblSaludo.setText(saludo + " " +
                        spnTratamiento.getSelectedItem().toString() + " "
                        + editTxtNombre.getText().toString() + " " + checkText);
            }
        });

    }
}