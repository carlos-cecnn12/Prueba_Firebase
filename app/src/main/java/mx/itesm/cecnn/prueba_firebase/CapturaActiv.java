package mx.itesm.cecnn.prueba_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CapturaActiv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button bttnGuardar = findViewById(R.id.bttnChanges);
        bttnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grabarRegistro(v);

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intListaAlumnos = new Intent(getBaseContext(),ListaAlumnosActiv.class);
                startActivity(intListaAlumnos);
            }
        });

    }

    public void grabarRegistro(View v){
        EditText etMatricula = findViewById(R.id.etMatricula);
        EditText etNombre = findViewById(R.id.etNombre);
        EditText etSemestre = findViewById(R.id.etSemestre);
        String matricula = etMatricula.getText().toString();
        String nombre = etNombre.getText().toString();
        String semestre = etSemestre.getText().toString();

        Alumno nuevoAlumno = new Alumno(matricula, nombre, Integer.parseInt(semestre));
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ruta = database.getReference("Alumnos/ "+matricula+"/");
        ruta.setValue(nuevoAlumno);
        Snackbar.make(v, "Alumno Registrado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        etMatricula.setText("");
        etNombre.setText("");
        etSemestre.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_firebase, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
