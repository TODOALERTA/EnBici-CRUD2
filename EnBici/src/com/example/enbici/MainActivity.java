package com.example.enbici;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity {
	
	private EditText et1, et2, et3, et4, et5, et6, et7;
    
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	        et1 = (EditText) findViewById(R.id.editText1);
	        et2 = (EditText) findViewById(R.id.editText2);
	        et3 = (EditText) findViewById(R.id.editText3);
	        et4 = (EditText) findViewById(R.id.editText5);
	        et5 = (EditText) findViewById(R.id.editText4);
	        et6 = (EditText) findViewById(R.id.EditText01);
	        et7 = (EditText) findViewById(R.id.EditText02);
    }
    
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
    public void ingreso(View v) {
		   if(et1.getText().toString().trim().length() == 0){
	            et1.setText("");
		        et2.setText("");
		        et3.setText("");
		        et4.setText("");
		        et5.setText("");
		        et6.setText("");
		        et7.setText("");
	            Toast.makeText(this, "Error, Ingrese un N° de Cedula",
	                    Toast.LENGTH_SHORT).show();

		   }else{
	            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
	                    "administracion", null, 1);
	    	        SQLiteDatabase bd = admin.getWritableDatabase();
	    	        String cedula = et1.getText().toString();
	    	        String nombre = et2.getText().toString();
	    	        String bicicleta = et3.getText().toString();
	    	        String salFecha = et4.getText().toString();
	    	        String salHora = et5.getText().toString();
	    	        String regFecha = et6.getText().toString();
	    	        String regHora = et7.getText().toString();
	    	        ContentValues registro = new ContentValues();
	    	        registro.put("cedula", cedula);
	    	        registro.put("nombre", nombre);
	    	        registro.put("bicicleta", bicicleta);
	    	        registro.put("salFecha", salFecha);
	    	        registro.put("salHora", salHora);
	    	        registro.put("regFecha", regFecha);
	    	        registro.put("regHora", regHora);
	    	        bd.insert("alquiladas", null, registro);
	    	        bd.close();
	    	        et1.setText("");
	    	        et2.setText("");
	    	        et3.setText("");
	    	        et4.setText("");
	    	        et5.setText("");
	    	        et6.setText("");
	    	        et7.setText("");
	    	        Toast.makeText(this, "Se ha guardado un nuevo registro",
	    	                Toast.LENGTH_SHORT).show();

		   }
	    }
    
    
	   public void consulta(View v) {
		   if(et1.getText().toString().trim().length() == 0){
	            et1.setText("");
		        et2.setText("");
		        et3.setText("");
		        et4.setText("");
		        et5.setText("");
		        et6.setText("");
		        et7.setText("");
	            Toast.makeText(this, "Error, Ingrese un N° de Cedula",
	                    Toast.LENGTH_SHORT).show();
		   }else{
			   AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
		                "administracion", null, 1);
		        SQLiteDatabase bd = admin.getWritableDatabase();
		        String cedula = et1.getText().toString();
		        Cursor fila = bd.rawQuery(
		                "select nombre,bicicleta,salFecha,salHora,regFecha,regHora  from alquiladas where cedula=" + cedula, null);
		        if (fila.moveToFirst()) {
		            et2.setText(fila.getString(0));
		            et3.setText(fila.getString(1));
		            et4.setText(fila.getString(2));
		            et5.setText(fila.getString(3));
		            et6.setText(fila.getString(4));
		            et7.setText(fila.getString(5));
		        }else{
		            Toast.makeText(this, "No existe registro con este N° de Cédula",
		                    Toast.LENGTH_SHORT).show();
		        bd.close();
		        }
		   }
	    }
	   
	   
	   public void borrar(View v) {
		   if(et1.getText().toString().trim().length() == 0){
	            et1.setText("");
		        et2.setText("");
		        et3.setText("");
		        et4.setText("");
		        et5.setText("");
		        et6.setText("");
		        et7.setText("");
	            Toast.makeText(this, "Error, Ingrese un N° de Cedula",
	                    Toast.LENGTH_SHORT).show();
		   }else{
			   AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
		                "administracion", null, 1);
		        SQLiteDatabase bd = admin.getWritableDatabase();
		        String cedula = et1.getText().toString();
		        int cant = bd.delete("alquiladas", "cedula=" + cedula, null);
		        bd.close();
		        et1.setText("");
		        et2.setText("");
		        et3.setText("");
		        et4.setText("");
		        et5.setText("");
		        et6.setText("");
		        et7.setText("");
		        if (cant == 1){
		            Toast.makeText(this, "Se borró la persona con este N° de Cédula",
		                    Toast.LENGTH_SHORT).show();
		        }else{
		            Toast.makeText(this, "No existe registro con este N° de Cédula",
		                    Toast.LENGTH_SHORT).show();
		        }
		   }
	    }
	   
	   
	   public void modificar(View v) {
		   if(et1.getText().toString().trim().length() == 0){
	            et1.setText("");
		        et2.setText("");
		        et3.setText("");
		        et4.setText("");
		        et5.setText("");
		        et6.setText("");
		        et7.setText("");
	            Toast.makeText(this, "Error, Ingrese un N° de Cedula",
	                    Toast.LENGTH_SHORT).show();
		   }else{

		        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
		                "administracion", null, 1);
		        SQLiteDatabase bd = admin.getWritableDatabase();
		        String cedula = et1.getText().toString();
		        String nombre = et2.getText().toString();
		        String bicicleta = et3.getText().toString();
		        String salFecha = et4.getText().toString();
		        String salHora = et5.getText().toString();
		        String regFecha = et6.getText().toString();
		        String regHora = et7.getText().toString();
		        ContentValues registro = new ContentValues();
		        registro.put("nombre", nombre);
		        registro.put("colegio", bicicleta);
		        registro.put("nromesa", salFecha);
		        registro.put("nromesa", salHora);
		        registro.put("nromesa", regFecha);
		        registro.put("nromesa", regHora);
		        int cant = bd.update("alquiladas", registro, "cedula=" + cedula, null);
		        bd.close();
		        if (cant == 1){
		            Toast.makeText(this, "se han modifido los datos", Toast.LENGTH_SHORT)
		                    .show();
		        }else{
		            Toast.makeText(this, "No existe registro con este N° de Cédula",
		                    Toast.LENGTH_SHORT).show();
		        }
		   }
	    }
	   
	   
	   public void limpiar(View v){
	        et1.setText("");
	        et2.setText("");
	        et3.setText("");
	        et4.setText("");
	        et5.setText("");
	        et6.setText("");
	        et7.setText("");
            Toast.makeText(this, "Se ha limpiado la pantalla",
                    Toast.LENGTH_SHORT).show();
	   }
	   
}
