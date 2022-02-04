package com.example.fashion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fashion.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;

public class RegisterActivity extends AppCompatActivity {
    Button account_button;
    TextView Sign_in, username, phone, email, password, confirm_password,address;
    String identity="1",typemasterid="1";
    private static final int RC_SIGN_IN = 101;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );


        account_button = findViewById( R.id.account_button );
        Sign_in = findViewById( R.id.Sign_in );
        username = findViewById( R.id.username );
        phone = findViewById( R.id.phone );
        email = findViewById( R.id.email );
        password = findViewById( R.id.password );
        confirm_password = findViewById( R.id.confirm_password );
        address=findViewById( R.id.location );


        account_button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
//                @Override public void onClick(View v) {
//                    doPhoneLogin();
//                }

                if (validateData()) {
                    Toast.makeText( RegisterActivity.this, "hello", Toast.LENGTH_SHORT ).show();
                    serviceRegister( username.getText().toString(), phone.getText().toString(),
                            address.getText().toString() ,identity,typemasterid,password.getText().toString());
                }
            }
        } );
        Sign_in.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( RegisterActivity.this, LoginActivity.class );
                startActivity( intent );
            }
        } );
    }

//    private void doPhoneLogin() {
//        Intent intent = AuthUI.getInstance().createSignInIntentBuilder()
//                .setIsSmartLockEnabled(!BuildConfig.DEBUG)
//                .setAvailableProviders(Collections.singletonList(
//                        new AuthUI.IdpConfig.PhoneBuilder().build()))
//                .setLogo(R.mipmap.ic_launcher)
//                .build();
//        startActivityForResult(intent, RC_SIGN_IN);
//    }

    private void serviceRegister(String user_name, String phone, String address,String identity,String typemasterid,String password) {
        try {
            Toast.makeText( getApplicationContext(), "check", Toast.LENGTH_SHORT ).show();
            DataManager dataManager = DataManager.getDataManager();
            dataManager.registeruser( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();
                    if (model != null) {
                        String successcode = "200", failurecode = "400";
                        String statuscode = (model.getStatus()).trim();

                        if (statuscode.equals( failurecode )) {

                            Toast.makeText( getApplicationContext(), model.getMessage(), Toast.LENGTH_SHORT ).show();

                        } else if (statuscode.equals( successcode )) {
                            //database edit
//                            Intent intent = new Intent( RegisterActivity.this, OTPActivity.class );
//                            startActivity( intent );
                            Toast.makeText( getApplicationContext(), model.getMessage(), Toast.LENGTH_SHORT ).show();

                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "Register successfully ", Toast.LENGTH_SHORT ).show();
                }
            }, user_name, phone, address,identity,typemasterid, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean validateData() {
        if (username.getText().length() == 0) {
            username.setError( "required" );
            username.requestFocus();
        } else if (phone.getText().length() == 0) {
            phone.setError( "required" );
            phone.requestFocus();
        }  else if (password.getText().length() == 0) {
            password.requestFocus();
            password.setError( "required" );
        } else if (confirm_password.getText().length() == 0) {
            confirm_password.requestFocus();
            confirm_password.setError( "required" );
        } else if (!password.getText().toString().equals( confirm_password.getText().toString() )) {
            confirm_password.requestFocus();
            confirm_password.setError( "Password does not match" );
        } else {
            return true;
        }
        return false;
    }

}