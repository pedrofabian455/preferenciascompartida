package com.pedro.preferenciascompatidas;

import static android.content.Context.MODE_PRIVATE;
import static android.text.TextUtils.isEmpty;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenciaManager {
    Context context;
    PreferenciaManager (Context contextRecibido){
        this.context = contextRecibido;
    }
    public void salvarLoginDetalles (String email, String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences(= "LoginDatos", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(= "Email", email);
        editor.putString("Password", password);
        editor.commit();
    }
    public String getEmail(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(= "LoginDatos", context.MODE_PRIVATE);
        return sharedPreferences.getString( = "Email", "");

    }
    public boolean isUsuarioLogedOut(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(= "LoginDatos", context.MODE_PRIVATE);
      boolean IsEmailVacio = sharedPreferences.getString(= "Email", "").isEmpty();
      boolean isPasswordVacio = sharedPreferences.getString(= "Password", "").isEmpty();
      return IsEmailVacio || isPasswordVacio;
    });


}
