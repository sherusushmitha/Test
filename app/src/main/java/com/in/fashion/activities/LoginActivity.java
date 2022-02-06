package com.in.fashion.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fashion.R;
import com.in.fashion.SideNavigation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;
import utilities.UsersData;

public class LoginActivity extends AppCompatActivity {
    TextView Sing_up, username, password;
    TextView forgot_password;
    Button button;
    EditText mobile;
    String identity="1";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );


        Sing_up = findViewById( R.id.Sing_up );
        forgot_password = findViewById( R.id.forgot_password );
        button = findViewById( R.id.button );
        username = findViewById( R.id.username );
        password = findViewById( R.id.password );
        mobile = findViewById( R.id.mobile );

        ImageView facebookButton = (ImageView) findViewById(R.id.facebook);
        ImageView googleButton=(ImageView) findViewById( R.id.google );

        googleButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com."));
                startActivity(browserIntent);

            }
        } );


        facebookButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/MDSaziburRahmanBD"));
                startActivity(browserIntent);

            }
        } );




        Sing_up.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this, RegisterActivity.class );
                startActivity( intent );
            }
        });
        forgot_password.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                showDialogBox();
            }
        });

        button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent1=new Intent(LoginActivity.this, SideNavigation.class );
//                startActivity( intent1 );
                if (validateData()) {
                    Toast.makeText( LoginActivity.this, "hello", Toast.LENGTH_SHORT ).show();
                    serviceLogin( username.getText().toString(), password.getText().toString() );
                }
            }
        });


    }

    private void showDialogBox() {
        ViewGroup viewGroup = findViewById( android.R.id.content );

        View view = LayoutInflater.from( getApplicationContext() ).inflate( R.layout.recovry, viewGroup, false );
        Button submit = view.findViewById( R.id.button );
        mobile = view.findViewById( R.id.mobile );


        AlertDialog.Builder builder = new AlertDialog.Builder( LoginActivity.this );
        builder.setView( view );//setting view to  dialog
        //Creating dialog box
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        submit.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                    alertDialog.dismiss();
                if (validateData1()) {
                    Toast.makeText( LoginActivity.this, "hello", Toast.LENGTH_SHORT ).show();
                    serviceForgot( mobile.getText().toString() );
                }

            }
        } );


    }

//    public void showHidePassword(View view, ImageView imageView, EditText editText) {
//        if (view.getId() == imageView.getId()) {
//            if (editText.getTransformationMethod().equals( PasswordTransformationMethod.getInstance())) {
//                ((ImageView) (view)).setImageResource(R.drawable.ic_baseline_visibility_24);
//                //Show Password
//                editText.setTransformationMethod( HideReturnsTransformationMethod.getInstance());
//            } else {
//                ((ImageView) (view)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
//                //Hide Password
//                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
//            }
//            editText.setSelection(editText.getText().length());
//        }
//    }


    private void serviceLogin(String user_name, String password) {
        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.userlogin( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();
                    if (model != null) {
                        String statuscode = (model.getStatus()).trim();
                        String successcode = "200", failurecode = "400";

                        if (statuscode.equals(failurecode)) {

                           Toast.makeText(LoginActivity.this, model.getMessage(), Toast.LENGTH_SHORT).show();

                        } else if (statuscode.equals(successcode)) {

                                UsersData usersData=model.getUsersdata();

                            sharedPreferences = getSharedPreferences("Agribiz", 0);
                            editor = sharedPreferences.edit();
                            editor.putString("id", usersData.getId());
                            editor.putString("Token", usersData.getToken());
                            editor.putString("type", usersData.getTypemasterinfo());
                            editor.apply();
                            editor.commit();
                            Intent intent=new Intent(LoginActivity.this, SideNavigation.class);
                            startActivity( intent );
                            finish();

                            //database edit
//                            Toast.makeText(LoginActivity.this, model.getMessage(), Toast.LENGTH_SHORT).show();
//
//                            Intent intent=new Intent(LoginActivity.this,SideNavigation.class);
//                            startActivity( intent );


                           }
                        }
                    }


                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, user_name, password,identity );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void serviceForgot(String mobile) {
        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.forgotpassword( new Callback<Model>() {
               @Override
                public void onResponse(Call<Model> call, Response<Model> response) {


//                    Model model = response.body();
//                     if (model != null) {
//                        String statuscode = (model.getSuccess()).trim();
//                        String successcode = "1", failurecode = "0";
//
//                        if (statuscode.equals(failurecode)) {
//
//                            Toast.makeText(LoginActivity.this, model.getMessage(), Toast.LENGTH_SHORT).show();
//
//                        } else if (statuscode.equals(successcode)) {
//                            //database edit
//
//                            if(model.getLoginData()!=null) {
//                                Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
//
//                                startActivity(intent);
//                            }
//                        }
//                    }



                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, mobile );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean validateData() {
        if (username.getText().length() == 0) {
            username.setError( "required" );
            username.requestFocus();
        } else if (password.length() == 0) {
            password.requestFocus();
            password.setError( "required" );
        } else {
            return true;
        }
        return false;
    }

    private boolean validateData1() {
        if (mobile.getText().length() == 0) {
            mobile.setError( "required" );
            mobile.requestFocus();
        } else if (mobile.getText().length() < 10) {
            mobile.setError( "required" );
            mobile.requestFocus();
        } else {
            return true;
        }
        return false;
    }
}

