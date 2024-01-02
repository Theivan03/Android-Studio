package es.german.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView2);

        Button btn = (Button) findViewById(R.id.btnInsert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText() + "1");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("texto", txt.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        String texto = savedInstanceState.getString("texto");
        txt.setText(texto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemConfFacturas:
                Toast.makeText(getApplicationContext(), "Has pulsado configuracion de facturas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemConfPedidos:
                Toast.makeText(getApplicationContext(), "Has pulsado configuracion de pedidos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemConfClientes:
                Toast.makeText(getApplicationContext(), "Has pulsado configuracion de clientes", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemAcercaDe:
                Intent siguiente = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(siguiente);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}