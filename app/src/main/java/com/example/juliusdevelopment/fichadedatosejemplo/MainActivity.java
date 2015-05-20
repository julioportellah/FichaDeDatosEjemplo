package com.example.juliusdevelopment.fichadedatosejemplo;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

        Button buttonSaveData;
        //Parte Superior
        EditText institucionProcedencia,distritoProcedencia,tipoEvento;
        private TextView lblFecha;
        //Parte de los nombres
        EditText apellidoPaterno,apellidoMaterno,nombresCompletos;
        //Parte de lalos datos personales
        EditText numeroDNI;

        //Parte de domicilio
        EditText distrito;

        //Parte de telefono,cel y correo
        EditText telefonoCasa, telefonoCelular, correoElectronico;

        //Parte de intereses
        EditText interesCursoTexto;

        CheckBox interesTelematica,interesTelecomunicaciones,interesCurso;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            lblFecha=(TextView)findViewById(R.id.lblDate);
            lblFecha.setText(getLocalTime());
            buttonSaveData=(Button)findViewById(R.id.guardar_datos);
            //buttonSaveData.setOnClickListener(saveHandler);

            //Declarando nombres
            apellidoPaterno=(EditText)findViewById(R.id.apellido_paterno);
            apellidoMaterno=(EditText)findViewById(R.id.apellido_materno);
            nombresCompletos=(EditText)findViewById(R.id.nombres_completos);

            //Declarando datosPersonales
            numeroDNI=(EditText)findViewById(R.id.dni);

            //Declarando Distrito
            distrito=(EditText)findViewById(R.id.distrito);

            //Declarando Datos
            telefonoCasa=(EditText)findViewById(R.id.telefono_casa);
            telefonoCelular=(EditText)findViewById(R.id.celular);
            correoElectronico=(EditText)findViewById(R.id.correo_electronico);

            //Declarando Intereses
            interesCursoTexto=(EditText)findViewById(R.id.tipo_de_curso);
            interesTelecomunicaciones=(CheckBox)findViewById(R.id.interes_telecomunicaciones);
            interesTelematica=(CheckBox)findViewById(R.id.interes_telematica);
            interesCurso=(CheckBox)findViewById(R.id.interes_curso);



        }


        //public void click(view)

        public void onInterestCheckBoxClicked(View view){
            boolean checked = ((CheckBox) view).isChecked();
            switch (view.getId()){
                case R.id.interes_telematica:
                    if(checked){
                        interesTelematica.setChecked(true);
                    }else{
                        interesTelematica.setChecked(false);
                    }
                        break;
                case R.id.interes_telecomunicaciones:
                    if(checked){
                        interesTelecomunicaciones.setChecked(true);
                    }else{
                        interesTelecomunicaciones.setChecked(false);
                    }break;
                case R.id.interes_curso:
                    if(checked){
                        interesCursoTexto.setEnabled(true);
                        interesCurso.setEnabled(true);
                    }else{
                        interesCursoTexto.setEnabled(false);
                        interesCurso.setEnabled(false);
                    }break;
            }
        }


        private boolean checkObligatoryFields(){
            boolean chkNombres, chkApellidoPaterno,chkApellidoMaterno,chkDNI,chkDistrito,chkTelefonoCasa;
            boolean chkCelular, chkCorreoElectronico;
            boolean veredict=false;


            chkNombres=nombresCompletos.getText().toString().isEmpty();
            chkApellidoPaterno=apellidoPaterno.getText().toString().isEmpty();
            chkApellidoMaterno=apellidoMaterno.getText().toString().isEmpty();
            chkDNI=numeroDNI.getText().toString().isEmpty();
            chkDistrito=distrito.getText().toString().isEmpty();
            chkTelefonoCasa=telefonoCasa.getText().toString().isEmpty();
            chkCelular=telefonoCelular.getText().toString().isEmpty();
            chkCorreoElectronico=correoElectronico.getText().toString().isEmpty();


            if (chkApellidoPaterno) {
                Toast.makeText(MainActivity.this, "Introduzca el apellido paterno", Toast.LENGTH_SHORT).show();
                return veredict;
            }else if( chkApellidoMaterno  ){
                Toast.makeText(MainActivity.this,"Introduzca el apellido materno" , Toast.LENGTH_SHORT).show();
                return veredict;
            }else if(chkNombres){
                Toast.makeText(MainActivity.this, "Introduzca el nombre", Toast.LENGTH_SHORT).show();
                return veredict;
            }else if(chkDNI){
                Toast.makeText(MainActivity.this, "Introduzca el número de DNI", Toast.LENGTH_SHORT).show();
                return veredict;
            }else if(chkDistrito){
                Toast.makeText(MainActivity.this, "Introduzca el Distrito", Toast.LENGTH_SHORT).show();
                return veredict;
            }else if(chkTelefonoCasa){
                Toast.makeText(MainActivity.this, "Introduzca el Teléfono de Fijo", Toast.LENGTH_SHORT).show();
                return veredict;
            }else if(chkCelular){
                Toast.makeText(MainActivity.this, "Introduzca el Teléfono de Celular", Toast.LENGTH_SHORT).show();
                return veredict;
            }else if(chkCorreoElectronico){
                Toast.makeText(MainActivity.this, "Introduzca el Correo Electrónico", Toast.LENGTH_SHORT).show();
                return veredict;
            }else{
                veredict=true;
            }
            return veredict;
        }

        public void saveData(View view){

            String nombresCompletosText, apellidoPaternoText,apellidoMaternoText;
            boolean decider;
            decider=checkObligatoryFields();
            nombresCompletosText=nombresCompletos.getText().toString();
            apellidoPaternoText=apellidoPaterno.getText().toString();
            apellidoMaternoText=apellidoMaterno.getText().toString();

            if (decider){
                Toast.makeText(MainActivity.this, "Éxito!!!", Toast.LENGTH_SHORT).show();
            }

            //
        }

        private String getLocalTime()
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            String horarioActual=dateFormat.format(cal.getTime()).toString();
            return horarioActual;
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
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
