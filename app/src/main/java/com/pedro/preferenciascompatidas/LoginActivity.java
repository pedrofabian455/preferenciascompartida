package com.pedro.preferenciascompatidas;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private CheckBox checkBoxRecordar;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_login);
        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        passwordText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView textView, int actionId, keyEvent KeyEvent) {
                iƒ(actionId == EditorInfo.INT.NULL) {
                    intentarLogin();
                    return true;
                }
                return false;
            }

        }); Button btnIniciarSesionEmail = (Button) findViewById(R.id.btnIniciarSesionEmail);
        btnIniciarSesionEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public voiď onClick(View view) {
                intentarLogin();
            }
        });
        checkBoxRecordar = (CheckBox) findViewById(R.id.checkRecordar);
        if (!new PreferenciaManager(this).isUsuarioLogedOut()) {
            startNoneActivity();

        }
    }

    private void intentarLogin() {
        emailText.setError(null);
        passwordTexrt.setError(null);
        String email = emailText.getText().toString();
        boolean cancelar = false;
        View focusView = null;
        if(TextUtils.isEmpty(password) && !isPasswordValido(password)){
            passwordText.setError(getString(R.string.error_password_invalido));

            focusView = passwordText;
            cancelar = true;
            if(TextUtils.isEmpty(email)){
                emailText.setError(getString(R.string.error_campo_requerido));
                focusView = emailText;
                cancelar = true;

            }else if(!IsEmailValido(email)){
                emailText.setError(getString(R.string.error_email_invalido));
                focusView = emailText;
                cancelar = true;
            }
            if(cancelar = true){
                focusView.requestFocus();

            }else{
                if(checkBoxRecordar.isChecked())
                    salvarLoginDetalles(email, password);
                startNoneActivity

            }
        }
        private void startNoneActivity(){
            Intent intent = new intent(this, NoneActivity.class);
            startActivity(intent);
            finish();
        }
        private void salvarLoginDetalles(String email, String password){
            new PreferenciaManager(this).salvarLoginDetalles(email, password);

      }
        private boolean isEmailValido(String email){
            return email.contains("@");

        }
        private boolean isPasswordValido(String password){
            return password.length() > 4;
        }

    }
}



