package edu.pmdm.radiobuttonsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup r=(RadioGroup)findViewById(R.id.radioGroup);
        // Opción 2
        //r.setOnCheckedChangeListener(this);
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView t=(TextView)findViewById(R.id.txtEstado);
                switch(i){
                    case R.id.rbTalavera:
                        t.setText("Buena elección!: El Talavera promete!!");
                        break;
                    case R.id.rbAlcazar:
                        t.setText("Gran equipo la gimnástica!!");
                        break;
                    case R.id.rbAlbacete:
                        t.setText("El Albacete no es el mismo desde que se fué Iniesta");
                        break;
                    case R.id.rbOtros:
                        t.setText("El dinero no lo es todo....");
                        break;
                }
            }
        });
        CheckBox miChk=(CheckBox)findViewById(R.id.chkFutbol);
        miChk.setOnCheckedChangeListener(this);

    }

    // Opción 2
    /*@Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        TextView t=(TextView)findViewById(R.id.txtEstado);
        switch(checkedId){
            case R.id.rbTalavera:
                t.setText("Buena elección!: El Talavera promete!!");
                break;
            case R.id.rbAlcazar:
                t.setText("Gran equipo la gimnástica!!");
                break;
            case R.id.rbAlbacete:
                t.setText("El Albacete no es el mismo desde que se fué Iniesta");
                break;
            case R.id.rbOtros:
                t.setText("El dinero no lo es todo....");
                break;
        }
    }*/

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        TextView t=(TextView)findViewById(R.id.txtGusta);
        if(isChecked)
            t.setText("Te gusta el fútbol!!");
        else
            t.setText("No te gusta el fútbol?!??!!");
    }
}