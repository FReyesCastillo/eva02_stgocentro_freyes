package com.example.eva02_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eva02_freyes.database.AdminSQLiteOpenHelper;

public class Sqlite_act extends AppCompatActivity {

    private EditText codigo, nombre, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        codigo = findViewById(R.id.txtCodigo);
        nombre = findViewById(R.id.txtNombre);
        precio = findViewById(R.id.txtValor);

    }

    public  void guardarProducto(View view){

        //Obtengo base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"generic",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Permite sobreescribir en base de datos.
        String codigoProducto = codigo.getText().toString();
        String nombreProducto = nombre.getText().toString();
        String precioProducto = precio.getText().toString();

        if(!codigoProducto.isEmpty() && !nombreProducto.isEmpty() && !precioProducto.isEmpty()){
            //Guardar datos
            ContentValues cont = new ContentValues(); //Para contener valores
            cont.put("codigo_producto",codigoProducto);
            cont.put("nombre_producto",nombreProducto);
            cont.put("precio_producto",precioProducto);

            db.insert("productos",null,cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has guardado un producto", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getBaseContext(),"Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
        }
    }

    public  void mostrarProducto(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"generic",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigoProducto = codigo.getText().toString();

        if(!codigoProducto.isEmpty()){

            //Mostrar campos
            Cursor file = db.rawQuery("SELECT nombre_producto,precio_producto FROM productos WHERE codigo_producto ="+codigoProducto, null);

            if(file.moveToFirst()){
                nombre.setText(file.getString(0));
                precio.setText(file.getString(1));

            }
            else{
                Toast.makeText(getBaseContext(),"No hay producto asociado al codigo consultado", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(getBaseContext(),"El campo código está vacío", Toast.LENGTH_SHORT).show();
        }
    }

    public  void eliminarProducto(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"generic",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigoProducto = codigo.getText().toString();

        if(!codigoProducto.isEmpty()){

            //Eliminar datos
            db.delete("productos","codigo_producto="+codigoProducto,null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has eliminado el producto "+codigoProducto, Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getBaseContext(),"El campo código está vacío", Toast.LENGTH_SHORT).show();
        }
    }

    public  void actualizarProducto(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"generic",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Permite sobreescribir en base de datos.

        String codigoProducto = codigo.getText().toString();
        String nombreProducto = nombre.getText().toString();
        String precioProducto = precio.getText().toString();

        if(!codigoProducto.isEmpty() && !nombreProducto.isEmpty() && !precioProducto.isEmpty()){


            ContentValues cont = new ContentValues(); //Para contener valores
            cont.put("nombre_producto",nombreProducto);
            cont.put("precio_producto",precioProducto);

            db.update("productos",cont,"codigo_producto="+codigoProducto,null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has actualizado producto "+codigoProducto, Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getBaseContext(),"Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
        }
    }

    public void Clean(){

        codigo.setText("");
        nombre.setText("");
        precio.setText("");

    }

}